package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import model.*;

import utility.ConnectionManager;
import utility.ExceptionPrinter;

public class TaskDao {

  public void addTask(Task task){

      try (Connection con = ConnectionManager.getConnection(); 
         PreparedStatement ps = con.prepareStatement(INSERT_TODO_BY_QUERY);
      ){
           ps.setString(1, task.getTaskName()); 
           ps.setString(2, task.getFromTime());
           ps.setString(3, task.getToTime());
           ps.setDate(4, ConnectionManager.getSQLDate(task.getDate()));
           ps.executeUpdate();
      }catch(SQLException ex){
          ConnectionManager.printException(ex);
      }  
    }     
  public boolean deleteTask(int taskId) { 
    boolean rowDeleted =false;
    try(Connection con = ConnectionManager.getConnection();
       PreparedStatement ps = con.prepareStatement (DELETE TODO_BY_QUERY);
    ){
        ps.setInt(1, taskId);
        rowDeleted =ps.executeUpdate() > 0;
    }
    catch(SQLException ex){
       ConnectionManager.printException(ex);
    }  
  }
  public void updateTask(Task task){
    boolean rowUpdate;
    try (Connection con = ConnectionManager.getConnection(); 
       PreparedStatement ps = con.prepareStatement(INSERT_TODO_BY_QUERY);
    ){
         ps.setString(1, task.getTaskName()); 
         ps.setString(2, task.getFromTime());
         ps.setString(3, task.getToTime());
         ps.setDate(4, java.sql.Date.valueOf(task.getDate()));
         rowUpdate =ps.executeUpdate() > 0;
    }catch(SQLException ex){
        ConnectionManager.printException(ex);
    }  
  }     
} 
