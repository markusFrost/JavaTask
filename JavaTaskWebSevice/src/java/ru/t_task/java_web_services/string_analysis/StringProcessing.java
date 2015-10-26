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

public class StringProcessing 
{
    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String text5;
    
    private  HashMap<String, ItemWord> map;
    
    private List<ItemWord> resultList; // output data

    public StringProcessing(String text1, String text2, 
            String text3, String text4, String text5)
    {
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.text5 = text5;
        
        
        //Initialize map that are stored key - word, number texts and count texts
        map = new HashMap<>();
        
        this.resultList = new ArrayList<>();
    }
    
    public void startProcess()
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
        Collections.sort(listKeys , new WordStringComarator() );

        ArrayList<ItemWord> listItems = new ArrayList<>();
        ItemWord item;
        //then add items to list
       for ( String key : listKeys )
       {
           item = (ItemWord) map.get( key );
           listItems.add( item );
       }
       
       Collections.sort(listItems, new ItemComarator() );  // sort list by texts count

        int size = listItems.size();
        
       if (  size > 0 )
       {
          if ( size > Constants.RESULT_VALUES_COUNT )
          {
              size = Constants.RESULT_VALUES_COUNT;
          }
           int countItems = 0;
           for ( int i = 0; i < size; i++ )
           {
               if ( listItems.get(i).getTextBlockCount() > 1 )
               {
                   countItems++;
               }
           }
           resultList = listItems.subList(0, countItems ); 
       }
    }
    
    private class ItemComarator implements Comparator<ItemWord>
    {

        @Override
        public int compare(ItemWord item1, ItemWord item2) 
        {
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
    
    private class WordStringComarator implements Comparator<String>
    {
        @Override
        public int compare(String o1, String o2) 
        {
           return ( o1.toLowerCase().compareTo( o2.toLowerCase()) );
        }
  
    }

    private void fillMap ( String text, int textBlockNumb  )
    {       
         String reg = "[а-яА-ЯёЁa-zA-Z0-9]{3,}";
         Pattern p = Pattern.compile( reg );
         Matcher m = p.matcher( text ); // use regEx to find words in texts
         
         ItemWord item;
         
         //start to find words in text
         while(m.find())
            {
                String word =  m.group(); //get curremt word

                String key =  getMapContainKey( word ); // map can store this word with another case
                if ( key != null) { word = key; } // if in map there is already this word
                
                if ( key == null )//if the word not exists in map
                    {
                        item = new ItemWord();
                        item.setWord( word );
                        item.setTextBlockCount(textBlockNumb);
                        item.setTextBlockNumb(textBlockNumb); 
           
                        // add full information about word in map
                        map.put(word, item );
                    }
                else
                    {
                        item = (ItemWord) map.get( word ); 
                        item.setTextBlockCount(textBlockNumb);
                        item.setTextBlockNumb(textBlockNumb);

                        map.put(word, item ); // update information about word in map
                    }
            }
    }
    
    private String getMapContainKey(String word )
            {
                // if there is word in map ( ignore cases )
                 for ( String key : map.keySet() ) 
                 {
                     if ( key.equalsIgnoreCase(word) )
                     {
                         return key; // return this word
                     }          
                 }
                 return null;
            }

    public List<ItemWord> getResultList() 
    {
        return resultList;
    }
}
    
    
