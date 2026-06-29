import java.util.*;
class MyFile{
    public static void main(String[] args) {
        int[] arr={ 1, 2, 3, 4};

        System.out.println(longestSubarray(arr, 6));
    }
    //My Practics start
    public static int secondLargestDistinct(int[] arr){
        if(arr.length==0 || arr.length<2){
            return -1;
        }
        int max=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        for(int num:arr){
            if(num>max){
                secondLargest=max;
                max=num;
            }
            else if(num>secondLargest && num!=max){
                secondLargest=num;
            }
        }
        return secondLargest==Integer.MIN_VALUE?-1:secondLargest;
    }

    public  static int[] twoSum(int[] arr ,int target){
//        [2,7,11,15]
//        and target:9
        if(arr.length==0){
            return new int[] {};
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int comp=target-arr[i];
            if(map.containsKey(comp)){
                return new int[] {map.get(comp),i};
            }
            map.put(arr[i],i);
        }
        return new int[] {};
    }
    public static int subarraysProblem(int[] arr,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int result=0;
        int sum=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]+sum==k){
                    result++;
                    sum=0;
                }
                map.put(arr[i],sum);
        }
        return result;
    }
    public static int[] sumElement(int[] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int comp=arr[i]-target;
            if(map.containsKey(comp)){
                return new int[] {map.get(comp),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{};
    }

    public static int longestSubarray(int[] arr, int target)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int maxlength=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==target){
                maxlength=i+1;;
            }
            if(map.containsKey(sum-target)){
                maxlength=Math.max(maxlength,i-map.get(sum-target));
            }
            map.putIfAbsent(sum,i);
        }
        return maxlength;
    }

}