import java.util.*;
class Welcome{
    public static void main(String[] args) {

        int[] arr={10, 5, 20, 8};
        //System.out.println(containDuplicate(arr));
        //System.out.println(isAnaGram("rit", "tar"));
//        int[] result=twoSumProblem(arr, 9);
//        System.out.println(result[0]);
//        System.out.println(result[1]);
        //sortColors(arr);
        //System.out.println(containsNearbyDuplicate(arr,2));
        //System.out.println(lengthOfLongestSubstring("pwwkew"));
        //System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        //System.out.println(addBinary("11", "1"));
        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(mySqrt(8));
//        System.out.println(convertToTitle(701));
        System.out.println(secondLargestDistinct(arr));
    }

    /* contain duplicate in a array value
    [1,2,5,3,1] this conatain dupilcate value
    1 logic is brrotforce take first value and compare with other value it will take O(n2) time complexity
    2. sort entire array and check one by one it will take O(nlogn)
    3. use hasset and inset value hasset contain unique value if any value is duplicate then return true. this solution take
    O(n)
     */
    private static boolean containDuplicate(int[] nums){
        HashSet<Integer> result=new HashSet<>();
        for(int num:nums ){
            if(result.contains(num)){
                return true;
            }
            result.add(num);
        }
        return false;
    }
    /* anangram is like one string rat is similar to tar because everykeyword is present in other string
    1. approch take first char and compare with other string that will take O(n) time
    2. check both string length is same and check using array o(n)
    initilar array int[26] every every if it is zero then return true count increment and decrement
     */
    private static boolean isAnaGram( String str1 ,String str2){
        int[] arr=new int[26];
        if(str1.length()!=str2.length()){
            return false;
        }
        for(int i=0;i<str1.length();i++){
            arr[str1.charAt(i)-'a']++;
            arr[str2.charAt(i)-'a']--;
        }
        for(int count:arr){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
    /* start two sun problem example [2,4,8,6,7] target is 14
    1. start with first string and add with other if target meet return true or return false it will take O(n2);
    2. sort the entire array and check it will take O(nlogn).
    3. using hasMap it will take O(n)
     */
    private static int[] twoSumProblem(int[] arr ,int target){
        Map<Integer,Integer> value=new HashMap<>();

        for(int i=0 ;i<arr.length;i++){
            int compliment=target-arr[i];
            if(value.containsKey(compliment)){
                return  new int[] {value.get(compliment),i};
            }
            value.put(arr[i],i);
        }
        return new int[] {};
    }
//    public static int[] topKFrequent(int[] nums, int k) {
//        Map<Integer,Integer> hasMap=new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            if(hasMap.containsKey(nums[i])){
//                hasMap.put(nums[i],hasMap.getOrDefault(nums[i],0)+1);
//            }
//        }
//        Queue<Integer> heap=new PriorityQueue<>((a,b)->hasMap.get(a)-hasMap.get(b));
//        for(int n: hasMap.keySet()){
//            heap.add(n);
//            if(heap.size()>k){
//                heap.pull;
//            }
//        }
//        int[] ans=new int[k];
//        for(int i=0;i<k;i++){
//            ans[i]=heap.pull;
//        }
//        return ans;
//
//    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int index = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length==0){
            return 0;
        }
        int index=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]!=val){
                nums[index]=nums[i];
                index++;
            }
        }
        System.out.println(nums);
        return index;
    }
    public static int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }

            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return left;
    }
    public static int[] plusOne(int[] digits) {
        if(digits.length==0){
            return new int[] {};
        }

        int index=digits.length-1;
        if(digits.length==1 && digits[index]==9){
            return new int[] {1,0};
        }
        for(int i=index;i>=0;i=index--){
            if(digits[index]==9){
                digits[index]=0;
            }
            else{
                digits[index]=digits[index]+1;
                return digits;
            }
        }
        return digits;

    }
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<=numRows;i++){
            int num=1;
            List<Integer> inner=new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                inner.add(num);
                num=num * (i - j) / (j + 1);
            }
            result.add(inner);
        }
        return result;
    }
    public static void sortColors(int[] nums) {
        if(nums.length==0){
            System.out.println("Empty Array");
            return;
        }
        int left=0;
        int mid=0;
        int right=nums.length-1;
        while (mid<=right){
            if(nums[mid]==0){
                int temp=nums[left];
                nums[left]=nums[mid];
                nums[mid]=temp;
                left++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                int temp=nums[mid];
                nums[mid]=nums[right];
                nums[right]=temp;
                right--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public static List<Integer> getRow(int rowIndex) {
            long num=1;
            List<Integer> inner=new ArrayList<>();
            for(int j=0;j<=rowIndex;j++){
                inner.add((int) num);
                num=num*(rowIndex-j)/(j+1);
            }
            return inner;

    }
    public static int maxProfit(int[] prices) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[i]<prices[j]){
                    result.add(prices[j]-prices[i]);
                }
            }
        }
        if(prices.length==0 || result.size()==0){
            return 0;
        }

        return result.stream()
                .max(Integer::compareTo)
                .get();
    }
    public static int maxProfitSecond(int[] prices) {
        if(prices.length==0) {
            return 0;
        }
        long minPrice=Integer.MAX_VALUE;
        long maxProfit=0;
        for(int i=0;i<prices.length;i++){
                if(prices[i]<minPrice){
                    minPrice=prices[i];
                }
                else{
                    maxProfit=Math.max((int) maxProfit,prices[i]-minPrice);
                }
        }
        return (int) maxProfit;
    }
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
        }

        return map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
    if(nums.length==0 || nums.length==1){
        return false;
    }
    int left=0;
    for(int i=0;i<nums.length-1;i++){
        while(left<k)
            if (nums[i] == k && Math.abs(i - k) <= k) {
                return true;
            }

    }
    return false;
    }
    public static int lengthOfLongestSubstring(String s) {
        StringBuilder window = new StringBuilder();
        int max = 0;
        for (char c : s.toCharArray()) {
            while (window.indexOf(String.valueOf(c)) != -1) {
                window.deleteCharAt(0);
            }
            window.append(c);
            max = Math.max(max, window.length());
        }
        return max;

    }

    public static int romanToInt(String s) {
        Map<Character,Integer> map=Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000);
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return map.get(s.charAt(0));
        }
        int count=0;
        char[] data=s.toCharArray();
        for(int i=0;i<data.length-1;i++){
            if(map.get(data[i])>=map.get(data[i+1])){
                count+=map.get(data[i]);
            }
            else{
                count-=map.get(data[i]);
            }
        }
        return count+map.get(data[data.length-1]);
    }
    public static int strStr(String haystack, String needle) {
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }
    public static int lengthOfLastWord(String s) {
        String[] arr=s.split(" ");
        int count=0;
        for(int i=0;i<arr.length;i++){
            if((arr[i]).length()!=0){
                count=arr[i].length();
            }
        }
        return count;
    }
    public static String addBinary(String a, String b) {
        StringBuilder sum= new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry=0;
        while (i>=0 || j>=0 || carry !=0){
            int add=carry;
            if(i>=0){
                add+=a.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                add+=b.charAt(j)-'0';
                j--;
            }
            sum.append(add % 2);
            carry = add / 2;
        }

        return sum.reverse().toString();
    }

    public static boolean isPalindrome(String s) {
        String str= s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int left=0;
        int right=str.length()-1;
        while (left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static int mySqrt(int x) {
        int result=0;
        while((long)result*result<=x){
            result++;;
        }
        return result-1;
    }
    public static String convertToTitle(int columnNumber) {
        Map<Character,Integer> sheet=new HashMap<>();
        StringBuilder result=new StringBuilder();
        if(columnNumber==0){
            return "";
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            sheet.put(c, c - 'A' + 1);
        }
        if(columnNumber/26!=0){
            result.add(sheet.get(columnNumber/26));
        }
        if(columnNumber%26!=0){
            result.add(sheet.get(columnNumber%26));
        }
        return result;
    }


//    1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];

            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }


//2. Maximum Subarray (Kadane)
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = nums[0];

        for(int i=1;i<nums.length;i++){
            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(max, current);
        }

        return max;
    }


