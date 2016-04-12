// package release ;

import java.util.*;
import java.io.*;
import java.lang.Math;

public class KeywordExtractor 
{

  public static void main(String[] args) 
  {
	// simple check if a *single* parameter was passed to this program 
	// if yes, than start main logic
	// if not exit with a warning to the user
  	if(1 == args.length)
	{
		/*
		  2.2d: main 
		  In the main method, write code that will call these methods on 
		  the provided data set in order to extract the TF-IDF scores of 
		  the words in the articles. Pass in the input folder with
		  the text files as a command-line argument as you did for 2.1d. 
		  In addition, use the provided method printTopKeywords(), which 
		  takes the output of computeTFIDF, and prints the top k keywords by TF-IDF
		  score. Generate the top 5 keywords of each of the 40 articles:
		*/
		
		//NB: Use for loop to iterate through the files in docs directory

		
      	String dir = args[0]; // name of directory with input files
      	HashMap<String, Integer> dfs;
        int l_nDocs = 40;
        // String l_directory = "./docs";
        String l_fileName;
		
		HashMap<String, Integer> l_hmComputeTFS   = new HashMap<String, Integer>();
		HashMap<String, Double>  l_hmComputeTFIDF = new HashMap<String, Double>();
		
		// this will hold the full location of the file and its name
	    //String l_fileLocName = ""; 
		// l_fileLocName = dir + "/" + freqs.txt" ; 

		
		// step1: read the file that is passed as a parameter to this program 
		// ex: "./freqs.txt"
    	dfs = readDocumentFrequencies("./freq.txt");
	    //System.out.println(dfs);
		
    	if ( null == dfs )
    	{
    		System.out.println("FAILED: in readDocumentFrequencies()");
    		System.out.println("Can Not contiue. Aborting...");
    	}
    	else 
    	{
            for(int i=1; i<=l_nDocs; i++)
            {
                l_fileName = dir + "/" + i + ".txt"; 
                
                l_hmComputeTFS = computeTermFrequencies(l_fileName);
                //System.out.println(l_hmComputeTFS);

                l_hmComputeTFIDF = computeTFIDF(l_hmComputeTFS, 
                                                dfs, 
                                                l_nDocs) ; 
                //System.out.println(l_hmComputeTFIDF);

                // takes the output of computeTFIDF, and prints the top k keywords by TF-IDF score.
                System.out.println(l_fileName);
                printTopKeywords(l_hmComputeTFIDF, 5);
                System.out.print("");
    // TODO: 
    //		    take the output from this function and 
    //		    Save this output in a fille called "output.txt"
            }

    	}
    	
	}
	else
	{
		System.out.println("WARNING: must pass [freqs.txt - location] as a parameter to the program");
		System.out.println("ex: KeywordExtractor ./freqs.txt");
	}
	  	  
  }
  
	
	
  /*
    2.2a: readDocumentFrequencies 
	This method reads a frequency file in the format stored by
    writeDocumentFrequencies and returns a HashMap<String, Integer> 
	of the document frequencies of words.
	ex: from the file created "./freq.txt"
  */
  public static HashMap<String, Integer> readDocumentFrequencies(String filename) 
  {
	  int l_value;
	  String l_line;
	  String[] l_words;
	  String l_currWord;
	  HashMap<String, Integer> l_hmDocFreq = new HashMap<String, Integer>();
	  //step1: read in the frequency file 
	  try
	  {
		  FileReader l_fr = new FileReader(filename);
		  BufferedReader l_br = new BufferedReader(l_fr);
		  l_line = l_br.readLine();
		  //step2: iterate through the file line by line
		  while(l_line != null)
		  {
			  l_line.trim();
			  
			  if ( 0 < l_line.length() )
			  {
				  //step3: split key and value by single one white space
				  l_words = l_line.split("[\\s\\W]+");
			      //step4: add key and value to a hashmap
				  //step4.1: convert value [1] to an integer
				  if(2 == l_words.length)
				  {
				  	l_value = Integer.parseInt(l_words[1]);
			   	  	l_hmDocFreq.put(l_words[0], l_value);
				  }
			  }
			  l_line = l_br.readLine(); 
		  }
	      l_fr.close();
          l_br.close();
	  }
	  catch(IOException e)
	  {
		  e.printStackTrace();
	  }
	  catch( Exception e)
	  {
		  e.printStackTrace();
	  }
	  
	  
	 
	  //System.out.println("DEBUG: in readDocumentFrequencies() prm-filename=[" + filename + "]");
	  //step5: return the hashmap
      return l_hmDocFreq;
  }
	
	
  /*  
    2.2b: computeTermFrequencies 
	This method takes a String as input, which is a file name. 
	It reads the contents of the indicated file and returns a 
	HashMap<String, Integer> containing the term
    frequencies of words in the file. 
	It should make the same assumptions about getting words as
    extractWordsFromDocument does.
  */
  public static HashMap<String, Integer> computeTermFrequencies(String filename) 
  {
	  //NB: this method gets called 40 times
	  int l_value;
	  String l_line;
	  String[] l_words;
	  String l_currWord;
	  int l_count = 0;
      HashMap<String, Integer> l_hmTermFreq = new HashMap<String, Integer>();
	  
	  //step1: read in the file that is passed
	  try
	  {
		  FileReader l_fr = new FileReader(filename);
		  BufferedReader l_br = new BufferedReader(l_fr);
		  l_line = l_br.readLine();
		  //step2: iterate through the file line by line
		  while(l_line != null)
		  {		  
			  //step3: use normalize method on each line
			  l_line = normalize(l_line);
			  l_line.trim();
              
			  if ( 0 < l_line.length() )
			  {
				  //step4: use split method to get words in file
				  l_words = l_line.split("[\\s\\W]+");
                  
                  for(int i=0; i < l_words.length; i++)
				  {
					  l_currWord = l_words[i].trim();
                   
					  if ( 0 < l_currWord.length())
					  {
                          //step5: check for current word in the hashmap
                          if (l_hmTermFreq.containsKey(l_currWord))
			              {              
			         	      //step5.1: have a counter that adds the key word to "key" and the number of times key word is in a doc to hash map "value"
			        	      // get the value of the keyWord
			     	          // hm<cat, 2> + 1
				         	  l_count = l_hmTermFreq.get(l_currWord) + 1 ;
				              // put back 3 into hm<cat, 3>
				              l_hmTermFreq.put(l_currWord, l_count);
			              }
						  //step5.2: add word to hashMap if does not yet exist
						  else
						  {
							  l_hmTermFreq.put(l_currWord, 1);
						  }
                          
					  }
					
                  }
				  
			  }
             
              l_line = l_br.readLine();
			  
		  }
		  
	  }
	   catch(IOException e)
	  {
		  e.printStackTrace();
	  }
	  catch( Exception e)
	  {
		  e.printStackTrace();
	  }
	  
	  //step6: return hashMap

    return l_hmTermFreq;
  }
	
	  
  public static String normalize(String word) 
  {
      return word.replaceAll("[^a-zA-Z ']", "").toLowerCase();
  }
  
	
  /*
    2.2c: computeTFIDF 
	This method takes three arguments: 
	(1) a HashMap<String, Integer> of term-frequencies, 
	    - (Comes from 2.2b computeTermFrequencies)

	(2) a HashMap<String, Integer> of document-frequencies, 
	    - (Comes from 2.2a readDocumentFrequencies)
		
	(3) a double containing the number of documents that we have.
	    - (Hardcoded)
		
    This method returns a HashMap<String, Double> 
	which contains the TF-IDF scores of all of the words
	in the HashMap of term frequencies. 
	In other words, the keys of the term frequency HashMap should
    be the same as the keys of the TF-IDF HashMap that is returned.
  */
  
