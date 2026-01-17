import  java.util.*;
class SwapNumber{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter  first number: ");
        int firstNumber=input.nextInt();
        System.out.println("Enter Second Number: ");
        int secondNumber=input.nextInt();
        System.out.println("Before Swap first number"+firstNumber+" Second number"+secondNumber);
        firstNumber= firstNumber+secondNumber;
        secondNumber=firstNumber-secondNumber;
        firstNumber=firstNumber-secondNumber;
        System.out.println("After Swap first number "+firstNumber+" Second number "+secondNumber);
    }
}