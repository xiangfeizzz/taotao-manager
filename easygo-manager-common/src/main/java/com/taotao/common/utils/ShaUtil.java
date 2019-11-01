package com.taotao.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author ruoqi.du
 *
 */
public class ShaUtil {

	public static final String SHA_256 = "SHA-256";

	/**
	 * 加密方法
	 * 
	 * @param strSrc
	 *            明文
	 * @param encName
	 *            加密算法
	 * @return
	 */
	public static String encode(String strSrc, String encName) {
		MessageDigest md = null;
		String strDes = null;

		byte[] bt = strSrc.getBytes();
		try {
			if (encName == null || encName.equals("")) {
				encName = SHA_256;
			}
			md = MessageDigest.getInstance(encName);
			md.update(bt);
			strDes = bytes2Hex(md.digest()); // to HexString
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		return strDes;
	}

	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

	public static boolean check(String plainText, String cipherText) {
		String text = encode(plainText, SHA_256);
		if (text == null) {
			return false;
		}
		if ((text.toLowerCase()).equals(cipherText)) {
			return true;
		}
		return false;
	}

	/**
	 * 加密方法
	 * 
	 * @param plainText
	 * @return
	 */
	public static String encrypt(String plainText) {
		String source = MD5Util.getMD5String(plainText + Constants.MD5_ENCRYPT_SALT);
		return encode(source, SHA_256);
	}
}
