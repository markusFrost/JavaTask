/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.t_task.java_web_services.utils;

import java.util.ArrayList;

/**
 *
 * @author Андрей
 */
public class HelpUtils 
{
     public static boolean isWordExists(  ArrayList<String> listText, String word )
    {
        for ( String str : listText )
        {
            if ( str.equalsIgnoreCase( word ) )
            {
               return true;
            }
        }
        
        return false;
    }   
}
