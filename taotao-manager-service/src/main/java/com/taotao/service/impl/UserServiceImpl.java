package com.taotao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.BaseResult;
import com.taotao.common.redis.JeditCommon;
import com.taotao.common.utils.DateUtil;
import com.taotao.common.utils.ShaUtil;
import com.taotao.mapper.TbDeptMapper;
import com.taotao.mapper.TbPositionMapper;
import com.taotao.mapper.TbUserMapper;
import com.taotao.mapperCust.TbMenuMapperCust;
import com.taotao.pojo.TbDept;
import com.taotao.pojo.TbPosition;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;
import com.taotao.service.UserService;

/**
 * 商品管理Service
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月2日上午10:47:14
 * @version 1.0
 */
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
	TbMenuMapperCust tbMenuMapperCust;
	

	@Override
	public Map<String, Object> checkPassword(HttpServletRequest request) {
		BaseResult baseResult = new BaseResult();
		String password = request.getParameter("password");
		String loginName =request.getParameter("loginName");
	    TbUser user = loadUserInfoCache(loginName);
	    if (user != null ) {
			String pwd = user.getPassword();
			String sha256Pass =ShaUtil.encode(password,"");
			if(pwd.equals(sha256Pass)){
				return baseResult.getSuccMap();
			}else{
				return baseResult.getErrorJsonObj("密码不正确");
			}
		}else{
			return baseResult.getErrorJsonObj("用户不存在");
		}
	}


	@Override
	public Map<String, Object> changePwd(Map<String,String> map) {
		BaseResult baseResult = new BaseResult();
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
  				u.setUpdateDate(dateAndTime);
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
		BaseResult baseResult = new BaseResult();
	    String loginName = map.get("loginName").toString();
	    //添加查询条件
  		TbUserExample example = new TbUserExample();
  		Criteria criteria = example.createCriteria();
  		criteria.andLoginNameEqualTo(loginName);
		criteria.andIsDeleteNotEqualTo("-1");
  		List<TbUser> list = tbUserMapper.selectByExample(example);
  		if (list != null && list.size() > 0) {
  			TbUser user = list.get(0);
  			Long positionId = user.getPositionId();
  			Long deptId = user.getDeptId();
  			TbDept dept = tbDeptMapper.selectByPrimaryKey(deptId);
  			TbPosition position = tbPositionMapper.selectByPrimaryKey(positionId);
  			Map<String,Object> m=new HashMap<String, Object>();
  			m.put("tbUser", user);
  			m.put("tbDept", dept);
  			m.put("tbPosition", position);
  			return baseResult.getSuccMap(m);
  		}else{
  			return baseResult.getErrorJsonObj("用户不存在");
  		}
	}
	
	public TbUser loadUserInfoCache(String loginName) {
  		TbUserExample example = new TbUserExample();
  		Criteria criteria = example.createCriteria();
  		criteria.andLoginNameEqualTo(loginName);
		criteria.andIsDeleteNotEqualTo("-1");
  		List<TbUser> list = tbUserMapper.selectByExample(example);
  		if (list != null && list.size() > 0) {
  			TbUser user = list.get(0);
			String tokenKey = UUID.randomUUID().toString().replace("-","");
			String resource = JeditCommon.get("resourceMap");
			Map map= JSONObject.parseObject(resource, Map.class);
			
			JeditCommon.setex(tokenKey, Integer.parseInt(map.get("redis_expire").toString()), JSONObject.toJSONString(user));
			JeditCommon.setex(user.getLoginName(), Integer.parseInt(map.get("redis_expire").toString()), tokenKey);
  			return list.get(0);
  		}else{
  			return null;
  		}
	}



	@Override
	public Map<String, Object> getUserList(Map<String,String> map) {
		BaseResult baseResult = new BaseResult();
		String loginName = map.get("loginName");
		String qryUserName = map.get("qryUserName");
		String pageNum = map.get("pageNum");
		String pageSize = map.get("pageSize");
		String token = JeditCommon.get(loginName);
		TbUser user= JSONObject.parseObject(JeditCommon.get(token), TbUser.class);
		Long roleId = user.getRoleId();
		//添加查询条件
		PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
  		TbUserExample example = new TbUserExample();
  		Criteria criteria = example.createCriteria();
  		criteria.andRoleIdEqualTo(roleId);
		criteria.andIsDeleteNotEqualTo("-1");
		if(StringUtils.isNotBlank(qryUserName)){
			criteria.andUserNameLike("%"+qryUserName+"%");
		}
  		List<TbUser> list = tbUserMapper.selectByExample(example);
		PageInfo<TbUser> pageInfo = new PageInfo<>(list);
  		return baseResult.getSuccMap(pageInfo);
	}
}
