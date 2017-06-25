package com.gjw.ssm.web.utils;

public class ParamFilter {
	/**
	 * 判断字符串是否有数据
	 * @param object
	 * @return
	 */
	public static boolean isExist(Object object) {
		if(object==null || object.toString().trim().equals(""))
			return false;
		return true;
	}
}
