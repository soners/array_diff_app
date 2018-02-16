package com.mycompany.app;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;



/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {
    port(getHerokuAssignedPort());

    get("/", (req, res) -> "Hello, World");

    post("/compute", (req, res) -> {
    String input1 = req.queryParams("input1");
    java.util.Scanner sc1 = new java.util.Scanner(input1);
    sc1.useDelimiter("[;\r\n]+");
    java.util.ArrayList<String> inputList = new java.util.ArrayList<>();
    while (sc1.hasNext()){
      String value = sc1.next().replaceAll("\\s","");
      inputList.add(value);
    }
    System.out.println(inputList);

    String input2 = req.queryParams("input2").replaceAll("\\s","");
    java.util.Scanner sc2 = new java.util.Scanner(input2);
    sc1.useDelimiter("[;\r\n]+");
    java.util.ArrayList<String> inputList2 = new java.util.ArrayList<>();
    while (sc2.hasNext()){
      String value = sc2.next().replaceAll("\\s","");
      inputList2.add(value);
    }
    System.out.println(inputList);

    String input3 = req.queryParams("input3").replaceAll("\\s","");
    java.util.Scanner sc3 = new java.util.Scanner(input3);
    boolean b = sc3.nextBoolean();

    String input4 = req.queryParams("input4").replaceAll("\\s","");
    java.util.Scanner sc4 = new java.util.Scanner(input4);
    int i = sc4.nextInt();

    ArrayList<String> result = App.array_diff(inputList, inputList2, b, i);

    Map map = new HashMap();
    map.put("result", result.toString());
    return new ModelAndView(map, "compute.mustache");
    }, new MustacheTemplateEngine());


      get("/compute",
      (rq, rs) -> {
      Map map = new HashMap();
      map.put("result", "not computed yet!");
      return new ModelAndView(map, "compute.mustache");
      },
      new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
    ProcessBuilder processBuilder = new ProcessBuilder();
    if (processBuilder.environment().get("PORT") != null) {
      return Integer.parseInt(processBuilder.environment().get("PORT"));
    }
    return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }


  public static ArrayList<String> array_diff(ArrayList<String> set0,
    ArrayList<String> set1, boolean tof, int max) {

    if(set0==null || set1==null) {
      return null;
    }
    if(max<=0) {
      return new ArrayList<String>();
    }

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
