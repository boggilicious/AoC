package dayIX;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public static ArrayList<String> arr = new ArrayList<>();
  public static void main(String[] args) {
    int idCount = 0;

    String input = Input.input;
    for(int i = 0; i < input.length();i++){
      if(i % 2 == 0){
        int a = Character.getNumericValue(input.charAt(i));
        for(int j = 0; j < a; j++){
          arr.add("" + idCount);
        }
        idCount++;
      }else{
        int a = Character.getNumericValue(input.charAt(i));
        for(int j = 0; j < a; j++){
          arr.add(".");
        }
      }
    }

    for(int i = arr.size()-1; i >= 0; i--){
      if(!arr.get(i).equals(".")){
        int pos = getFree();
        Collections.swap(arr, i,pos);
      }
    }

    long result =0;
    arr.remove(0);
    for(int i = 0; i < arr.size(); i++){
      if(arr.get(i).equals("."))
        break;

     result += (long) i * Integer.parseInt(arr.get(i));
    }
    System.out.println("result " + result);
  }

  private static int getFree() {
    for(int i = 0; i < arr.size(); i++){
      if(arr.get(i).equals("."))
        return i;
    }
    return 0;
  }
}
