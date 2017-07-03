package com.gjw.ssm.web.dao.imp;

import org.apache.ibatis.annotations.Param;

import com.gjw.ssm.web.bean.UserAccount;


public interface IUserDao {
	
	/**
	 * 可能遇到的异常：
	 * 		mybatis There is no getter for property named 'xx' in 'class java.lang.String；
	 * 异常解决方案：
	 * 		参数前添加 @Param("值为mapper中的变量名称")
	 * */
	/*通过条件获得用户信息*/
	UserAccount getUserInfoByCon(@Param("con")String con);
    
}