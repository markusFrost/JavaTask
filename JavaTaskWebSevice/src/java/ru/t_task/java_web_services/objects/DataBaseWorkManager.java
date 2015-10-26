/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.t_task.java_web_services.objects;

import java.util.List;
import ru.t_task.java_web_services.db_helper.DbHelper;
import ru.t_task.java_web_services.models.ItemWord;

/**
 *
 * @author Андрей
 */
public class DataBaseWorkManager implements Runnable
{
    private volatile List<ItemWord> list;
    public DataBaseWorkManager( List<ItemWord> list )
    {
        this.list = list;
    }
    
    @Override
    public void run() 
    {
        DbHelper dbHelper = new DbHelper();       
        dbHelper.addResult( list );   // save list to db     
        dbHelper.closeConnection();
    }
    
}
