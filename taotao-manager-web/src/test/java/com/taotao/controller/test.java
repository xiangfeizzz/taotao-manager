package com.taotao.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Data;

public class test {
public static void main(String[] args) throws ParseException {
	
//	System.out.println(UUID.randomUUID().toString().replace("-",""));

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Data d=new Data();
		String str="2019-09-03 10:11:12";

        Date date=sdf.parse(str);
		
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -5);
		date = calendar.getTime();
		System.out.println(sdf.format(date));
}
}
