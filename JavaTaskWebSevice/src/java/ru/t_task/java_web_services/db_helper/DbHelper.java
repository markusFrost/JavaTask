package ru.t_task.java_web_services.db_helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.t_task.java_web_services.models.ItemWord;

public class DbHelper 
{
     // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost/";
    private static final String URL = "jdbc:mysql://localhost:3306/javatestdb1";
    private static final String PORT = ":3306/";
    
    //db name table and fields
    private static final String DB_NAME = "TEXT_ANALYSIS";
    private static final String TABLE_RESULTS_NAME = "TABLE_RESULTS";
    private static final String ID = "_id";
    private static final String WORD = "word";
    private static final String TEXTS_COUNT = "texts_count";
    private static final String TEXTS_NUMBS = "texts_numbs";
    private static final String DATE_TIME = "date_time";

   //  Database credentials
   static final String USER = "admin";
   static final String PASS = "123456";
   
   // JDBC variables for opening and managing connection
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
    
    public DbHelper()
    {
        try
        {
        //Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //Execute a query
      stmt = conn.createStatement();
      
      String sql = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
      stmt.executeUpdate(sql);
      
       //opening database connection to MySQL server
       conn = DriverManager.getConnection(DB_URL  + DB_NAME, USER, PASS);
 
      // getting Statement object to execute query
       stmt = conn.createStatement();
       
       
        sql = "CREATE TABLE IF NOT EXISTS  " + TABLE_RESULTS_NAME + 
                  " ( " + ID + " integer not null auto_increment " + " , " + 
                WORD + " varchar(255) not null " + " , " + 
                TEXTS_COUNT + " int not null " + " , " + 
                TEXTS_NUMBS + " varchar(255) not null " + " , " +
                DATE_TIME + " bigint not null " + " , " +
                "primary key( " + ID + " )"
                + " );";

      stmt.executeUpdate(sql);
       
       
     
        }catch(SQLException se)
        {
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
        
      
    }
    
    public void addResult( List<ItemWord> resultList )
    {
        long time = System.currentTimeMillis();
        String sql = "";
        for ( ItemWord item : resultList )
        {            
            try 
            {
                sql = "insert into " + TABLE_RESULTS_NAME  + " ( " +
                        WORD  + " , " + TEXTS_NUMBS +  " , " + DATE_TIME + " , " + TEXTS_COUNT + " ) " +
                        " values " + " ( " + "'" + item.getWord() + "'" + " , " +
                        "'" + item.getTextBlockNumb() + "'" + " , " +
                        time + " , " + item.getTextBlockCount() + " ); ";
                
                stmt.executeUpdate(sql);
            } catch (SQLException ex) 
            {
                System.err.println(ex.getMessage());
            }
                                       
        }     
    }
    
    public List<ItemWord> getResultsByDate( long time )
    {
        List<ItemWord> resultList = new ArrayList<>();
        
        String sql = " select * from " + TABLE_RESULTS_NAME + " where " + DATE_TIME + " = " + time;
        
        try 
        {
            rs =  stmt.executeQuery( sql );
            ItemWord item;
             while (rs.next())
                {
                     item = new ItemWord();
                     item.setWord( rs.getString( WORD ) );
                     item.setTextBlockCount( rs.getInt(TEXTS_COUNT));
                     item.setTextBlockNumb(rs.getString(TEXTS_NUMBS ) );
                     
                     resultList.add( item );
                }
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultList;
    }
    
     public List<ItemWord> getResults(  )
    {
        List<ItemWord> resultList = new ArrayList<>();
        
        String sql = " select * from " + TABLE_RESULTS_NAME;
        
        try 
        {
            rs =  stmt.executeQuery( sql );
            ItemWord item;
             while (rs.next())
                {
                     item = new ItemWord();
                     item.setWord( rs.getString( WORD ) );
                     item.setTextBlockCount( rs.getInt(TEXTS_COUNT));
                     item.setTextBlockNumb(rs.getString(TEXTS_NUMBS ) );
                     
                     resultList.add( item );
                }
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultList;
    }
    
    public void closeConnection()
            {
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}
