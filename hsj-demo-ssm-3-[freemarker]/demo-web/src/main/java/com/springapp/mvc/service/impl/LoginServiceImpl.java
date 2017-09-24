package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.LoginMapper;
import com.springapp.mvc.pojo.Student;
import com.springapp.mvc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yp-tc-m-2781 on 16/8/26.
 */
@Service("loginServieImpl")
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginMapper loginDao;

    @Override
    public Student query() {
        return loginDao.query();
    }
}
