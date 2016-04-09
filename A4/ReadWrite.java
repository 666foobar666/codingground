import java.util.ArrayList;
import java.io.*;

public class ReadWrite{
  public static void main(String[] args){
    ArrayList<String> words = new ArrayList<String>();
    words.add("apples");
    words.add("pears");
    words.add("kittens");
    words.add("rabbits");
    writeStrings(words, "words.txt");
    readFile("words.txt");
  
  }  
  
  //method to read in a file
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
  }
  
  //method that writes an arraylist of string to file
  public static void writeStrings(ArrayList<String> words, String filename){
    try{
      FileWriter fw = new FileWriter(filename);
      BufferedWriter bw = new BufferedWriter(fw);
      
      for(String word: words){
        bw.write(word+"\n");
      }
      
      bw.close();
      fw.close();
    }catch(IOException e){
      System.out.println("io error");
    }
  }
}