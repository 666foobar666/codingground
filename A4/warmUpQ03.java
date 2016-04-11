import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

public class warmUpQ03
{
   public static void main(String[] args)
   {
      int l_numberOfWords;
      ArrayList<String> l_words = new ArrayList<String>();
    
      l_words = readFileToArrayList("HelloWorld.java");
    
      printArrayList(l_words);
      
      l_numberOfWords = getNumberOfWords(l_words) ; 
      System.out.println ("Number of words in file=[" + l_numberOfWords + "]");
   }  
   
   public static ArrayList<String> readFileToArrayList(String p_fileName)
   {
      ArrayList<String> l_returnWords = new ArrayList<String>();
      try
      {
         // step0: open file and read it into a buffer
         FileReader l_fr = new FileReader(p_fileName);
         BufferedReader l_br = new BufferedReader(l_fr);
         String l_line = l_br.readLine();
            
         // step1: iterate through the file
         while(l_line != null){
            // step2: assign the line to an ArrayList
            l_returnWords.add(l_line.trim());
            //System.out.println("DEBUG: l_line.length=[" + l_line.trim().length() + "]" );
            // step3: grap a line from a file
            l_line = l_br.readLine();
         }
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
      
      return( l_returnWords );
   }
   
   public static void printArrayList(ArrayList<String> p_words)
   {
      // step1: iterate through ArrayList
      for(String l_word: p_words){
         // step2: print to console each element
         System.out.println(l_word);
      }
     
      
   }
   public static int getNumberOfWords(ArrayList<String> p_words)
   {
      int l_counter = 0;
      String[] l_words;
      
      //step 1: iterate through ArrayList
      for(String l_line: p_words)
      {
         //step2: print to console each element
         //System.out.println(l_line);
         //step3: separate each line into words and assign to an array
         // l_words = l_line.trim().split("\\s+");
         l_line.trim();
         if ( 0 < l_line.length() )
         {
            l_words = l_line.trim().split("[\\s\\W]+");
            
            System.out.println(Arrays.toString(l_words));
            System.out.println("DEBUG: numb of words=[" + l_words.length + "]" );
                     
            //step4: count words (get array length) and assign to "counter"
            l_counter = l_counter + l_words.length;
         }
      }
      //step5: return varaiable "counter"
      return l_counter;
   }
   
    
}
