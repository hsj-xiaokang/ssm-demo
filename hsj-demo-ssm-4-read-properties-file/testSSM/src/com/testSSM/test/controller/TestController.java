package com.testSSM.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.testSSM.test.model.JdbcConfig;
import com.testSSM.test.model.User;
import com.testSSM.test.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	private static final Logger LOG = Logger.getLogger(TestController.class);

	@Resource
	private TestService testService;
    @Autowired  
    private JdbcConfig Config; //引用统一的参数配置类  
    @Value("${url}")  
    public  String jdbcUrl;

    /**
     * 返回一般的视图解析页面JSP
     * @Description:TODO
     * @author:hsj qq:2356899074
     * @time:2017年7月6日 上午9:06:41
     * @param request
     * @param model
     * @return
     */
	@RequestMapping(value = "/testhsj",method = RequestMethod.GET)
	public String testhsj(HttpServletRequest request, ModelMap modelMap ){
//		int userId = Integer.parseInt(request.getParameter("id"));
		User user = testService.queryTest(0);
		user.setId(1);
		modelMap.addAttribute("userDo", user);
		LOG.info("testSSM>>>>>>>>>>>>>>>>>>>>testhsj.method"); 
		return "showUser";
	}
	
	/**
	 * 返回json数据
	 * @Description:TODO
	 * @author:hsj qq:2356899074
	 * @time:2017年7月6日 上午9:07:02
	 * @return
	 */
	@RequestMapping(value = "/testjson",method = RequestMethod.GET)
	@ResponseBody
	public Object testjson(){
		User user = new User();
		user.setId(1);
		user.setUserName("小康");
		user.setPassword("1234567890");
		LOG.info("testSSM>>>>>>>>>>>>>>>>>>>>testjson.method"); 
		
		System.out.println(">>>>>>>>>>>>>>config_value_read:"+Config.jdbcUrl);
		System.out.println("<<<<<<<<<<<<<config_value_read:"+jdbcUrl);
		
		return user;
	}
	
	
	   @RequestMapping("/helloUser")
	    public String helloUser(ModelMap modelMap) {
		   LOG.info("testSSM>>>>>>>>>>>>>>>>>>>>helloUser.method"); 
		   User user = testService.queryTest(0);
		   user.setId(1);
		   modelMap.addAttribute("userDo", user);
	        return "showUser"; 
	    }
	
}
