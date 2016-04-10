import java.util.ArrayList;
import java.io.*;

public class warmUpQ02{
    
    public static void readFile(String name){
    try{
      FileReader fr = new FileReader(name);
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while(line != null){
        System.out.println(line);
        line = br.readLine();
      }
      br.close();
      fr.close();
    }catch(IOException e){
    }
    
    public ArrayList<String> readFileToArrayList(String p_fileName){
        for(String word: words){
        bw.write(word+"\n");
      }
    }
    
    
}