package ru.t_task.java_web_services.string_analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.t_task.java_web_services.models.ItemWord;
import ru.t_task.java_web_services.objects.Constants;

public class StringAnalysis 
{
    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String text5;
    
    private  HashMap<String, ItemWord> map;
    
    private List<ItemWord> resultList; // output data

    public StringAnalysis(String text1, String text2, 
            String text3, String text4, String text5)
    {
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.text5 = text5;
        
        
        //Initialize map that are stored key - word and value -  how many times it occurs and in which textblocks
        map = new HashMap<>();
        
        this.resultList = new ArrayList<>();
    }
    
    public void startAnalysis()
    {
        String[] arrayTexts = {
            text1, text2,
            text3, text4, text5
        };
        
        for ( String value : arrayTexts ) //check whether there is empty text
        {
            if ( value.length() == 0 )
            {
                return;
            }
        }
        
       for ( int i = 0; i <  Constants.TEXT_BLOCK_COUNT; i++ )
       {
           fillMap( arrayTexts[i], ( i + 1 ) );

       }

       //-----------------------------------

       List<String> listKeys = new ArrayList<>();
    
       for ( String key : map.keySet() ) 
       {
           listKeys.add(key);
       }
       
       // first of all we need to sort words by name
        Collections.sort(listKeys);

        ArrayList<ItemWord> listItems = new ArrayList<>();
        ItemWord item;
        //then add items to list
       for ( String key : listKeys )
       {
           item = (ItemWord) map.get( key );
           listItems.add( item );
       }
       
       Collections.sort(listItems, new ItemComarator() );  // sort list by textblock count
       
       if ( listItems.size() > 0 && listItems.get(0).getTextBlockCount() > 1 )
           // если есть слова которые встречаются минимум в двух текстах
       {      
         int size = listItems.size();
         if ( size > Constants.RESULT_VALUES_COUNT )
            {
                size = Constants.RESULT_VALUES_COUNT;
            }
       
            resultList = listItems.subList(0, size ); // we need to get first 20 items or all list
       }
       
       for ( ItemWord it : resultList)
       {
           System.out.println( it.getWord() + "\t" + it.getTextBlockCount() );
       }   
    }
    
    private class ItemComarator implements Comparator<ItemWord>
    {

        @Override
        public int compare(ItemWord item1, ItemWord item2) 
        {
             // меньше -1  больше 1  равно 0
           if ( item1.getTextBlockCount() > item2.getTextBlockCount() )
           {
               return -1;
           }
           else if ( item1.getTextBlockCount() < item2.getTextBlockCount() )
           {
               return 1;
           }
           else
           {
               return 0;
           }
        }   
    }

    private void fillMap ( String text, int textBlockNumb  )
    {       
         String reg = "[а-яА-ЯёЁa-zA-Z0-9]{3,}";
         Pattern p = Pattern.compile( reg );
         Matcher m = p.matcher( text );
         
         ItemWord item;
         
         //start to find words in text
         while(m.find())
            {
                String word =  m.group(); //get curremt word
               // word = word.toLowerCase();
               // if ( !map.containsKey( word ) ) 
                String key =  getMapContainKey( word ); // map can store this word with another case
                if ( key != null) { word = key; } // if in map there is already this word
                
                if ( key == null )//if the word not exists in map
                    {
                        item = new ItemWord();
                        item.setWord( word );
                       // item.setCountMatches( Constants.INITIAL_COUNT_MATCHES );  //  the number of mathes is equal 1
                        item.addTextBlockCount( textBlockNumb );  // this word there is in current textblock
             
                        // add full information about word in map
                        map.put(word, item );
                    }
                else
                    {
                        item = (ItemWord) map.get( word ); // get the word
                        //item.incrementCountMatches(); // increment the number of mathes
                        item.addTextBlockCount( textBlockNumb ); // this word there is in current textblock
                        map.put(word, item ); // update information about word in map
                    }
            }
    }
    
    private String getMapContainKey(String word )
            {
                 for ( String key : map.keySet() ) 
                 {
                     if ( key.equalsIgnoreCase(word) )
                     {
                         return key;
                     }          
                 }
                 return null;
            }

    public List<ItemWord> getResultList() 
    {
        return resultList;
    }
}
    
    
