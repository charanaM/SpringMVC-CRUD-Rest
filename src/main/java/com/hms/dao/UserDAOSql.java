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

package com.hms.dao;

import com.hms.dao.UserDAO;
import com.hms.map.UserMapper;
import com.hms.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;


/**
 * implementation of the dao interface.
 *
 */

public class UserDAOSql implements UserDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addUser(User user) {
        String SQL = "INSERT INTO user_info (name, age, address, username, password) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQL, user.getName(), user.getAge(), user.getAddress(), user.getUsername(), user.getPassword());

    }

    @Override
    public List<User> getAllUsers() {
        String SQL = "SELECT * FROM user_info";
        List<User> users = jdbcTemplate.query(SQL, new UserMapper());
        return users;
    }

    @Override
    public void deleteUser(Integer userId) {
        String SQL = "DELETE FROM user_info WHERE user_id = ?";
        jdbcTemplate.update(SQL, userId);
    }

    @Override
    public User updateUser(User user) {
        String SQL = "UPDATE user_info SET name=?, age=?, address=?, username=?, password=? WHERE user_id=?";
        jdbcTemplate.update(SQL, user.getName(), user.getAge(), user.getAddress(), user.getUsername(), user.getPassword(), user.getUser_id());
        return user;
    }

    @Override
    public User getUser(int userid) {
        return null;
    }
}
