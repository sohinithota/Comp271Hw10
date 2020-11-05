     
/**
 * Write a description of class PrimitiveJavaEditor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
/*create a method that sorts every word into a hashmap,
 * sort this by amount of words
 * call the top 5 and the bottom 5
 */ 

public class PrimitiveJavaEditor 
{
String stopList = "stop_words.txt";
PrintWriter printWriter=null;
HashMap<String, Integer> count = new HashMap<String,Integer>();
ReadFiles rF = new ReadFiles();


  public boolean find (String x) 
  { String word;
      ListIterator<String> itr = ReadFiles.textFile.listIterator();
     while (itr.hasNext()){
     word=  itr.next().trim();
    word= word.replaceAll("[\\[\\]_:\"'`?;0-9;()-/.,*! ]", "").toLowerCase();
    System.out.println(word);
     if (word.equals(x)) {
         return true; 
        }
    }
        return false;
    }
    // Looks for a word "x" in the file and returns true if found or false otherwise.


public  boolean findReplace (String find, String replace) 

   {
       int index;
      index = ReadFiles.textFile.indexOf(find);
       if (index != -1) {
           String prev = ReadFiles.textFile.set(index,replace);
           return true;
        }
        else return false;
    }
           
       // looks for the first occurrence of word "x" in the file and replaces it with word "y" if found returning true, false otherwise.



public  boolean findInsert (String find, String insert) { 
 // looks for the first occurrence of word "x" in the file and then insert "y" right after "x", if x is found, returning true, false otherwise.  

    int index;
       index = ReadFiles.textFile.indexOf(find);
       if (index != -1) {
          ReadFiles.textFile.add(index+1,insert);
           return true;
        }
        else return false;
    }



 
    


     public void spellCheckAll() {

// find all misspelled words and output them to the screen.  
 
         String word;
       
    //ListIterator<String> itr = ReadFiles.textFile.listIterator();
    // while (itr.hasNext()){
       
     for(String s: rF.textFile)
     {   
     word= s.trim();
     //word= word.replaceAll("[\\[\\]_:\"'`?;0-9;()-/.,*! ]", "").toLowerCase();
     //word=word.replaceAll("[]","");
    // System.out.println(word);
     if (rF.wordList.contains(word) && (!rF.stopList.contains(word)))
     {
         if(count.containsKey(word))
         {
             int k = count.get(word);
             count.put(word,k+1);
            }
            else
            {
                count.put(word,1);
            }
        }
    }
    
}
public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
     public static void main(String[] args)
     {
         
         PrimitiveJavaEditor pE = new PrimitiveJavaEditor();
         pE.rF.readTextFile();
         pE.rF.readDictionary();
         pE.rF.readStop();
         pE.spellCheckAll();
         Map<String, Integer> hm1 = sortByValue(pE.count);
         ArrayList<String> wordFrequency = new ArrayList<>();
         for(Map.Entry<String,Integer> en : hm1.entrySet())
         {
             wordFrequency.add(en.getKey() + ", the frequency is = " + en.getValue());
 
            }
            
            System.out.println("the least frequent words are:");
            System.out.println(wordFrequency.get(0));
            System.out.println(wordFrequency.get(1));
            System.out.println(wordFrequency.get(2));
            System.out.println(wordFrequency.get(3));
            System.out.println(wordFrequency.get(4));
            System.out.println();
            System.out.println("the most frequent words are:");
            System.out.println(wordFrequency.get(wordFrequency.size()-1));
            System.out.println(wordFrequency.get(wordFrequency.size()-2));
            System.out.println(wordFrequency.get(wordFrequency.size()-3));
            System.out.println(wordFrequency.get(wordFrequency.size()-4));
            System.out.println(wordFrequency.get(wordFrequency.size()-5));
            
        // pE.most();
         //pE.least();
         
        }
    }