//3. Subarray Sum Equals K
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int sum = 0;
        int count = 0;

        for(int num : nums){
            sum += num;

            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        return count;
    }

//    Pattern: Prefix Sum + HashMap
//
//4. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstringChat(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0;
        int max = 0;

        for(int right=0; right<s.length(); right++){

            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }

            set.add(s.charAt(right));
            max = Math.max(max, right-left+1);
        }

        return max;
    }

//    Pattern: Sliding Window
//
//5. Sliding Window Maximum
//
//    Use Deque.

    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[nums.length-k+1];

        int idx = 0;

        for(int i=0;i<nums.length;i++){

            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() &&
                    nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i>=k-1){
                ans[idx++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
   // 6. Reverse Linked List
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
   // 7. Middle of Linked List
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
  // 8. Linked List Cycle
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                return true;
            }
        }

        return false;
    }
   // 9. Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(l1!=null && l2!=null){

            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = (l1!=null)?l1:l2;

        return dummy.next;
    }
  // 10. Remove Nth Node From End
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i=0;i<=n;i++){
            fast = fast.next;
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
  // 11. Factorial
    public int factorial(int n){

        if(n==0)
            return 1;

        return n * factorial(n-1);
    }
  // 12. Fibonacci
    public int fib(int n){

        if(n<=1)
            return n;

        return fib(n-1)+fib(n-2);
    }
   // 13. Power(x,n)
    public double myPow(double x, int n){

        if(n==0)
            return 1;

        double half = myPow(x,n/2);

        if(n%2==0)
            return half*half;

        return half*half*x;
    }
  // 14. Generate Subsets
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int index,
            int[] nums,
            List<Integer> curr,
            List<List<Integer>> result){

        result.add(new ArrayList<>(curr));

        for(int i=index;i<nums.length;i++){

            curr.add(nums[i]);

            backtrack(i+1, nums, curr, result);

            curr.remove(curr.size()-1);
        }
    }
    //15. Permutations
    public List<List<Integer>> permute(int[] nums){

        List<List<Integer>> result = new ArrayList<>();

        dfs(nums,new boolean[nums.length],
                new ArrayList<>(),result);

        return result;
    }

