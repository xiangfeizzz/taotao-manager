package com.taotao.service.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.common.pojo.BaseResult;
import com.taotao.common.utils.DateUtil;
import com.taotao.mapper.TbHolidayMapper;
import com.taotao.pojo.TbHoliday;
import com.taotao.service.HolidayService;

@Service
public class HolidayServiceImpl implements HolidayService {

	@Autowired
	TbHolidayMapper tbHolidayMapper;
	BaseResult baseResult = new BaseResult();
	
	
	@Override
	public Map<String, Object> holidayAdd(Map<String, String> map) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			TbHoliday holiday = objectMapper.convertValue(map, TbHoliday.class);
			holiday.setCreateTime(DateUtil.getDateAndTime());
			String startTime = holiday.getStartTime();
			String endTime = holiday.getEndTime();
  			if(StringUtils.isNotBlank(startTime)){
  				holiday.setStartTime(startTime.replace("-",""));
  			}
  			if(StringUtils.isNotBlank(endTime)){
  				holiday.setEndTime(endTime.replace("-",""));
  			}
  			holiday.setCreateTime(DateUtil.getDateAndTime());
			tbHolidayMapper.insertSelective(holiday);
			return baseResult.getSuccMap();
		} catch (Exception e) {
			e.printStackTrace();
			return baseResult.getErrorJsonObj("网络繁忙，请稍后再试");
		}
	}
	
}
