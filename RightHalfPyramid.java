import java.util.*;
class RightHalfPyramid{

public static void main(String[] args) {
        System.out.println("Welcome to pattern world");
        Scanner input =new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int row=input.nextInt();
        System.out.println("Enter number of column: ");
        int column=input.nextInt();
        for(int startRow=0;startRow<=row;startRow++){
            for(int startColumn=column-startRow;startColumn<column;startColumn++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }

    }
        }