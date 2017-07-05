package com.gjw.ssm.web.service.iner;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gjw.ssm.web.bean.UserAccount;
import com.gjw.ssm.web.dao.imp.IUserDao;
import com.gjw.ssm.web.service.imp.IUserAccountService;

@Service("userAccountService")
public class UserAccountService implements IUserAccountService {

	@Resource
	IUserDao userDao;

	@Override
	public int save(UserAccount uAccount) {
		return userDao.saveObj(uAccount);
	}

	@Override
	public int delete(UserAccount uAccount) {
		return userDao.deleteObj(uAccount);
	}

	@Override
	public int edit(UserAccount uAccount) {
		return userDao.editObj(uAccount);
	}

	@Override
	public UserAccount get(UserAccount uAccount) {
		return userDao.getObj(uAccount);
	}

	@Override
	public List<UserAccount> list(UserAccount uAccount) {
		return userDao.listObj(uAccount);
	}

	/**
	 * 根据 账号获取会员信息
	 */
	@Override
	public UserAccount getObjByAcct(String accout) {
		return userDao.getObjByAcct(accout);
	}
}
