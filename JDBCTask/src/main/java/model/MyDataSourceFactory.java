package model;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyDataSourceFactory {
    public static DataSource getMySQLDataSource(){
        Properties propertyFile = new Properties();
        FileInputStream inputStream = null;
        MysqlDataSource mysqlDataSource = null;
        try{
            inputStream = new FileInputStream("src/main/resources/config/db.properties");
            propertyFile.load(inputStream);
            mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setUser(propertyFile.getProperty("MYSQL_DB_USERNAME"));
            mysqlDataSource.setURL(propertyFile.getProperty("MYSQL_DB_URL"));
            mysqlDataSource.setPassword(propertyFile.getProperty("MYSQL_DB_PASSWORD"));
        }catch(IOException iOException){
            iOException.printStackTrace();
        }
        return mysqlDataSource;
    }
}
