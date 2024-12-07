package DayVI;

public class Main {
  public static char [][] field;
  public static int x;
  public static int y;
  public static dir current = dir.UP;
  public static int countO = 0;

  enum dir{
    UP,
    DOWN,
    LEFT,
    RIGHT,
  }
  public static void main(String[] args) {


    String[] temp = Input.input.split("\n");
    int lengthX = temp[0].length();
    int lengthY = temp.length;

    field = new char[lengthX][lengthY];

    for(int i = 0; i < lengthX; i++){
      for(int j = 0; j < lengthY; j++){
        field[i][j] = temp[i].charAt(j);
        if(temp[i].charAt(j) == '^'){
          x = i;
          y = j;
          field[x][y] = 'X';
        }
      }
    }

    for(int i = 0; i < lengthX; i++){
      for(int j = 0; j < lengthY; j++){
        char cur = field[i][j];
        field[i][j] = 'O';
        if (tryField(field, x,y)){
          countO++;
        }
        field[i][j] = cur;
      }
    }


    System.out.println("now:" + countO);


    /*
    try{
      while(true){
        switch(current){
          case UP:
            if (field [x-1][y] != '#'){
              x -= 1;
              field[x][y] = 'X';
            }
            else{
              turnRight();
            }
            break;
          case DOWN:
            if (field [x+1][y] != '#'){
              x += 1;
              field[x][y] = 'X';
            }
            else{
              turnRight();
            }
            break;
          case LEFT:
            if (field [x][y-1] != '#'){
              y -= 1;
              field[x][y] = 'X';
            }
            else{
              turnRight();
            }
            break;
          case RIGHT:
            if (field [x][y+1] != '#'){
              y += 1;
              field[x][y] = 'X';
            }
            else{
              turnRight();
            }
            break;
        }
      }

    }catch (Exception ignored){}
    int count = 0;
    for(int i = 0; i < field.length; i++ ){
      for(int j = 0; j < field[i].length; j++){
        if(field[i][j] == 'X')
          count ++;
      }
    }

    System.out.println("count" + count);

     */
  }

  private static void turnRight() {
    switch (current){
      case UP -> current = dir.RIGHT;
      case DOWN -> current = dir.LEFT;
      case RIGHT -> current = dir.DOWN;
      case LEFT -> current = dir.UP;
    }
  }

  public static boolean tryField(char[][] arr, int x, int y){
    int count = 0;
    try{
      while(true){
        switch(current){
          case UP:
            if(field [x-1][y] == 'O'){
              count++;
              if(count >= 10){
                return true;
              }
              turnRight();
            }
            else if (field [x-1][y] != '#' || field [x-1][y] != 'O' ){
              x -= 1;
              field[x][y] = 'X';
            }
            else{
              turnRight();
            }
            break;
          case DOWN:
            if(field [x+1][y] == 'O'){
              count++;
              if(count >= 10){
                return true;
              }
              turnRight();
            }else if (field [x+1][y] != '#'){
              x += 1;
              field[x][y] = 'X';
            }
            else{
              turnRight();
            }
            break;
          case LEFT:
            if(field [x][y-1] == 'O'){
              count++;
              if(count >= 10){
                return true;
              }
              turnRight();
            }else if (field [x][y-1] != '#'){
              y -= 1;
              field[x][y] = 'X';
            }
            else{
              turnRight();
            }
            break;
          case RIGHT:
            if(field [x][y+1] == 'O'){
              count++;
              if(count >= 10){
                return true;
              }
              turnRight();
            }else if (field [x][y+1] != '#'){
              y += 1;
              field[x][y] = 'X';
            }
            else{
              turnRight();
            }
            break;
        }
      }

    }catch (Exception ignored){
      return false;
    }
  }
}
