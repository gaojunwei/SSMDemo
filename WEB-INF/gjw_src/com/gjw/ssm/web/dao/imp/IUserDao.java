package com.gjw.ssm.web.dao.imp;

import org.apache.ibatis.annotations.Param;

import com.gjw.ssm.web.bean.UserAccount;


public interface IUserDao {
	
	/**
	 * �����������쳣��
	 * 		mybatis There is no getter for property named 'xx' in 'class java.lang.String��
	 * �쳣���������
	 * 		����ǰ��� @Param("ֵΪmapper�еı�������")
	 * */
	/*ͨ����������û���Ϣ*/
	UserAccount getUserInfoByCon(@Param("con")String con);
    
}