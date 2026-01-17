import java.util.Scanner;

class Pattern {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the World of pattern\n");
        System.out.print("Please enter your row: ");
        int row= input.nextInt();
        System.out.print("Please enter your column");
        int column=input.nextInt();
        for(int i=0;i<row;i++){
            for(int j=0;j<column-i;j++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
}