  public static HashMap<String, Double> computeTFIDF(HashMap<String, Integer> tfs, 
													 HashMap<String, Integer> dfs, 
                                                     double nDocs) 
  {
      double l_docFreqRatio;
      String l_key;
      double l_tfsValue;
      double l_dfsValue;
      double l_idf;
      double l_tfidf;
      HashMap<String, Double> l_hmComputeTFIDF = new HashMap<String, Double>();
      
	  //NB: import java Math package
	  
	  //step1: take term frequncy and document frequency hashmaps as arguments
      
	  //step2: get TF from term frequency hashmap
      for (Map.Entry<String, Integer> l_currMap : tfs.entrySet()) 
      {
		  //System.out.println("DEBUG: Key=[" + l_currMap.getKey() + "]" + " Value=[" + l_currMap.getValue() + "]");  
		  l_key = l_currMap.getKey();
		  l_tfsValue = l_currMap.getValue();
          
          //step3: Formulate IDF
          if (dfs.containsKey(l_key))
	      {
              //step3.1: calculate df(w) which is computed in document frequency Hashmap
              l_dfsValue = dfs.get(l_key);
              //step3.2: Divide total number of docs N by the df(w), assign to local variable
              l_docFreqRatio = nDocs / l_dfsValue;
              //step3.3: compute the log of the local variable
              //step3.4: assign calcuted value to idf(w)
              l_idf =  Math.log(l_docFreqRatio);
              //step4: take the value element of each word in term frequency hashmap 
	          //step5: and multiply it with the result from step 3(fomulated IDF)
		      l_tfidf = l_tfsValue * l_idf ;
              //step6: take result (TF-IDF) and add to new Hashmap
		      l_hmComputeTFIDF.put(l_key, l_tfidf);  
          
          }
      } 
	//step7: return new Hashmap  
    return l_hmComputeTFIDF;
	  
  }
	
	
	
	
  /*********************************************************************
   * This method prints the top K keywords by TF-IDF in descending order.
   *********************************************************************/
  public static void printTopKeywords(HashMap<String, Double> tfidfs, int k) 
  {
    ValueComparator vc =  new ValueComparator(tfidfs);
    TreeMap<String, Double> sortedMap = new TreeMap<String, Double>(vc);
    sortedMap.putAll(tfidfs);
    
    int i = 0;
    for(Map.Entry<String, Double> entry: sortedMap.entrySet()) 
	{
      String key = entry.getKey();
      Double value = entry.getValue();
      
      System.out.println(key + " " + value);
      i++;
      if (i >= k) 
	  {
        break;
      }
    }
  } 
	
}


/*
 * This class makes printTopKeywords work. Do not modify.
 */
class ValueComparator implements Comparator<String> 
{
    
    Map<String, Double> map;
    
    public ValueComparator(Map<String, Double> base) 
	{
      this.map = base;
    }
    
    public int compare(String a, String b) 
	{
      if (map.get(a) >= map.get(b)) {
        return -1;
      } else {
        return 1;
      } // returning 0 would merge keys 
    }
}
