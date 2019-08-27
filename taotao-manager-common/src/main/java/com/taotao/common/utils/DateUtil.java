package com.taotao.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具类
 * 
 * @author cg.yang
 * @version $Id: DateUtil.java, v 0.1 2013-8-15 下午9:05:57 cg.yang Exp $
 */
public class DateUtil {

	private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String DATE_PATTERN_SLASH = "yyyy/MM/dd";
	public static final String DATE_NUMBER_PATTERN = "yyyyMMdd";
	public static final String TIME_NUMBER_PATTERN = "HHmmss";
	public static final String DATE_TIME_PATTERN = "yyyyMMddHHmmss";

	private static final String[] week = new String[] { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };

	/**
	 * 获取日期字符串，格式：yyyyMMdd
	 * 
	 * @return
	 */
	public static String getDate() {
		return getFormatString(DATE_NUMBER_PATTERN);
	}

	/**
	 * 获取时间字符串，格式：HHmmss
	 * 
	 * @return
	 */
	public static String getTime() {
		return getFormatString(TIME_NUMBER_PATTERN);
	}

	/**
	 * 获取时间字符串，格式：yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getDateAndTime() {
		return getFormatString(DATE_TIME_PATTERN);
	}

	/**
	 * 获取相隔指定天数的时间，格式：yyyyMMddHHmmss
	 * 
	 * @param days
	 *            - 指定的相隔天数，如：-1表示前一天
	 * @return Time String.
	 */
	public static String getDateAndTime(int days) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN);
		java.util.Date dateCurrent = new java.util.Date();
		String currentTime = sdf.format(new Date(dateCurrent.getTime() + (long) days * 24 * 60 * 60 * 1000));
		return currentTime;
	}

	/**
	 * 获取标准格式的日期字符串，格式：yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String getDateFormatStr(String date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		return sdf.format(stringToDate(date));
	}

	/**
	 * 获取标准格式的日期字符串，格式：yyyy/MM/dd
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String getDateFormatSlash(String date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_SLASH);
		return sdf.format(stringToDate(date));
	}

	/**
	 * 计算两个日期的间隔天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return int
	 */
	public static int getDays(String startDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_NUMBER_PATTERN);
		long start = 0;
		long end = 0;
		try {
			start = sdf.parse(startDate).getTime();
			end = sdf.parse(endDate).getTime();
		} catch (ParseException e) {
			logger.error("日期格式错误", e);
		}

		return new Long((end - start) / (1000 * 60 * 60 * 24)).intValue();
	}

	
	/**
	 * 计算两个日期时间的间隔秒数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return int
	 */
	public static long getSeconds(String startDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN);
		long start = 0;
		long end = 0;
		try {
			start = sdf.parse(startDate).getTime();
			end = sdf.parse(endDate).getTime();
		} catch (ParseException e) {
			logger.error("日期格式错误", e);
		}
		return new Long((end - start)/1000);
	}
	/**
	 * 为日期字符串增加分隔符
	 * <P>
	 * 输入：yyyyMMdd
	 * </P>
	 * <P>
	 * 输出：yyyy-MM-dd
	 * </P>
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String addBarToDateString(String dateStr) {
		StringBuffer sb = new StringBuffer();

		if (StringProcUtils.isNull(dateStr)) {
			return dateStr;
		}

		if (StringProcUtils.trim(dateStr).length() != 8) {
			return dateStr;
		}

		sb.append(dateStr.substring(0, 4));
		sb.append("-").append(dateStr.substring(4, 6));
		sb.append("-").append(dateStr.substring(6));

		return sb.toString();
	}

	/**
	 * 为日期字符串清除分隔符
	 * <P>
	 * 输入：yyyy-MM-dd
	 * </P>
	 * <P>
	 * 输出：yyyyMMdd
	 * </P>
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String removeBarFromDateString(String dateStr) {
		StringBuffer sb = new StringBuffer();

		if (StringProcUtils.isNull(dateStr)) {
			return dateStr;
		}

		if (StringProcUtils.trim(dateStr).length() != 10) {
			return dateStr;
		}

		sb.append(dateStr.substring(0, 4));
		sb.append(dateStr.substring(5, 7));
		sb.append(dateStr.substring(8));

		return sb.toString();
	}

	/**
	 * 为日期字符串增加分隔符
	 * <P>
	 * 输入：HHmmss
	 * </P>
	 * <P>
	 * 输出：HH:mm:ss
	 * </P>
	 * 
	 * @param timeStr
	 * @return
	 */
	public static String addColonToTimeString(String timeStr) {
		StringBuffer sb = new StringBuffer();

		if (StringProcUtils.isNull(timeStr)) {
			return timeStr;
		}

		if (StringProcUtils.trim(timeStr).length() != 6) {
			return timeStr;
		}

		sb.append(timeStr.substring(0, 2));
		sb.append(":").append(timeStr.substring(2, 4));
		sb.append(":").append(timeStr.substring(4));

		return sb.toString();
	}

	/**
	 * 为日期字符串增加分隔符
	 * <P>
	 * 输入：HH:mm:ss
	 * </P>
	 * <P>
	 * 输出：HHmmss
	 * </P>
	 * 
	 * @param timeStr
	 * @return
	 */
	public static String removeColonFromTimeString(String timeStr) {
		StringBuffer sb = new StringBuffer();

		if (StringProcUtils.isNull(timeStr)) {
			return timeStr;
		}

		if (StringProcUtils.trim(timeStr).length() != 8) {
			return timeStr;
		}

		sb.append(timeStr.substring(0, 2));
		sb.append(timeStr.substring(3, 5));
		sb.append(timeStr.substring(6));

		return sb.toString();
	}

	/**
	 * 为日期+时间字符串增加分隔符
	 * <P>
	 * 输入：yyyyMMddHHmmss
	 * </P>
	 * <P>
	 * 输出：yyyy-MM-dd HH:mm:ss
	 * </P>
	 * 
	 * @param timeStr
	 * @return
	 */

	public static String addBarAndColonToDateString(String dateTimeStr) {
		StringBuffer sb = new StringBuffer();

		if (StringProcUtils.isNull(dateTimeStr)) {
			return dateTimeStr;
		}

		if (StringProcUtils.trim(dateTimeStr).length() != 14) {
			return dateTimeStr;
		}

		String dateStr = dateTimeStr.substring(0, 8);
		sb.append(addBarToDateString(dateStr));

		sb.append(" ");

		String timeStr = dateTimeStr.substring(8);
		sb.append(addColonToTimeString(timeStr));

		return sb.toString();
	}

	/**
	 * 比较两个日期的大小，参数格式：yyyyMMdd
	 * <P>
	 * 返回值：<BR/>
	 * -1:前值大于后值 <BR/>
	 * 1:前值小于后值 <BR/>
	 * 0:两者相等
	 * </P>
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static int dateCompare(String v1, String v2) {
		SimpleDateFormat df = new SimpleDateFormat(DATE_NUMBER_PATTERN);
		try {
			Date d1 = df.parse(v1);
			Date d2 = df.parse(v2);
			if (d1.getTime() < d2.getTime()) {
				return 1;
			} else if (d1.getTime() > d2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (ParseException e) {
			logger.error("日期格式错误", e);
		}
		return 0;
	}

	// ~ ==========================================
	/**
	 * 返回pattern格式的字符串
	 * 
	 * @param pattern
	 * @return
	 */
	private static String getFormatString(String pattern) {
		if (StringProcUtils.isNull(pattern)) {
			return null;
		}

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 字符串类型转换为日期类型
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private static Date stringToDate(String str) throws Exception {
		if (StringProcUtils.isNull(str)) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_NUMBER_PATTERN);
		return sdf.parse(str);
	}

	/**
	 * 日期类型转换为字符串类型
	 * 
	 * @param date
	 * @return
	 */
	private static String dateToString(Date date) {
		if (date == null) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_NUMBER_PATTERN);
		return sdf.format(date);
	}

	// ~ ===========================================
	/**
	 * 为日期字符串清除分隔符
	 * 
	 * <P>
	 * 已由 <i>DateUtils.removeBarFromDateString()</i> 方法替代
	 * </P>
	 * 
	 * @param str
	 * @return
	 */
	@Deprecated
	public static String stringPatTostring(String str) {
		if (StringProcUtils.isNull(str)) {
			return null;
		}

		return str.substring(0, 4) + str.substring(5, 7) + str.substring(8, 10);
	}

	/**
	 * 将指定字符串转换为<i>yyyy-MM-dd HH:mm:ss</i>格式
	 * 
	 * @param str
	 * @return
	 */
	@Deprecated
	public static String formatDate(String str) {
		if (StringProcUtils.isNull(str)) {
			return null;
		}

		return str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8) + " " + str.substring(8, 10)
				+ ":" + str.substring(10, 12) + ":" + str.substring(12, 14);
	}

	/**
	 * 将指定字符串转换为<i>HH:mm:ss</i>格式
	 * 
	 * @param str
	 * @return
	 */
	@Deprecated
	public static String formatTime(String str) {
		if (StringProcUtils.isNull(str)) {
			return null;
		}

		return str.substring(0, 2) + ":" + str.substring(2, 4) + ":" + str.substring(4, 6);
	}

	/**
	 * 日期格式转换
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	@Deprecated
	public static String formatString(String dateStr, String pattern) {
		if (StringProcUtils.isNull(dateStr)) {
			return null;
		}

		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_NUMBER_PATTERN);
			SimpleDateFormat sdf2 = new SimpleDateFormat(pattern);
			Date d = sdf.parse(dateStr);
			return sdf2.format(d);
		} catch (ParseException e) {
			logger.error("日期转换错误", e);
			return null;
		}
	}

	/**
	 * 为日期字符串增加分隔符
	 * <P>
	 * 已由 <i>DateUtils.addBarFromDateString()</i> 方法替代
	 * </P>
	 * 
	 * @param dateStr
	 * @param separator
	 * @return
	 */
	public static String addLineDateString(String dateStr, String separator) {
		if (dateStr == null || dateStr.trim().length() != 8)
			return dateStr;

		String year = dateStr.substring(0, 4);
		String month = dateStr.substring(4, 6);
		String day = dateStr.substring(6, 8);
		dateStr = year + separator + month + separator + day;
		return dateStr;
	}

	/**
	 * 
	 * 根据结束日期(yyyy-MM-dd）获取最近相隔intervalMonth月的开始日期(yyyy-MM-dd)
	 * 
	 * @param intervalMonth
	 * @return
	 */
	public static String getStartDateM(String endDate, int intervalMonth) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat(DATE_PATTERN);
		Date eDate = df.parse(endDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(eDate);
		cal.add(Calendar.MONTH, -intervalMonth);
		Date startDate = cal.getTime();
		return df.format(startDate);
	}

	/**
	 * 
	 * 根据结束日期(yyyy-MM-dd）获取最近相隔intervalDay月的开始日期(yyyy-MM-dd)
	 * 
	 * @param intervalDay
	 * @return
	 */
	public static String getStartDateD(String endDate, int intervalDay) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat(DATE_PATTERN);
		Date eDate = df.parse(endDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(eDate);
		cal.add(Calendar.DAY_OF_MONTH, -intervalDay);
		Date startDate = cal.getTime();
		return df.format(startDate);
	}

	public static String getModifyFeeRatio(String eventValue) {
		String[] eventV = eventValue.split("[|]");
		if (eventV.length < 3) {
			return null;
		} else
			return eventV[1];
	}

	/**
	 * 通过竖线分隔符获取字符串数组
	 * 
	 * @param str
	 * @return
	 */
	private static String[] getArraysByVerticalLine(String str) {
		return str.split("[|]");
	}
	
	 /**
     * 日期格式校验，yyyyMMdd
     * @param date
     * @return
     */
    public static boolean checkDayFormat(String date) {
    	SimpleDateFormat format = new SimpleDateFormat(DATE_NUMBER_PATTERN);
    	try {
    		format.setLenient(false);
    		format.parse(date);
    	} catch (ParseException e) {
    		return false;
    	}
    	return true;
    }

}