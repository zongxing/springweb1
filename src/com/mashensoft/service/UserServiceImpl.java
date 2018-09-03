package com.mashensoft.service;

import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

	@Override
	public String getName() {
		return "zongxing";
	}

}
