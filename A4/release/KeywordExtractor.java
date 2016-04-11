import java.util.*;
import java.io.*;

public class KeywordExtractor {
  public static void main(String[] args) {
    String dir = args[0]; // name of directory with input files
    HashMap<String, Integer> dfs;
    dfs = readDocumentFrequencies("freqs.txt");
  }
  
  public static HashMap<String, Integer> computeTermFrequencies(String filename) {
    // TODO
    return null;
  }
  
  public static HashMap<String, Integer> readDocumentFrequencies(String filename) {
    // TODO
    return null;
  }
  
  public static HashMap<String, Double> computeTFIDF(HashMap<String, Integer> tfs, HashMap<String, Integer> dfs, 
                                                     double nDocs) {
    // TODO
    return null;
  }
  
  /**
   * This method prints the top K keywords by TF-IDF in descending order.
   */
  public static void printTopKeywords(HashMap<String, Double> tfidfs, int k) {
    ValueComparator vc =  new ValueComparator(tfidfs);
    TreeMap<String, Double> sortedMap = new TreeMap<String, Double>(vc);
    sortedMap.putAll(tfidfs);
    
    int i = 0;
    for(Map.Entry<String, Double> entry: sortedMap.entrySet()) {
      String key = entry.getKey();
      Double value = entry.getValue();
      
      System.out.println(key + " " + value);
      i++;
      if (i >= k) {
        break;
      }
    }
  }  
}

/*
 * This class makes printTopKeywords work. Do not modify.
 */
class ValueComparator implements Comparator<String> {
    
    Map<String, Double> map;
    
    public ValueComparator(Map<String, Double> base) {
      this.map = base;
    }
    
    public int compare(String a, String b) {
      if (map.get(a) >= map.get(b)) {
        return -1;
      } else {
        return 1;
      } // returning 0 would merge keys 
    }
  }