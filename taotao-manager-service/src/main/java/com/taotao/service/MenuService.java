package com.taotao.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

public interface MenuService {

	Map<String, Object> getMenuList(HttpServletRequest request);
}
