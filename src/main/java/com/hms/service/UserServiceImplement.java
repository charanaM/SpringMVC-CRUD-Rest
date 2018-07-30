/*
 *  Copyright 2006-2007 hSenid Software International (Pvt) Limited.
 *  All Rights Reserved.
 *
 * These materials are unpublished, proprietary, confidential source code of
 * hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 * of hSenid Software International (Pvt) Limited.
 *
 * hSenid Software International (Pvt) Limited retains all title to and intellectual
 * property rights in these materials.
 */

package com.hms.service;

import com.hms.dao.UserDAO;
import com.hms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;

/**
 * implementation of the service layer interface
 */

@Service
@Transactional
//@Configuration
//@ComponentScan("com.hms.service")
public class UserServiceImplement implements UserService {

    @Autowired
    public UserDAO userDAO;


    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void deleteUser(Integer userId) {
        userDAO.deleteUser(userId);
    }

    public User updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public User getUser(int userid) {
        return userDAO.getUser(userid);
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
