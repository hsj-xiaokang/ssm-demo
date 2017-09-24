package com.testSSM.test.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.testSSM.test.dao.TestMapper;
import com.testSSM.test.model.User;

@Service("testService")
public class TestServiceImpl implements TestService{

	@Resource
	private TestMapper testMapper;
//	
//	public TestMapper getTestMapper() {
//		return testMapper;
//	}
//
//	public void setTestMapper(TestMapper testMapper) {
//		this.testMapper = testMapper;
//	}

	@Override
	public User queryTest(int userId) {
		return testMapper.queryTest(userId);
//		return null;
	}

}
