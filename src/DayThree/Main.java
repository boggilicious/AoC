package DayThree;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static ArrayList<String> findInstruction(){
    String regex = "mul\\([0-9]{1,3},[0-9]{1,3}\\)|do\\(\\)|don't\\(\\)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(Input.input);

    ArrayList<String> results = new ArrayList<>();

    while (matcher.find()) {
      String str = matcher.group();
      results.add(str);
    }
    return results;
  }

  static int result = 0;
  public static void main(String[] args) {
    ArrayList<String> candidates = findInstruction();
    boolean b = true;
    for(String item : candidates){
      switch(item.substring(0,3)){
        case "don":
          b = false;
          break;
        case "do(":
          b = true;
          break;
        default:
          if(b){
            item = item.substring(4,item.length()-1);
            System.out.println(item);
            String arr[] = item.split(",");
            result += Integer.parseInt(arr[0]) * Integer.parseInt(arr[1]);
          }
          break;
      }
    }

    System.out.println(result);
  }
}
