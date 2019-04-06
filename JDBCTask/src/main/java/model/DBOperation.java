package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

public class DBOperation {
    DataSource dataSource;
    Connection connection = null;
    Statement statement = null;
    ResultSet responseSet = null;
    Employee emp;
    
    boolean newFlag = false;
    private final String queryString = "select id, fname, lname, mname, email, phone from employee";
    

    
    public DBOperation() {
        dataSource  = MyDataSourceFactory.getMySQLDataSource();
    
    }
    //////////////////////////////////////////////////////////////
    public boolean connect(){
         try{
            connection = dataSource.getConnection();
            connection.setAutoCommit(true);
            statement = connection.createStatement(responseSet.TYPE_SCROLL_SENSITIVE, responseSet.CONCUR_UPDATABLE);
            responseSet = statement.executeQuery(queryString);
            return true;
        }catch(SQLException sqlexception){
            sqlexception.printStackTrace();
            return false;
        }
    }
    public Employee initial(){
        try{
            if(responseSet.next())
                return  new Employee(responseSet.getInt("id"), responseSet.getInt("phone"),
                    responseSet.getString("fname"), responseSet.getString("mname"), responseSet.getString("lname"), responseSet.getString("email")); 
        }catch(SQLException exception){
            exception.printStackTrace();
        }
            return null;
    }
    public void changeNewFlag(){
        newFlag = !newFlag;
    }
    //update 
    public void update(Employee emp){
        try{
            if(newFlag){
                //you must check for the new flag but it doesn't work for the first 
                //run of the application
                responseSet.moveToInsertRow();
            }
            if(emp!=null){
                responseSet.updateInt("id", emp.Id);
                responseSet.updateInt("phone", emp.phone);
                responseSet.updateString("fname", emp.firstName);
                responseSet.updateString("mname", emp.middleName);
                responseSet.updateString("lname", emp.lastName);
                responseSet.updateString("email", emp.email);
                responseSet.insertRow();
                changeNewFlag();
            }
//            ashraf

            
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }
    //delete
    public void delete(){
        try{
            if(!responseSet.next())
                responseSet.previous();
            responseSet.deleteRow();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }
    //get First employee
    public Employee getFisrt(){
        try{
            if(responseSet.first())
                return  new Employee(responseSet.getInt("id"), responseSet.getInt("phone"),
                responseSet.getString("fname"), responseSet.getString("mname"), responseSet.getString("lname"), responseSet.getString("email"));
                
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }
    public Employee getPrevious(){
        try{
            if(responseSet.previous())
                return  new Employee(responseSet.getInt("id"), responseSet.getInt("phone"),
                responseSet.getString("fname"), responseSet.getString("mname"), responseSet.getString("lname"), responseSet.getString("email"));
         }catch(SQLException exception){
             exception.printStackTrace();
         }
        return null;
    }
    public Employee getNext(){
        try{
            if(responseSet.next())
                return  new Employee(responseSet.getInt("id"), responseSet.getInt("phone"),
                responseSet.getString("fname"), responseSet.getString("mname"), responseSet.getString("lname"), responseSet.getString("email"));
         }catch(SQLException exception){
             exception.printStackTrace();
         }
        return null;
        
    }
    public Employee getLast(){
        try{
            if(responseSet.last())
                return  new Employee(responseSet.getInt("id"), responseSet.getInt("phone"),
                responseSet.getString("fname"), responseSet.getString("mname"), responseSet.getString("lname"), responseSet.getString("email"));
         }catch(SQLException exception){
             exception.printStackTrace();
         }
        return null;
    }
    public void close(){
            try{
                if(responseSet != null)responseSet.close();
                if(statement != null) statement.close();
                if(connection != null)connection.close();
            }catch(SQLException exception){
                exception.printStackTrace();
            }

    }
    
    
}
