package com.taotao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.BaseResult;
import com.taotao.common.redis.JeditCommon;
import com.taotao.common.utils.DateUtil;
import com.taotao.common.utils.ShaUtil;
import com.taotao.mapper.TbDeptMapper;
import com.taotao.mapper.TbPositionMapper;
import com.taotao.mapper.TbRoleMapper;
import com.taotao.mapper.TbUserMapper;
import com.taotao.mapperCust.TbMenuMapperCust;
import com.taotao.pojo.TbDept;
import com.taotao.pojo.TbPosition;
import com.taotao.pojo.TbRole;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;
import com.taotao.service.UserService;
import com.taotao.validate.Validate;


@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	TbUserMapper tbUserMapper;
	@Autowired
	TbDeptMapper tbDeptMapper;
	@Autowired
	TbPositionMapper tbPositionMapper;
	@Autowired
	TbRoleMapper tbRoleMapper;
	@Autowired
	TbMenuMapperCust tbMenuMapperCust;
	@Autowired
	Validate validate;
	
	BaseResult baseResult = new BaseResult();
	

	@Override
	public Map<String, Object> doLogin(HttpServletRequest request) {
		String password = request.getParameter("password");
		String loginName =request.getParameter("loginName");
		HttpSession session =request.getSession(); 
		String sessionId = session.getId();
	    TbUser user = loadUserInfoCache(loginName,sessionId);
	    if (user != null ) {
			String pwd = user.getPassword();
			String sha256Pass =ShaUtil.encode(password,"");
			if(pwd.equals(sha256Pass)){
				return baseResult.getSuccMap(user);
			}else{
				return baseResult.getErrorJsonObj("密码不正确");
			}
		}else{
			return baseResult.getErrorJsonObj("用户不存在");
		}
	}


	@Override
	public Map<String, Object> changePwd(Map<String,String> map) {
		String oldPassword = map.get("oldPassword");
	    String password = map.get("password");
	    String loginName = map.get("loginName");
	    //添加查询条件
  		TbUserExample example = new TbUserExample();
  		Criteria criteria = example.createCriteria();
  		criteria.andLoginNameEqualTo(loginName);
		criteria.andIsDeleteNotEqualTo("-1");
  		List<TbUser> list = tbUserMapper.selectByExample(example);
  		if (list != null && list.size()>0) {
  			TbUser user = list.get(0);
  			String pwd = user.getPassword();
  			String sha256Pass =ShaUtil.encode(oldPassword,"");
  			if(pwd.equals(sha256Pass)){
  				//修改密码
  				String sha256PassNew =ShaUtil.encode(password,"");
  				String dateAndTime = DateUtil.getDateAndTime();
  				TbUser u=new TbUser();
  				u.setUserId(user.getUserId());
  				u.setPassword(sha256PassNew);
  				u.setUpdateTime(dateAndTime);
  				tbUserMapper.updateByPrimaryKeySelective(u);
  				return baseResult.getSuccMap();
  			}else{
  				return baseResult.getErrorJsonObj("原密码不正确");
  			}
  		}else{
  			return baseResult.getErrorJsonObj("用户不存在");
  		}
	}


	@Override
	public Map<String, Object> getUserInfo(Map<String,String> map) {
		try {
		    String userId = map.get("userId").toString();
		    TbUser user = tbUserMapper.selectByPrimaryKey(Integer.parseInt(userId));
	  		if (user != null ) {
	  			Integer positionId = user.getPositionId();
	  			Integer deptId = user.getDeptId();
	  			Integer roleId=user.getRoleId();
	  			TbDept dept = tbDeptMapper.selectByPrimaryKey(deptId);
	  			TbPosition position = tbPositionMapper.selectByPrimaryKey(positionId);
	  			TbRole role = tbRoleMapper.selectByPrimaryKey(roleId);
	  			Map<String,Object> m=new HashMap<String, Object>();
	  			
	  			String birth = user.getBirth();
	  			String hireDate = user.getHireDate();
	  			if(StringUtils.isNotBlank(birth)){
	  				birth=birth.substring(0, 8);
	  				user.setBirth(DateUtil.getDateFormatStr(birth));
	  			}
	  			if(StringUtils.isNotBlank(hireDate)){
	  				hireDate=hireDate.substring(0,8);
	  				user.setHireDate(DateUtil.getDateFormatStr(hireDate));
	  			}
	  				
	  			m.put("tbUser", user);
	  			m.put("tbDept", dept);
	  			m.put("tbPosition", position);
	  			m.put("tbRole", role);
	  			return baseResult.getSuccMap(m);
	  		}else{
	  			return baseResult.getErrorJsonObj("用户不存在");
	  		}
		} catch (Exception e) {
			e.printStackTrace();
			return baseResult.getErrorJsonObj("网络繁忙，请稍后再试");
		}
	}
	
	public TbUser loadUserInfoCache(String loginName,String sessionId) {
  		TbUserExample example = new TbUserExample();
  		Criteria criteria = example.createCriteria();
  		criteria.andLoginNameEqualTo(loginName);
		criteria.andIsDeleteNotEqualTo("-1");
  		List<TbUser> list = tbUserMapper.selectByExample(example);
  		if (list != null && list.size() > 0) {
  			TbUser user = list.get(0);
			String resource = JeditCommon.get("resourceMap");
			Map map= JSONObject.parseObject(resource, Map.class);
			JeditCommon.setex(sessionId, Integer.parseInt(map.get("redis_expire").toString()), JSONObject.toJSONString(user));
  			return list.get(0);
  		}else{
  			return null;
  		}
	}


	@Override
	public Map<String, Object> getUserList(Map<String,String> map,HttpServletRequest request) {
		String qryUserName = map.get("qryUserName");
		String pageNum = map.get("pageNum");
		String pageSize = map.get("pageSize");
		//添加查询条件
		PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
  		TbUserExample example = new TbUserExample();
  		Criteria criteria = example.createCriteria();
		criteria.andIsDeleteNotEqualTo("-1");
		if(StringUtils.isNotBlank(qryUserName)){
			criteria.andUserNameLike("%"+qryUserName+"%");
		}
  		List<TbUser> list = tbUserMapper.selectByExample(example);
		PageInfo<TbUser> pageInfo = new PageInfo<>(list);
  		return baseResult.getSuccMap(pageInfo);
	}


	@Override
	public Map<String, Object> userDel(Map<String, String> map) {
		String userId = map.get("userId");
		TbUser u=new TbUser();
		u.setUserId(Integer.parseInt(userId));
		u.setUpdateTime(DateUtil.getDateAndTime());
		u.setIsDelete("-1");
		tbUserMapper.updateByPrimaryKey(u);
		return baseResult.getSuccMap();
	}


	@Override
	public Map<String, Object> userAdd(Map<String, String> map){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			TbUser user = objectMapper.convertValue(map, TbUser.class);
			String errorMsg=validate.validateUser(user);
			if(StringUtils.isNotBlank(errorMsg)){
				return baseResult.getErrorJsonObj(errorMsg);
			}
			user.setCreateTime(DateUtil.getDateAndTime());
			user.setIsDelete("0");
			String birth = user.getBirth();
  			String hireDate = user.getHireDate();
  			if(StringUtils.isNotBlank(birth)){
  				user.setBirth(birth.replace("-",""));
  			}
  			if(StringUtils.isNotBlank(hireDate)){
  				user.setHireDate(hireDate.replace("-",""));
  			}
			
			String sha256Pass =ShaUtil.encode(user.getLoginName(),"");  //登录密码默认登录账号
			user.setPassword(sha256Pass);
			tbUserMapper.insertSelective(user);
			return baseResult.getSuccMap();
		} catch (Exception e) {
			e.printStackTrace();
			return baseResult.getErrorJsonObj("网络繁忙，请稍后再试");
		}
	}
	
	
	@Override
	public Map<String, Object> userUpd(Map<String, String> map){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			TbUser user = objectMapper.convertValue(map, TbUser.class);
			String errorMsg=validate.validateUser(user);
			if(StringUtils.isNotBlank(errorMsg)){
				return baseResult.getErrorJsonObj(errorMsg);
			}
			user.setUpdateTime(DateUtil.getDateAndTime());
			String birth = user.getBirth();
  			String hireDate = user.getHireDate();
			if(StringUtils.isNotBlank(birth)){
  				user.setBirth(birth.replace("-",""));
  			}
  			if(StringUtils.isNotBlank(hireDate)){
  				user.setHireDate(hireDate.replace("-",""));
  			}
			tbUserMapper.updateByPrimaryKeySelective(user);
			return baseResult.getSuccMap();
		} catch (Exception e) {
			e.printStackTrace();
			return baseResult.getErrorJsonObj("网络繁忙，请稍后再试");
		}
	}

}
