import java.util.ArrayList;
import java.io.*;

public class warmUpQ02
{
   public static void main(String[] args)
   {
      ArrayList<String> l_words = new ArrayList<String>();
    
      l_words = readFileToArrayList("HelloWorld.java");
    
      printArrayList(l_words);
   }  
  
    
   public static ArrayList<String> readFileToArrayList(String p_fileName)
   {
      ArrayList<String> l_returnWords = new ArrayList<String>();
      
     
      try
      {
         // step0: open file and read it into a buffer
         FileReader l_fr = new FileReader(p_filename);
         BufferedReader l_br = new BufferedReader(l_fr);
         String l_line = l_br.readLine();
            
         // step1: iterate through the file
         while(l_line != null){
            // step2: assign the line to an ArrayList
            l_returnWords.add(l_line);
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
      // step2: print to console each element
      
      
   }
    
    
}
