
package ru.t_task.java_web_services.models;

import ru.t_task.java_web_services.objects.Constants;

public class ItemWord 
{
        private String word; 
        
        private int textBlockCount;
        
        private String textBlockNumb;
       
        private int [] arrayTextBlockCount = new int[Constants.TEXT_BLOCK_COUNT]; // in which textblocks there is this word
        
        public ItemWord()
        {
            textBlockCount = 0;
            textBlockNumb = "";
            for ( int i = 0; i < Constants.TEXT_BLOCK_COUNT; i++ )
            {
                arrayTextBlockCount[i] = 0;
            }
        }
        
        public void setTextBlockNumb ( int num )
        {
            if ( !textBlockNumb.contains( num + "" ))
            {
                textBlockNumb += num + " , ";
            }
        }
        
        
        public void addTextBlockCount( int numTextBlock )
        {
             if ( numTextBlock <= Constants.TEXT_BLOCK_COUNT )
             {
                 if (arrayTextBlockCount[ numTextBlock - 1 ] == 0 )
                 {
                     textBlockCount++;
                     //textBlockNumb += numTextBlock + " , ";
                     arrayTextBlockCount[ numTextBlock - 1 ] = numTextBlock;
                 }
                 
             }
        }

        public int[] getArrayTextBlockCount()
        {
            return arrayTextBlockCount;
        }
        
    public String getWord() 
    {
        return word;
    }

    public void setWord(String word) 
    {
        this.word = word;
    }

    public int getTextBlockCount()
    {
        return textBlockCount;
    }
    
    public String getTextBlocksNumbs()
    {
        String value = "";
         for ( int i = 0; i < Constants.TEXT_BLOCK_COUNT; i++ )
            {
                if ( arrayTextBlockCount[i] != 0 )
                {                
                         value += arrayTextBlockCount[i] + " , ";                   
                }
            }
         
         value = value.substring(0 , value.length() - 2 ); // delete last ,
         
         
         return value;
    }

    public void setTextBlockNumb(String textBlockNumb) {
        this.textBlockNumb = textBlockNumb;
    }
    
    

    public void setTextBlockCount(int num ) 
    {
        if ( !textBlockNumb.contains( num + "" ))
            {
                textBlockCount++;
            }
    }

    public void setArrayTextBlockCount( String strNumbs )
    {
        String [] array = strNumbs.split(" , ");
        for ( String value : array )
        {
            int index = Integer.parseInt( value.replace(" ", "") );
            arrayTextBlockCount[ index - 1 ] = index;
        }
    }

    public String getTextBlockNumb() 
    {
        return textBlockNumb.substring(0 , textBlockNumb.length() - 2 );
    }
    
    
    
 
    
    
        
        
}
