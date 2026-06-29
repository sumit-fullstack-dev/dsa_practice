import java.util.*;
class ArrayData{
    public static void main(String[] args) {
        int[] nums={1,2,3,2,5,6,7};
        int k=3;
        System.out.println(duplicate(nums));

    }
    public  static int[] rotateArray(int[] arr,int k){
        int[] result=new int[arr.length];
        int size= arr.length-k;
        int index=0;
        for (int i=size;i< arr.length;i++){
            result[index]=arr[i];
            index++;
        }
        for(int j=0;j<size;j++){
            result[index]=arr[j];
            index++;
        }
        return result;
    }
    public static int[] reverseArray(int[] arr){

        for(int i=0;i< arr.length/2;i++){
            int temp =arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
        return arr;
    }
    public static boolean duplicate(int[] arr){
        HashSet<Integer> set=new HashSet<>();
        for(int num:arr){
            if(set.contains(num)) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsDuplicate(int[] arr,int k){
       // nums = [1,2,3,1]
        // k = 3 [0:1,1:2,2:3,4:1]
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i< arr.length;i++){

        }
    }


}