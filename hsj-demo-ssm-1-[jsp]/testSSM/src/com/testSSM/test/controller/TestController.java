package com.testSSM.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.testSSM.test.model.User;
import com.testSSM.test.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	private static final Logger LOG = Logger.getLogger(TestController.class);

	@Resource
	private TestService testService;
//	
//	public TestService getTestService() {
//		return testService;
//	}
//	public void setTestService(TestService testService) {
//		this.testService = testService;
//	}



	@RequestMapping(value = "/testhsj",method = RequestMethod.GET)
	public String testhsj(HttpServletRequest request, Model model){
//		int userId = Integer.parseInt(request.getParameter("id"));
		User user = testService.queryTest(0);
		System.out.println(user.getUserName());
		model.addAttribute("user", user);
		LOG.info("testSSM>>>>>>>>>>>>>>>>>>>>query.method"); 
		return "showUser";
	}
}
