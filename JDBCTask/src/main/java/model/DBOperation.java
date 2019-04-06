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
    /////////////////////////////////////////////////////////
    
    Statement createStatement = null;
    PreparedStatement insertStatment = null;
    private final String createQuery = "CREATE TABLE IF NOT EXISTS `employees` (\n" +
        "  `Id` INT UNSIGNED NOT NULL,\n" +
        "  `Phone_Number` INT NULL,\n" +
        "  `F_Name` VARCHAR(45) NULL,\n" +
        "  `L_Name` VARCHAR(45) NULL,\n" +
        "  `Age` INT NULL,\n" +
        "  `Sex` VARCHAR(45) NULL,\n" +
        "  `Address` VARCHAR(45) NULL,\n" +
        "  `Vaction_Balance` INT DEFAULT '30',\n" +
        "  PRIMARY KEY (`Id`));";
    ///////////////////////////////////////////////////////////////////
    
    public DBOperation() {
        dataSource  = MyDataSourceFactory.getMySQLDataSource();
    }
    public boolean connect2(){
        try{
            connection = dataSource.getConnection();
            connection.setAutoCommit(true);
            return true;
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return false;
    }
    
    public boolean createTable(){
        try{
            createStatement = connection.createStatement(responseSet.TYPE_SCROLL_SENSITIVE, responseSet.CONCUR_UPDATABLE);
            createStatement.execute(createQuery);
            return true;
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return false;
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
    public void update(Employee emp){
        try{
            if(newFlag){
                responseSet.moveToInsertRow();
            }
            if(emp!=null){
                System.out.println(emp.Id+emp.phone+emp.firstName+emp.middleName);
                responseSet.updateInt("id", emp.Id);
                responseSet.updateInt("phone", emp.phone);
                responseSet.updateString("fname", emp.firstName);
                responseSet.updateString("mname", emp.middleName);
                responseSet.updateString("lname", emp.lastName);
                responseSet.updateString("email", emp.email);
                responseSet.insertRow();
                changeNewFlag();
            }
            
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }
    public void delete(){
        try{
            if(!responseSet.next())
                responseSet.previous();
            responseSet.deleteRow();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }
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
