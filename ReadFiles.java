

import java.util.*;
import java.io.*;
public class ReadFiles {

    
     Scanner fileScanner;
     static ArrayList<String> textFile;
     static HashSet<String> wordList;
     static HashSet<String> stopList;
     String dictionaryFile = "EnglishWordList.txt";
     String stopWordsFile = "stop_words.txt";
     String textFileName ="Automotive_5.txt";
     
     
     public ReadFiles () {
         
         fileScanner=null;
         textFile = new ArrayList<>();
         wordList = new HashSet<>();
         stopList = new HashSet<>();
         
        }
        
        
        public void readTextFile()
   {
       
          String line=null;
          //String[] words;
               try
               {
                  
                   fileScanner = new Scanner (new File (textFileName));
                   
                   while (fileScanner.hasNext()) {
           
                    line = fileScanner.nextLine();
                    String[] words=line.split(" ");
                    for (int i=0;i<words.length;i++) {
                        String s = words[i].replaceAll("[\\[\\]_:\"'`?;\\”0-9—;“()-/.,*! ]", "").trim().toLowerCase();
                        if (!s.isEmpty())textFile.add(s);
                    }
                    
                }
               }
               catch (IOException e)
               {
                   System.out.println(e);
               }
       
   }
     
   
   
   public void readDictionary()
   {
       
          String word=null;
               try
               {
                  
                   fileScanner = new Scanner (new File (dictionaryFile));
                   
                   while (fileScanner.hasNext()){
           
                    word = fileScanner.nextLine();
                    wordList.add(word);
                }
       
               }
               catch (IOException e)
               {
                   System.out.println(e);
               }
       
   }
   public void readStop()
   {
       String word=null;
               try
               {
                  
                   fileScanner = new Scanner (new File (stopWordsFile));
                   
                   while (fileScanner.hasNext()){
           
                    word = fileScanner.nextLine();
                    word=word.replaceAll("[\\[\\]_:\"'`?;\\”0-9—;“()-/.,*! ]", "").trim().toLowerCase();
                    stopList.add(word);
                }
       
               }
               catch (IOException e)
               {
                   System.out.println(e);
               }
       
    }    
    
}

