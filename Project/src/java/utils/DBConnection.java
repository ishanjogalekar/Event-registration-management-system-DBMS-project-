//Connect Database using JDBC Connection and return Connection method 
//Mention Datasource in application.properties file 
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Class to create Connection with Databse
public class DBConnection {

    //Objects
    PropertiesReader propertiesReader = new PropertiesReader();
    Connection connection = null;
    String driverClass, dbUrl, dbUsername, dbPassword;

    public Connection GetDatabaseConnection() {
        String applicationDataSource = propertiesReader.getProperty("application.datasource");
        try {
            switch (applicationDataSource) {
                case "sqlite" -> {
                    String userName = System.getProperty("user.name");
                    String osName = System.getProperty("os.name");
                    String dbFilePath;
                    if(osName.contains("Win")){
                        driverClass = propertiesReader.getProperty("sqlite.driver.class");
                        dbFilePath = propertiesReader.getProperty("sqlite.db.file.path");
                        dbFilePath = dbFilePath.replace("{userName}", userName);
                        System.out.println(dbFilePath);
                    }
                    else{
                        dbFilePath = propertiesReader.getProperty("sqlite.db.linux.file.path"); 
                    }
                    dbUrl = propertiesReader.getProperty("sqlite.db.url");
                    dbUrl = dbUrl.replace("[DBFile]", dbFilePath);
                    
                    Class.forName(driverClass);
                    connection = DriverManager.getConnection(dbUrl);
                }
                case "oracle" -> {
                    driverClass = propertiesReader.getProperty("oracle.driver.class");
                    dbUrl = propertiesReader.getProperty("oracle.db.url");
                    dbUsername = propertiesReader.getProperty("oracle.db.username");
                    dbPassword = propertiesReader.getProperty("oracle.db.password");
                    Class.forName(driverClass);
                    connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                }
                case "mysql" -> {
                    driverClass = propertiesReader.getProperty("mysql.driver.class");
                    dbUrl = propertiesReader.getProperty("mysql.db.url");
                    dbUsername = propertiesReader.getProperty("mysql.db.username");
                    dbPassword = propertiesReader.getProperty("mysql.db.password");
                    Class.forName(driverClass);
                    connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                }
                case "postgres" -> {
                    driverClass = propertiesReader.getProperty("postgres.driver.class");
                    dbUrl = propertiesReader.getProperty("postgres.db.url");
                    dbUsername = propertiesReader.getProperty("postgres.db.username");
                    dbPassword = propertiesReader.getProperty("postgres.db.password");
                    Class.forName(driverClass);
                    connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                }
            }
            //SQLite DB File
            //Oracle DB Server
            //MySQL DB Server
            //Postgres DB Server
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
