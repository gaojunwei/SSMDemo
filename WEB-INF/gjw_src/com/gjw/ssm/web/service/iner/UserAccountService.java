package com.gjw.ssm.web.service.iner;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gjw.ssm.web.bean.UserAccount;
import com.gjw.ssm.web.dao.imp.IUserDao;
import com.gjw.ssm.web.service.imp.IUserAccountService;

@Service("userAccountService")
public class UserAccountService implements IUserAccountService {

	@Resource
	IUserDao userDao;
	/**
	 * ��ȡ�û���Ϣ
	 */
	@Override
	public UserAccount getUserInfoByCon(String con) {
		return userDao.getUserInfoByCon(con);
	}
	
	
}
