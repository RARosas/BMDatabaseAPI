/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SFSoft.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.SFSoft.models.User;

/**
 * @author raul
 */

public class DaoUser implements IDAO<User> {
    
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;
    private PreparedStatement find;
    private PreparedStatement list;
    
    private static DaoUser instance;
    
    private DaoUser()   {}

    public static DaoUser getInstance() {
        if (instance == null)    {
            instance = new DaoUser();
        }
        return instance;
    }

    @Override
    public void insert(User entity) throws SQLException {
        String query = "INSERT INTO users (name, password, role)"
                + "VALUES (?,?,?)";
        
        if (insert == null) {
            insert = Conn.getInstance().getCon().prepareStatement(query);
        }
        
        insert.setString(1, entity.getName());
        insert.setString(2, entity.getPassword());
        insert.setString(3, entity.getRole());
        
        insert.executeUpdate();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        
        if (delete == null) {
            delete = Conn.getInstance().getCon().prepareStatement(query);
        }
        
        delete.setInt(1, id);
        delete.executeUpdate();
    }

    @Override
    public List<User> list() throws SQLException {
        String query = "SELECT * FROM users";
        
        if (list == null)   {
            list = Conn.getInstance().getCon().prepareStatement(query);
        }
        
        ResultSet set = list.executeQuery();
        ArrayList<User> result = new ArrayList<>();
        while (set.next())  {
            result.add(load(set));
        }
        
        return result;
    }

    @Override
    public User find(Integer id) throws SQLException {
        String query = "SELECT * FROM users WHERE id = ?";
        
        if (find == null)   {
            find = Conn.getInstance().getCon().prepareStatement(query);
        }
        
        find.setInt(1, id);
        ResultSet set = find.executeQuery();
        
        return set != null && set.next() ? load(set) : null;
    }

    @Override
    public void update(User entity) throws SQLException {
        String query = "UPDATE users SET "
                + "name = ?, password = ?, role = ? WHERE id = ?";
        
        if (update == null) {
            update = Conn.getInstance().getCon().prepareStatement(query);
        }
        
        update.setInt(1, entity.getId());
        update.setString(2, entity.getName());
        update.setString(3, entity.getPassword());
        update.setString(4, entity.getRole());
        
        update.executeUpdate();
    }
    
    public User load (ResultSet set) throws SQLException    {
        User user = new User();
        user.setId(set.getInt("id"));
        user.setName(set.getString("name"));
        user.setPassword(set.getString("password"));
        user.setRole(set.getString("role"));
        return user;
    }
}
