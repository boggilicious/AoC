package DayV;

import java.util.*;

public class MainSecond {
  static String[] arr = Input.input.split("\n");
  static ArrayList<String [] > rules = new ArrayList<>();
  static ArrayList<String> updates = new ArrayList<>();
  static ArrayList<List<String>> invalid = new ArrayList<>();

  public static void main(String[] args) {
    // prep
    for(String item : arr){
      if(item.contains("|")){
        rules.add(item.split("\\|"));

      }else if(item.contains(",")) {
        updates.add(item);
      }
    }
    System.out.println("");


    System.out.println("");

    ArrayList<List<String>> valid = new ArrayList<>();

    outer:
    for(String item: updates){
      List update = Arrays.asList(item.split(","));
        for(String[] rule: rules){
          if(update.contains(rule[0]) && update.contains(rule[1])){
            if(update.indexOf(rule[0]) > update.indexOf(rule[1])){
              invalid.add(update);
              continue outer;
            }
          }
      }
        valid.add(update);
    }
    System.out.println("");

    int result = 0;
    for (List<String> item : valid){
      result += Integer.parseInt(item.get(item.size()/2));
    }
    System.out.println("first" + result);
    boolean fix = true;
    while(fix){
      fix = false;
      outer:
      for(List item: invalid){
        for(String[] rule: rules){
          if(item.contains(rule[0]) && item.contains(rule[1])){
            if(item.indexOf(rule[0]) > item.indexOf(rule[1])){
              Collections.swap(item,item.indexOf(rule[0]), item.indexOf(rule[1]));
              fix = true;
              continue outer;
            }
          }
        }
      }
    }

    result = 0;
    for (List<String> item : invalid){
      result += Integer.parseInt(item.get(item.size()/2));
    }
    System.out.println("second" + result);

  }


}
