package DayVIII;

import java.awt.*;

public class Main {

  public static void main(String[] args) {
    String [] arr = Input.input.split("\n");
    char [][] field = new char[arr.length][arr[0].length()];
    char [][] nodes = new char[arr.length][arr[0].length()];

    for(int i = 0; i < arr.length; i++){
      for(int j = 0; j < arr[i].length(); j++){
        field[i][j] = arr[i].charAt(j);
      }
    }
    System.out.println("");

    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[i].length; j++) {
        if (field[i][j] != '.') {
          for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[x].length; y++) {
              if ((i != x || j != y) && field[i][j] == field[x][y]) {
                findNodes(i, j, x, y, nodes);
              }
            }
          }
        }
      }
    }

    System.out.println("");

    int count = 0;
    for(int i = 0; i < nodes.length; i++){
      for (int j = 0; j < nodes[i].length; j++){
        if(nodes[i][j] == '#'){
          count++;
        }
      }
    }
    System.out.println("count:" + count);
  }

  private static void findNodes(int i, int j, int x, int y, char [][] arr) {
    System.out.println(i + " " + j +", " + x + " " + y );
    int newX = x + 2 * (i - x);
    int newY = y + 2 * (j - y);

    try{
      arr[newX][newY] = '#';
    }catch (Exception ignored){}

  }
}
