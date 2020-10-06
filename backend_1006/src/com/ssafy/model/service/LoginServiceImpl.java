package com.ssafy.model.service;

import com.ssafy.model.MemberDto;
import com.ssafy.model.dao.LoginDao;
import com.ssafy.model.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {

	private static LoginService loginService;
	
	public static LoginService getLoginService() {
		if(loginService == null) 
			loginService = new LoginServiceImpl();
		return loginService;
	}
	
	@Override
	public MemberDto login(String userid, String userpwd) throws Exception {
		if(userid == null || userpwd == null) //BL
			return null;
		return LoginDaoImpl.getLoginDao().login(userid, userpwd);
	}

}
