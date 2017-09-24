package com.springapp.mvc.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component   
public class JdbcConfig{      
      
    @Value("${jdbc.url}")  
    public  String jdbcUrl; //这里变量不能定义成static  
      
    @Value("${jdbc.username}")  
    public  String username;    
      
    @Value("${jdbc.password}")  
    public  String password;    
       
}