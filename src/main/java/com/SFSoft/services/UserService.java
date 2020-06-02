/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SFSoft.services;

import com.SFSoft.dao.DaoUser;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.SFSoft.models.User;

/**
 * @author raul
 */

public class UserService {
    
    private static final UserService INSTANCE = new UserService();
    
    public static UserService getInstance() {
        return INSTANCE;
    }
    
    private UserService () {}
    
    public List<User> getUsers ()   {
        try {
            return DaoUser.getInstance().list();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public User getUser (int id)    {
        try {
            return DaoUser.getInstance().find(id);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public User addUser (User user) {
        try {
            DaoUser.getInstance().insert(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public User updateUser (int id, User user)  {
        user.setId(id);
        try {
            DaoUser.getInstance().update(user);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public void deleteUser (int id) {
        try {
            DaoUser.getInstance().delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
