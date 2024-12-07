package DayVII;

import java.util.ArrayList;

public class Main {

  enum opr{
    MUL,
    ADD
  }

  public static void main(String[] args) {
    String [] temp = Input.input.split("\n");
    ArrayList<ArrayList<Long>> arr = new ArrayList<>();

    for(String s: temp){
      String [] t = s.split(" |:");
      ArrayList<Long> line = new ArrayList<>();
      for(String v: t){
        if(!v.isEmpty()){
          line.add(Long.parseLong(v));
        }
      }
      arr.add(line);
    }

    ArrayList<Long> valid = new ArrayList<>();

    for(ArrayList<Long> cur: arr) {
      if (recursive(cur, 2, cur.get(1)))
        valid.add(cur.get(0));
    }
    System.out.println("");

    long result = 0;

    for(long i: valid){
      result += i;
    }

    System.out.println("tada:" + result);
  }

  public static boolean recursive(ArrayList<Long> arr, int pos, long cur){
    if(pos == arr.size()){
      return cur == arr.get(0);
    }
    if(recursive(arr, pos+1, cur + arr.get(pos))){
      return true;
    }
    if(recursive(arr, pos+1, Long.parseLong(cur + "" + arr.get(pos))))
      return true;
    return recursive(arr, pos + 1, cur * arr.get(pos));

  }
}

