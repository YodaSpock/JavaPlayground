import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class IntermediateProblems {

    //16.1
    //This function swaps two numbers without using a temp variable
    public static void swapNumbers(int x, int y){
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("X: " + x);
        System.out.println("Y: " + y);
    }

    //16.2
    //Finds the number of times a word appears in a book
    public static int findFrequency(String[] book, String word){
        int length = book.length;
        int num = 0;
        for(int i = 0; i < length; i++){
            if(book[i].toLowerCase().equals(word.toLowerCase())){
                num++;
            }
        }
        return num;
    }

    //16.3
    //Given two straight line segments (start point, end point) compute the point of intersection if any.
    public static Point findPoint(Line one, Line two) {
        double new_x = (two.y_intercept - one.y_intercept) / (one.slope - two.slope);
        double new_y = (one.slope * new_x + one.y_intercept);

        //TODO - Add checking for final point between the initial 4 points
        Point intersection = new Point(new_x, new_y);
        return intersection;
    }

    //16.4
    //Algorithm computes a victory for tic tac toe...
    public static boolean CheckVictory(char[][] board, char turn, int x_move, int y_move) {
        if(CheckAcross(board, y_move, turn)){
            System.out.println("Check Across");
            return true;
        }
        if(CheckVertical(board, x_move, turn)){
            System.out.println("Check Vertical");
            return true;
        }
        if(CheckRightDiag(board, turn)){
            System.out.println("Check Right Diag");
            return true;
        }
        if(CheckLeftDiag(board, turn)){
            System.out.println("Check Left Diag");
            return true;
        }
        return false;
    }


    private static boolean CheckAcross(char[][] board, int row, char turn){
        for(int i = 0; i < 3; i++){
            if(board[row][i] != turn){
                return false;
            }
        }
        return true;
    }
    private static boolean CheckVertical(char[][] board, int col, char turn){
        for(int i = 0; i < 3; i++){
            if(board[i][col] != turn) {
                return false;
            }
        }
        return true;
    }
    private static boolean CheckRightDiag(char[][] board, char turn){
        for (int i = 0; i < 3; i++) {
            if (board[i][i] != turn) {
                return false;
            }
        }
        return true;
    }

    private static boolean CheckLeftDiag(char[][] board, char turn){
        int j = 2;
        for (int i = 0; i < 3; i++) {
            if (board[i][j] != turn) {
                return false;
            }
            j--;
        }
        return true;
    }

    //16.6 Find smallest non-negative difference
    private static int closestValues(int[] array1, int[] array2){
        //int location_one = 0;
        //int location_two = 0;
        int smallest_difference = Integer.MAX_VALUE;
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array2.length; j++) {
                    if(((array1[i] - array2[j])) > 0 && ((array1[i] - array2[j]) < smallest_difference)){
                        smallest_difference = array1[i] - array2[j];
                        //location_one = i;
                        //location_two = j;
                    }
                }
            }
        //int[] newest = new int[]{array1[location_one], array2[location_two]};
        return smallest_difference;
    }

    //DO NOT USE -> MORE TIME TO INCREASE RUNTIME, right now infinite loop...
    public static int closestValuesBetter(int[] array1, int[] array2){
        Arrays.sort(array1);
        int[] sorted_arr1 = new int[array1.length];
        for(int i = 0; i < array1.length; i++){
            sorted_arr1[array1.length - i - 1] = array1[i];
        }
        Arrays.sort(array2);


        boolean tooSmall = false;
        int smallest_difference = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while(!tooSmall){
            while (sorted_arr1[i] > array2[j]){
                if((sorted_arr1[i] - array2[j]) < smallest_difference){
                    smallest_difference = sorted_arr1[i] - array2[j];
                }
            }
            if(sorted_arr1[i] < array2[0]){

            }
            j++;
        }
        i++;

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(sorted_arr1));
        System.out.println(Arrays.toString(array2));

        return 0;
    }

    //16.7
    //Number Max - Maximum of Two Numbers
    public static String intEnglish(int num){
        String englishNum = "";

        String[] onesAndTeens = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tensPlace = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        if(num == 0){
            return "Zero";
        }
        else if (num < 0){
            return "Negative " + intEnglish(-1 * num);
        }


        if(num > 0 && num < 20){
            englishNum = englishNum + onesAndTeens[num];
        }


        return englishNum;
    }

    public static void main(String[] args){
        //16.1
        //swapNumbers(4, 5);

        //16.2
        /*String[] book = {"The", "CHILD", "was", "running", "with", "another", "child"};
        System.out.println(findFrequency(book, "Child"));*/

        //16.3
        /*Point p1 = new Point(0, 0);
        Point p2 = new Point (5,3);
        Point p3 = new Point(2, 5);
        Point p4 = new Point(4, 1);
        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p3, p4);
        Point finalPoint = findPoint(l1, l2);

        System.out.println(finalPoint.x);
        System.out.println(finalPoint.y);*/

        //16.4
        /*char[][] board = new char[][] {{'o','x','x'},{'x','o','o'},{' ', 'x', 'o'}};
        boolean winner = CheckVictory(board,'o', 1, 1);
        System.out.println(winner);*/

        //16.6
        /*int[] array1 = new int[]{1, 3, 15, 11, 2};
        int[] array2 = new int[]{23, 127, 235, 19, 8};
        System.out.println(closestValues(array1, array2));
        System.out.println(closestValuesBetter(array1, array2));*/

        //16.7
        System.out.println(intEnglish(-20));


    }
}
