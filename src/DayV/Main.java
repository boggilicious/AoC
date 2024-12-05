package DayV;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
  static String[] arr = Input.input.split("\n");
  static ArrayList<String> rules = new ArrayList<>();
  static ArrayList<String> updates = new ArrayList<>();
  static HashMap<String,ArrayList<String>> order = new HashMap<>();
  static ArrayList<List<String>> invalid = new ArrayList<>();
  static ArrayList<String[]> temp = new ArrayList<>();

  public static void main(String[] args) {
    // prep
    for(String item : arr){
      if(item.contains("|")){
        rules.add(item);
      }else if(item.contains(",")) {
        updates.add(item);
      }
    }
    System.out.println("");

    for(String item: rules){
      String [] split = item.split("\\|");
      if(!order.containsKey(split[0])){
        ArrayList<String> temp = new ArrayList<>();
        temp.add(split[1]);
        order.put(split[0], temp);
      }else{
        order.get(split[0]).add(split[1]);
      }
    }

    System.out.println("");

    ArrayList<List<String>> valid = new ArrayList<>();
    outer:
    for(String item: updates){
      List update = Arrays.asList(item.split(","));
      for(int i = 0; i < update.size(); i++){
        ArrayList<String> rules = order.get(update.get(i));
        if(rules != null){
          for(String rule: rules){
            if(update.indexOf(rule) != -1 && i > update.indexOf(rule) ){
              invalid.add(update);
              continue outer;
            }
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
    System.out.println(result);

  }

}
