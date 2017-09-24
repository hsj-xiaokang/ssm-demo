package com.springapp.mvc;

import com.springapp.mvc.pojo.Student;
import com.springapp.mvc.service.LoginService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/test")
public class HelloController {
	
	private static final Logger LOG = Logger.getLogger(HelloController.class);
	
	@Resource(name = "loginServieImpl")
	private LoginService loginService;

	/**
	 * jsp视图返回
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/printWelcome",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		LOG.info("demo-web>>>>>>>>>>>>>>>>>>>>printWelcome.method");  
		model.addAttribute("message", "Hello world!123456何胜金");
		return "hello";
	}
    
	/**
	 * json对象数据返回给前端的ajax调用
	 * @return
	 */
	@RequestMapping(value = "/query",method = RequestMethod.GET)
	@ResponseBody
	public Student query()
	{
		LOG.info("demo-web>>>>>>>>>>>>>>>>>>>>query.method"); 
		Student student = loginService.query();
		System.out.println(student.getName()+" 性别： "+student.getSex());
		return student;
	}
}