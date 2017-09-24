package com.springapp.mvc.dao;

import com.springapp.mvc.pojo.Student;
import org.springframework.stereotype.Repository;

/**
 * Created by yp-tc-m-2781 on 16/8/26.
 */

@Repository(value = "loginMapper")
public interface LoginMapper {
    Student query();
}
