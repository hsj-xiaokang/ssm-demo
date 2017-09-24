package com.testSSM.test.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @Description:读取配置文件
 * @author:hsj qq:2356899074
 * @time:2017年7月7日 上午8:59:52
 */
@Component   
public class JdbcConfig{      
      
    @Value("${url}")  
    public  String jdbcUrl; //这里变量不能定义成static  
      
    @Value("${username}")  
    public  String username;    
      
    @Value("${password}")  
    public  String password;    
       
} 
