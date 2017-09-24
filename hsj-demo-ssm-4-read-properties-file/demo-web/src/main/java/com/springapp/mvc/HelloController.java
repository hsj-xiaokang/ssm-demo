package com.springapp.mvc;

import com.springapp.mvc.pojo.JdbcConfig;
import com.springapp.mvc.pojo.Student;
import com.springapp.mvc.service.LoginService;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
    @Autowired  
    private JdbcConfig Config; //引用统一的参数配置类  
	
    @Value("${jdbc.url}")  
    public  String jdbcUrl;

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
		
		
		System.out.println(">>>>>>>>>>>>>>config_value_read:"+Config.jdbcUrl);
		System.out.println("<<<<<<<<<<<<<config_value_read:"+jdbcUrl);
		
		return student;
	}
	
	
	/**
	 * 
	 * @Description:freemarker视图返回
	 * @author:hsj qq:2356899074
	 * @time:2017年7月6日 下午5:12:49
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/printWelcomeFreemarker",method = RequestMethod.GET)
	public String printWelcomeFreemarker(ModelMap model) {
		LOG.info("demo-web>>>>>>>>>>>>>>>>>>>>printWelcomeFreemarker.method"); 
		Student s = new Student();
		s.setId(1);
		s.setName("小康");
		s.setSex("男");
		model.addAttribute("userDo", s);
		return "showUser";
	}
}