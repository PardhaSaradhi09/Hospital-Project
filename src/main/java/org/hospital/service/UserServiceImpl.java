package org.hospital.service;

public class UserServiceImpl implements UserService {

	@Override
	public boolean isValid(String userName, String password) {
		// TODO Auto-generated method stub
		if(userName.equals("p.saragadam@manuhindia.com") && password.equals("password")){
			return true;
		}
		return false;
	}




}
