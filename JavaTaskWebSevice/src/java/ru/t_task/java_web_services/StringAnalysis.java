
package ru.t_task.java_web_services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import ru.t_task.java_web_services.db_helper.DbHelper;
import ru.t_task.java_web_services.models.ItemWord;
import ru.t_task.java_web_services.objects.DataBaseWorkManager;
import ru.t_task.java_web_services.objects.StringProcessingManager;



@WebService(serviceName = "StringAnalysis")
public class StringAnalysis {
    
    @WebMethod(operationName = "stringProcessing")
    public List<ItemWord> stringProcessing ( 
            @WebParam(name = "text1") String text1 , 
            @WebParam(name = "text2") String text2 , 
            @WebParam(name = "text3") String text3 , 
            @WebParam(name = "text4") String text4 , 
            @WebParam(name = "text5") String text5 
            )
    {
        /*List<ItemWord> list;
        
        ru.t_task.java_web_services.string_analysis.StringProcessing stringProcess = new ru.t_task.java_web_services.string_analysis.StringProcessing( text1, text2, text3, text4, text5 );
        stringProcess.startProcess();
        list = stringProcess.getResultList();
                    
        DbHelper dbHelper = new DbHelper();       
        dbHelper.addResult( list );       
        dbHelper.closeConnection();
        
        return list;*/
        
        StringProcessingManager stringManager = new StringProcessingManager(text1, text2, text3, text4, text5);
        
         Thread t = new Thread( stringManager );
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {}
       
        List<ItemWord> listResult =  stringManager.getList();
        
        DataBaseWorkManager dbManager = new DataBaseWorkManager( listResult );
        
        new Thread( dbManager ).start();
        
        return listResult;
        


    }
    
   
}
