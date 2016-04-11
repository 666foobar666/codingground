import java.util.*;
import java.io.*;

public class DocumentFrequency {
  
  public static void main(String[] args) {
    String dir = args[0]; // name of directory with input files
    HashMap<String, Integer> dfs;
    dfs = extractDocumentFrequencies(dir, 40);
    writeDocumentFrequencies(dfs, "freqs.txt");
  }
  
  public static HashMap<String, Integer> extractDocumentFrequencies(String directory, int nDocs) {
    // TODO
    return null;
  }
  
  
  public static HashSet<String> extractWordsFromDocument(String filename) {
    // TODO
    return null;
  }
  
  
  public static void writeDocumentFrequencies(HashMap<String, Integer> dfs, String filename) {
    // TODO
  }
  
  /*
   * This method "normalizes" a word, stripping extra whitespace and punctuation.
   * Do not modify.
   */
  public static String normalize(String word) {
    return word.replaceAll("[^a-zA-Z ']", "").toLowerCase();
  }
  
}