//(Understand backtracking pattern.)

    // 16. Search BST
    public TreeNode searchBST(TreeNode root,int val){

        if(root==null || root.val==val)
            return root;

        if(val < root.val)
            return searchBST(root.left,val);

        return searchBST(root.right,val);
    }
    //17. Insert Into BST
    public TreeNode insert(TreeNode root,int val){

        if(root==null)
            return new TreeNode(val);

        if(val < root.val)
            root.left = insert(root.left,val);
        else
            root.right = insert(root.right,val);

        return root;
    }
  // 18. Validate BST
    public boolean isValidBST(TreeNode root){

        return validate(root,
                Long.MIN_VALUE,
                Long.MAX_VALUE);
    }

    private boolean validate(
            TreeNode node,
            long min,
            long max){

        if(node==null)
            return true;

        if(node.val<=min || node.val>=max)
            return false;

        return validate(node.left,min,node.val)
                && validate(node.right,node.val,max);
    }
 // 19. Lowest Common Ancestor in BST
    public TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q){

        while(root!=null){

            if(p.val<root.val &&
                    q.val<root.val){
                root = root.left;
            }
            else if(p.val>root.val &&
                    q.val>root.val){
                root = root.right;
            }
            else{
                return root;
            }
        }

        return null;
    }

 ///20. Inorder Traversal
    public void inorder(TreeNode root){

        if(root==null)
            return;

        inorder(root.left);

        System.out.print(root.val+" ");

        inorder(root.right);
    }

    //My Practics start
   public static int secondLargestDistinct(int[] arr){
        int max=0;
        int secondLargest=0;
        if(arr.length==0 || arr.length==1){
            return -1;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]>secondLargest && arr[i]<max){
                secondLargest=arr[i];
            }
            if(max==secondLargest && max!=0){
                return -1;
            }
        }
        return secondLargest;
   }

}