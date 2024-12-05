package DayFour;



public class Main {
  static String [] arr = Input.input.split("\n");
  static char [][] input = new char[arr.length][arr[0].length()];
  static int x = 0;
  public static void main(String[] args) {

    for(int i = 0; i < arr.length; i++){
      for(int j = 0; j < arr[0].length(); j++){
        input[i][j] = (arr[i].charAt(j));
      }
    }

    System.out.println("");

    int count = 0;
    for(int i = 0; i < input.length; i++){
      inner:
      for(int j = 0; j < input[i].length; j++){

        switch(input[i][j]){
          case 'X':
            count += checkHor(i,j);

            count += checkDiag(i, j);

            count += checkVert(i,j);
            break;
          case 'A':
            checkXMAS(i,j);
            break;
          default:
            continue;
        }
      }
    }
    System.out.println("First:"+ count);
    System.out.println("X-Count:"+x );
    return;
  }

  private static int checkVert(int i, int j) {
    int count = 0;
    // UP
    try{
      if(input[i-1][j] =='M' && input[i-2][j] =='A' && input[i-3][j] =='S' )
        count ++;
    }catch (Exception ignored){}

    // DOWN
    try{
      if(input[i+1][j] =='M' && input[i+2][j] =='A' && input[i+3][j] =='S' )
        count ++;
    }catch (Exception ignored){}
    return count;
  }

  private static int checkDiag(int i, int j) {
    int count = 0;

    // UP Left
    try{
      if(input[i-1][j-1] =='M' && input[i-2][j-2] =='A' && input[i-3][j-3] =='S' )
        count ++;
    }catch (Exception ignored){}

    // UP rigth
    try{
      if(input[i-1][j+1] =='M' && input[i-2][j+2] =='A' && input[i-3][j+3] =='S' )
        count ++;
    }catch (Exception ignored){}

    // down left
    try{
      if(input[i+1][j-1] =='M' && input[i+2][j-2] =='A' && input[i+3][j-3] =='S' )
        count ++;
    }catch (Exception ignored){}

    // down right
    try{
      if(input[i+1][j+1] =='M' && input[i+2][j+2] =='A' && input[i+3][j+3] =='S' )
        count ++;
    }catch (Exception ignored){}
    return count;
  }

  private static int checkHor(int i, int j) {
    int count = 0;
    try{
      if(input[i][j+1] =='M' && input[i][j+2] =='A' && input[i][j+3] =='S' )
        count ++;
    }catch (Exception ignored){}

    try{
      if(input[i][j-1] =='M' && input[i][j-2] =='A' && input[i][j-3] =='S' )
        count ++;
    }catch (Exception ignored){}

    return count;
  }

  private static void checkXMAS(int i, int j){
    boolean firstDiagonal = false;
    boolean secondDiagonal = false;
    try{
      if(input[i-1][j-1] == 'M' && input[i+1][j+1]== 'S' ||
        input[i-1][j-1] == 'S' && input[i+1][j+1]== 'M'){
        firstDiagonal = true;
      }
    } catch (Exception ignored){}

    try{
      if(input[i-1][j+1] == 'M' && input[i+1][j-1]== 'S' ||
        input[i-1][j+1] == 'S' && input[i+1][j-1]== 'M'){
        secondDiagonal = true;
      }
    } catch (Exception ignored){}

    if(firstDiagonal && secondDiagonal)
      x++;
  }
}

