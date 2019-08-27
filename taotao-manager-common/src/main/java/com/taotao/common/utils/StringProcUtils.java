package com.taotao.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 字符串处理工具类
 * 
 * @author ruoqi.du
 *
 */
public class StringProcUtils {

	/**
	 * 判断字符串是否为空值（含：Null、Empty、空格）
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isNull(String input) {
		if (input == null || input.trim().length() == 0)
			return true;

		return false;
	}

	/**
	 * 判断字符串是否满足最大长度
	 * 
	 * @param str
	 * @param len
	 * @return
	 */
	public static boolean isMaxLength(String str, int len) {
		if (str.length() <= len) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否满足最小长度
	 * 
	 * @param str
	 * @param len
	 * @return
	 */
	public static boolean isMinLength(String str, int len) {
		if (str.length() >= len) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否符合指定长度
	 * 
	 * @param str
	 * @param len
	 * @return
	 */
	public static boolean isLength(String str, int len) {
		if (str.length() == len) {
			return true;
		}
		return false;
	}

	/**
	 * 向左补足字符串至指定长度
	 * 
	 * @param str
	 * @param len
	 * @param ch
	 * @return
	 */
	public static String leftPad(String str, int len, char ch) {
		StringBuffer sb = new StringBuffer(len);

		int p = len - str.length();

		for (int i = 0; i < len; i++) {
			if (i < p)
				sb.append(ch);
			else
				sb.append(str.charAt(i - p));
		}
		return sb.toString();
	}

	/**
	 * 向右补足字符串至指定长度
	 * 
	 * @param str
	 * @param len
	 * @param ch
	 * @return
	 */
	public static String rightPad(String str, int len, char ch) {
		byte[] byteStr = str.getBytes();
		int p = len - byteStr.length;
		String nstr = "";

		for (int i = 0; i < p; i++) {
			nstr = nstr + ch;
		}
		return str + nstr;
	}

	/**
	 * 获取脱敏后的银行卡号
	 * 
	 * @param cardNo
	 * @return
	 */
	public static String maskCardNo(String cardNo) {
		cardNo = trim(cardNo);
		if (cardNo.length() <= 10) {
			return cardNo;
		}
		String cardNoPrefix = cardNo.substring(0, 6);
		String cardNoSuffix = cardNo.substring(cardNo.length() - 4);

		StringBuffer sb = new StringBuffer(cardNo.length());
		sb.append(cardNoPrefix);
		for (int i = 6; i < cardNo.length() - 4; i++) {
			sb.append("*");
		}
		sb.append(cardNoSuffix);
		return sb.toString();
	}

	/**
	 * 字符串前后去空格（可兼容null值）
	 * 
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		if (str == null)
			return null;

		return str.trim();
	}

	/**
	 * 返回指定字符串的值。
	 * <P>
	 * 如果指定字符串为null或空格，则返回默认值
	 * </P>
	 * 
	 * @param value
	 * @param defValue
	 * @return
	 */
	public static String getStringByDefValue(String value, String defValue) {
		if (isNull(value)) {
			return defValue;
		}
		return value.trim();
	}

	/**
	 * 使用指定分隔符，将字符串转换为字符串集合
	 * 
	 * @param input
	 * @param splitChar
	 * @return
	 */
	public static List<String> stringToList(String input, String splitChar) {
		List<String> list = new ArrayList<String>();
		String[] arrays = input.split(splitChar);
		for (int i = 0; i < arrays.length; i++) {
			list.add(arrays[i]);
		}
		return list;
	}

	/**
	 * 使用逗号，将字符串集合拼接为字符串
	 * 
	 * @param list
	 * @return
	 */
	public static String listToString(List<String> list) {
		if (list == null || list.size() == 0) {
			return "";
		}

		/*
		 * 拼接字符串
		 */
		StringBuffer sb = new StringBuffer(128);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(",");
		}

		/*
		 * 截取最后一位
		 */
		if (sb.length() > 1) {
			return sb.substring(0, (sb.length()-1));
		}else{
			return "";
		}
	}

	/**
	 * GBK转UTF8
	 * 
	 * @param gbk
	 * @return
	 */
	public static String getUtf8(String gbk) {
		String utf8 = null;
		try {
			String unicode = new String(gbk.getBytes("GBK"), "ISO-8859-1");
			utf8 = new String(unicode.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		return utf8;
	}

	/**
	 * UTF8转GBK
	 * 
	 * @param utf8
	 * @return
	 */
	public static String getGbk(String utf8) {
		String gbk = null;
		try {
			String unicode = new String(utf8.getBytes("UTF-8"), "ISO-8859-1");
			gbk = new String(unicode.getBytes("ISO-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		return gbk;
	}

	/**
	 * 生成小额双免参数值
	 * 
	 * <P>
	 * Y/N：打开/关闭
	 * </P>
	 * 
	 * @param isDoubleFree
	 * @param isPasswdFree
	 * @param isApplePay
	 * @return
	 */
	@Deprecated
	public static String getParamValue(String isDoubleFree, String isPasswdFree, String isApplePay) {
		StringBuffer sb = new StringBuffer(3);

		/*
		 * 第1位：挥卡交易免密且免签
		 */
		if ("1".equals(trim(isDoubleFree))) {
			sb.append("Y");
		} else {
			sb.append("N");
		}

		/*
		 * 第2位：刷卡、插卡交易免签不免密
		 */
		if ("1".equals(trim(isPasswdFree))) {
			sb.append("Y");
		} else {
			sb.append("N");
		}

		/*
		 * 第3位：支持ApplePay
		 */
		if ("1".equals(trim(isApplePay))) {
			sb.append("Y");
		} else {
			sb.append("N");
		}
		return sb.toString();
	}

	/**
	 * 判断字符串数组中是否包含指定字符串
	 * 
	 * @param array
	 * @param str
	 * @return
	 */
	public static boolean contains(String[] array, String str) {
		if (isNull(str)) {
			return false;
		}

		str = trim(str);

		boolean ret = false;
		for (int i = 0; i < array.length; i++) {
			if (str.equals(array[i])) {
				ret = true;
				break;
			}
		}
		return ret;
	}
	
	/**
	 * 图片类型为“其他”的，重新排序，把不为空的住前排，空的放后
	 * 
	 * @param array
	 * @return array
	 */
	
	public static String[]  ImageSequence(String[] arry){
		String[] ret={"","","","","","",};  
		int j=0;
		for(int i=0;i<arry.length;i++){
			if(!isNull(arry[i])){
				ret[j++]=arry[i];
			}
		}
		return ret;
	}
	

	/**
	 * 比较两个字符串是否相等
	 * 
	 * @param s1
	 * @param s2
	 * @param ignoreCase
	 *            - 是否忽略大小写
	 * @return
	 */
	public static Boolean compare(String s1, String s2, Boolean ignoreCase) {
		s1 = StringProcUtils.trim(s1);
		s2 = StringProcUtils.trim(s2);

		if (s1 == null && s2 == null) {
			return true;
		}

		if (s1 == null || s2 == null) {
			return false;
		}

		if (ignoreCase) {
			if (s1.equalsIgnoreCase(s2))
				return true;
			else
				return false;
		} else {
			if (s1.equals(s2))
				return true;
			else
				return false;
		}
	}

}
