package com.mycompany.app;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
  public static ArrayList<String> array_diff(ArrayList<String> set0,
    ArrayList<String> set1, boolean tof, int max) {

    if(set0==null || set1==null) {
      return null;
    }
    if(max<=0) {
      return new ArrayList<String>();
    }

    int counter=0;

    ArrayList<String> answer = new ArrayList<String>();
    if(tof) {
      for(String element : set0) {
        if(!contains(set1,element)) {
          answer.add(element);
          if(answer.size()>=max) break;
        }
      }
    } else {
      for(String element : set1) {
        if(!contains(set0, element)) {
          answer.add(element);
          if(answer.size()>=max) break;
        } else {
          counter++;
        }
      }
    }
    return answer;
  }

  public static boolean contains(ArrayList<String> set, String search) {
    for(String element : set) {
      if(element.equals(search))
        return true;
    } return false;
  }

}
