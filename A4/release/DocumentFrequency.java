// package release ; 

import java.util.*;
import java.io.*;

public class DocumentFrequency {
  
  public static void main(String[] args) 
  {
	  
	
	// simple check if a *single* parameter was passed to this program 
	// if yes, than start main logic
	// if not exit with a warning to the user  
	if(1 == args.length)
	{
		String dir = args[0]; // name of directory with input files
		HashMap<String, Integer> dfs;
		
		// this will hold the full location of the file and its name
    	String l_fileLocName = ""; 
		
        dfs = extractDocumentFrequencies(dir, 40); 
		
		//System.out.println(dfs);
	
		l_fileLocName = "./" + "freqs.txt" ; 
		
        writeDocumentFrequencies(dfs, l_fileLocName);
		
		//testHarn01();
		
	}
	else
	{
		System.out.println("WARNING: must pass [directory] as a parameter to the program");
		System.out.println("ex: DocumentFrequency ./docs");
	}
	  
  }
  
  public static HashMap<String, Integer> extractDocumentFrequencies(String directory, int nDocs) 
  {
      HashMap<String, Integer> l_wordDocFreq = new HashMap<String, Integer>();
	  HashSet<String> l_hsWords = new HashSet<String>();
	  int l_count = 0;
	  String l_fileName;
	 
	  
	  //step1: iterate through the files in the folder
	  for(int i=1; i<=nDocs; i++)
	  {

  		  l_fileName = directory + "/" + i + ".txt"; 
		  
		  l_hsWords = extractWordsFromDocument(l_fileName);
		  //step2: iterate through words in the files, extracting each one
		  for(String l_currWord: l_hsWords)
		  {
			  //step3: check for current word in the hashmap
			  if (l_wordDocFreq.containsKey(l_currWord))
			  {
				  //step4: have a counter that adds the number of docs word is in to hash map
				  // get the value of the keyWord
				  // hm<cat, 2> + 1
				  l_count = l_wordDocFreq.get(l_currWord) + 1 ;
				  // put back 3 into hm<cat, 3>
				  l_wordDocFreq.put(l_currWord, l_count);
			  }
			  //step4.5: add word to hashMap if does not yet exist
			  else
			  {
				  l_wordDocFreq.put(l_currWord, 1);
			  }
	  
		  }

	  }
  
	  return(l_wordDocFreq);
  }
  
  
  public static HashSet<String> extractWordsFromDocument(String filename) 
  {
	String[] l_words;
	String l_currWord;
	HashSet<String> l_hsWords = new HashSet<String>();
	  
	try
	{
    	//step1: read in file that is passed
        FileReader l_fr = new FileReader(filename);
        BufferedReader l_br = new BufferedReader(l_fr);
        String l_line = l_br.readLine();
		l_line.trim();
            
        //step1.2: and iterate the file line at a time
        while(l_line != null)
		{
           //System.out.println("DEBUG: l_line.length=[" + l_line.trim().length() + "]" );
		   //step2: use normalize method on the line from file
		   l_line = normalize(l_line);
		   l_line.trim();
		   //step3: use split method to get the words in the documents
		   if ( 0 < l_line.length() )
           { 			    

            	l_words = l_line.split("[\\s\\W]+");
			    //step4: iterate through word array, add each element to hash set
			    for(int i=0; i < l_words.length; i++)
				{
					l_currWord = l_words[i].trim();
					if ( 0 < l_currWord.length())
					{
						l_hsWords.add(l_currWord);
					}
					
				}
		   }	
		   // grap a line from a file
           l_line = l_br.readLine();
        }
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
    return l_hsWords;
  }
	
  
  public static void writeDocumentFrequencies(HashMap<String, Integer> dfs, String filename) 
  {
      //step1: iterate through a hashmap
      //step1.5: sort hasmap by the key string
	  Map<String, Integer> l_treeMap = new TreeMap<String, Integer>(dfs);
	  
	  //printMap(l_treeMap);
      
      try
      {

        FileWriter l_fw = new FileWriter(filename);
        BufferedWriter l_bw = new BufferedWriter(l_fw);

  		for (Map.Entry<String, Integer> l_currMap : l_treeMap.entrySet()) 
		{
			//System.out.println("Key=[" + l_currMap.getKey() + "]" + " Value=[" + l_currMap.getValue() + "]");
            //step2: write the contents to the file	
            //step3: write in the form of key value
        
            l_bw.write(l_currMap.getKey() + " " + l_currMap.getValue() + "\n");
		}
        
        l_bw.close();
        l_fw.close();

	  }
      catch(IOException e)
	  {
		  e.printStackTrace();
	  }
	  catch( Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  
  /*
   * This method "normalizes" a word, stripping extra whitespace and punctuation.
   * Do not modify.
   */
  public static String normalize(String word) 
  {
    return word.replaceAll("[^a-zA-Z ']", "").toLowerCase();
  }

	
  public static void printHashSet(HashSet<String> p_words)
  {
      // step1: iterate through ArrayList
      for(String l_word: p_words)
	  {
         // step2: print to console each element
		 System.out.println("["+l_word+"]"); 
	  }
  }
	
  public static void testHarn01()
  {
	  
	  HashSet<String> l_hsWords = new HashSet<String>();
	  
	  l_hsWords = extractWordsFromDocument("./docs/7.txt");
	  
	  printHashSet(l_hsWords);
	  
	  //l_hsWords = extractWordsFromDocument("./docs/7.txt");	
	  //printHashSet(l_hsWords);
	  
  }
	
  public static void printMap(Map<String, Integer> p_map) 
  {
	  for (Map.Entry<String, Integer> l_currMap : p_map.entrySet()) 
	  {
		System.out.println("Key=[" + l_currMap.getKey() + "]" + " Value=[" + l_currMap.getValue() + "]");
	  }
  }
	
}

