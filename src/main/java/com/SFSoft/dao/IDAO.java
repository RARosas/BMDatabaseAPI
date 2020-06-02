/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SFSoft.dao;
import java.util.List;
import java.sql.SQLException;

/**
 * @author raul
 * @param <T>
 */

public interface IDAO<T> {
    
    void insert (T entity) throws SQLException;
    void delete (Integer id) throws SQLException;
    List<T> list () throws SQLException;
    T find (Integer id) throws SQLException;
    void update (T entity) throws SQLException;
    
}
