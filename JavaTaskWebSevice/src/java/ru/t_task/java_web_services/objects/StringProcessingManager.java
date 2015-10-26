
package ru.t_task.java_web_services.objects;

import java.util.ArrayList;
import java.util.List;
import ru.t_task.java_web_services.db_helper.DbHelper;
import ru.t_task.java_web_services.models.ItemWord;

public class StringProcessingManager implements Runnable
{
    private volatile  List<ItemWord> list;
    
    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String text5;
    
    public StringProcessingManager(String text1, String text2, 
            String text3, String text4, String text5)
    {
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.text5 = text5;
    }
    
     @Override
    public void run() 
    {
         ru.t_task.java_web_services.string_analysis.StringProcessing stringProcess = new ru.t_task.java_web_services.string_analysis.StringProcessing( text1, text2, text3, text4, text5 );
        stringProcess.startProcess();
        list = stringProcess.getResultList();
    }
    
    public List<ItemWord> getList() {
        return list;
    }

    public void setList(List<ItemWord> list) {
        this.list = list;
    }

   
        
        
}
