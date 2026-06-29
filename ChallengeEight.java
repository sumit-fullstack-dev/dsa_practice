import  java.util.*;
class ChallengeEight{
    public static void main(String[] args) {
     Scanner input=new Scanner(System.in);
        System.out.println("Enter First Number :");
        float firstNumber=input.nextFloat();
        System.out.println("Second Number :");
        float  secondNumber=input.nextFloat();
        //operaterUse(firstNumber,secondNumber);
        //floatProduct(firstNumber,secondNumber);
        //areaOfTriangle(firstNumber,secondNumber);
        //simpleInterest(firstNumber,secondNumber,20);
        compoundInterest(firstNumber,secondNumber,20);
        System.out.println("Operators Opration completed");
    }
    // Create a program that takes two numbers and shows result of all
    //arithmetic operators (+,-,*,/,%).
    public static void operaterUse(int firstNumber, int secondNumber){
        int sum=firstNumber+secondNumber;
        System.out.println("Arthmetic operators "+sum);
        int sub=firstNumber-secondNumber;
        System.out.println("Substract operators"+sub);
        int mul=firstNumber*secondNumber;
        System.out.println("Multiple operators "+ mul);
        int div=firstNumber/secondNumber;
        System.out.println("Divion operators "+div);
        int mod=firstNumber%secondNumber;
        System.out.println("Moduler operators "+mod);
    }
    public static void floatProduct(float firstNumber, float secondNumber){
        float result=firstNumber*secondNumber;
        System.out.println("Product of two floating points numbers"+result);
    }
    public static void areaOfTriangle(float base,float height){
        float result=(base*height)/2;
        System.out.println("Area of a Triangle: "+result);
    }
    public  static void simpleInterest(float principal,float rate,int time){
        float result= (principal*rate*time)/100;
        System.out.println("simple interest :"+result);
    }
    public static void compoundInterest(float principal,float rate,int time){
        float result=principal*(1+rate/100)*time;
        System.out.println("Compound Interest is :"+result);
    }
}