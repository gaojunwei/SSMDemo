package com.gjw.ssm.web.utils;

public class ParamFilter {
	/**
	 * �ж��ַ����Ƿ�������
	 * @param object
	 * @return
	 */
	public static boolean isExist(Object object) {
		if(object==null || object.toString().trim().equals(""))
			return false;
		return true;
	}
}
