package FireCode;

import java.util.*;

/**
 * Created by hmaurya on 9/11/2016.
 */
public class Practice {



    public static void flipHorizontalAxis(int[][] matrix) {
        int l = matrix.length;
        int b = matrix[0].length;
        int temp;
        for(int i=0;i<l/2;i++){
            for (int j =0;j<b;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[l-i-1][j];
                matrix[l-i-1][j] = temp;
            }
        }
    }

    public ListNode findMiddleNode(ListNode head) {

        if (head == null) return null;
        else{
            ListNode ptr1, ptr2;
            ptr1 = head;
            ptr2 = head;
            while(ptr2.next != null){
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
                if(ptr2.next != null){
                    ptr2 = ptr2.next;
                }else{
                    return ptr1;
                }
            }
            return ptr1;
        }
    }


    public static int[] bubbleSortArray(int[] arr){
        int temp;
        for(int i =0;i<arr.length;i++){
            for(int j =i+1; j<arr.length;j++){
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    public static void flipItVerticalAxis(int[][] matrix) {
        int l = matrix.length;
        int b = matrix[0].length;
        int t=0;
        for (int j=0;j<b/2;j++){
            for(int i=0;i<l;i++){
                t = matrix[i][j];
                matrix[i][j] = matrix[i][b-j-1];
                matrix[i][b-j-1] = t;
            }
        }
    }

    public static HashMap<Character,Integer> retMap(String s){
        HashMap<Character,Integer> m = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char c;
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if(m.containsKey(c)){
                m.put(c,m.get(c)+1);
            }else {
                m.put(c,1);
            }
        }

        return m;
    }

    public static boolean isIsomorphic(String input1, String input2) {
        char c1,c2;
        if (input1.length() == 0 && input2.length()==0) return true;
        if(input1.length() != input2.length()) return false;

        Map<Character,Integer> m1 = retMap(input1);
        Map<Character,Integer> m2 = retMap(input2);

        for(int i=0;i<input1.length();i++){
            c1 = input1.charAt(i);
            c2 = input2.charAt(i);
            if(m1.get(c1) != m2.get(c2)) return false;
        }
        return true;
    }

    public static String insertPairStar(String s) {


        if (s == null) return null;
        else if(s.length() == 1) return s;
        else if(s.charAt(0) == s.charAt(1)) return s.substring(0,1) + "*" + insertPairStar(s.substring(1,s.length()));
        else return s.substring(0,1) + insertPairStar(s.substring(1,s.length()));

    }

    public static String compressString(String text) {
        StringBuilder sb = new StringBuilder();
        char curr, prev;
        if(text == null) return null;
        curr = text.charAt(0);
        prev = text.charAt(0);
        int count = 0;
        for(int i=0;i< text.length();i++){

            curr = text.charAt(i);
            if(curr == prev){
                count++;
                prev = curr;
            }
            else{
                if(count == 1) sb.append(prev+"");
                else sb.append(prev+""+count+"");
                count=1;
                prev=curr;
            }
        }
        sb.append(curr+""+count+"");
        return (sb.toString().length() < text.length()) ? sb.toString(): text;

    }

    public static boolean isStringPalindrome(String str) {

        if(str == null) return true;
        else{
            for(int i=0,j = str.length()-1; i < j ;i++,j--){
                if(str.charAt(i) != str.charAt(j)) return false;
            }
        }
        return true;

    }

    public static int[] coupleSum(int[] numbers, int target) {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(m.containsKey(target-numbers[i])) return new int[]{m.get(target-numbers[i]),i+1};
            else{
                m.put(target-numbers[i],i+1);
            }
        }
        return null;
    }


    public static Character firstNonRepeatedCharacter(String str) {

        HashMap<Character,Integer> m = new HashMap<>();
        char c ;
        int len = str.length();
        for(int i=0;i<len;i++){
            c = str.charAt(i);
            if(m.containsKey(c)){
                m.put(c,m.get(c)+1);
            }else{
                m.put(c,1);
            }
        }
        for(int i=0;i<len;i++){
            c = str.charAt(i);
            if(m.get(c) == 1) return c;
        }
        return null;
    }

    public static int reverseInt(int x) {

        int reverse = 0;
        int temp = x;

        while( temp !=0){
            reverse = reverse*10 + temp%10;
            temp/=10;
        }

        return reverse;
    }

    public static boolean permutation(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(s2);
        System.out.println(s1);
        System.out.println(s2);
        return Arrays.equals(s1,s2);
    }



    public static ArrayList<String> removeDuplicates(List<String> input) {

        Set<String> s = new HashSet<>();
        for(String t: input){
            s.add(t);
        }
        ArrayList<String> l = new ArrayList<>(s);
        Collections.sort(l);
        return l;
    }

    public static int[] selectionSortArray(int[] arr){

        int t,min = Integer.MAX_VALUE,pos=0;
        for(int i=0;i<arr.length;i++){
            t = arr[i];
            min = arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < min){
                    min = arr[j];
                    pos = j;
                }
            }
            swap(arr,i,pos);

        }
        return arr;
    }

    public static void swap(int[] arr, int i,int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] merge(int[] arrLeft, int[] arrRight){

        int l = arrLeft.length;
        int r = arrRight.length;
        int m =0,n=0;
        int[] arr = new int[l+r];

        int i=0;
        for(;i<l+r;i++){
            if(m<l && n<r){
                if(arrLeft[m] < arrRight[n]){
                    arr[i] = arrLeft[m++];
                }else{
                    arr[i] = arrRight[n++];
                }
            }else{
                break;
            }
        }

        if(m==l){
            for(;i<l+r;i++){
                arr[i] = arrRight[n++];
            }
        }else{
            for(;i<l+r;i++){
                arr[i] = arrLeft[m++];
            }
        }
        return arr;

    }

    public TreeNode findNode(TreeNode root, int val) {

        if(root == null) return null;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode t = st.pop();
            if(t.data == val) return t;
            if(t.left !=null) st.push(t.left);
            if(t.right != null) st.push(t.right);
        }
        return  null;
    }

    public static String computeBinary(int val) {

        StringBuilder sb = new StringBuilder();
        if(val ==0) return "0";
        while(val != 0){
            sb.append(val%2 + "");
            val/=2;
        }
        return sb.reverse().toString();
    }


    public static boolean validateBST(TreeNode root) {

        if(root != null){
            if(root.left != null && root.right!=null)
                if(!(root.left.data < root.data) || !(root.data<root.right.data)){
                    return false;
                }


        }
        return validateBST(root.left) && validateBST(root.right);
    }


    public static int[][] transposeMatrix(int[][] matrix) {
        int temp = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i<j) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        return  matrix;
    }

    public static boolean isPowOfTwo(int n) {

        return (n > 0) && ((n & (n - 1)) == 0);

    }

    public static String duplicate(int[] numbers){
        TreeSet<Integer> s = new TreeSet<>();
        ArrayList<Integer> l = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            if(s.contains(numbers[i])) l.add(numbers[i]);
            else s.add(numbers[i]);
        }
        return l.toString();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;

        ListNode t1 = head,t2 = head;
        while(t1!=null){
            len++;
            t1=t1.next;
        }
        if(n==len || (len == 1 && n==1)) return null;
        if(n <= len) {

            int cfs = len - n + 1;

            t1 = head;
            for (int i = 0; i < cfs - 2; i++) {
                t1=t1.next;
            }
            t2 = t1.next;
            t1.next=t2.next;
            t2.next=null;
        }

        return head;
    }

    public static int getMaxRepetition(int[] a) {
        int k = a.length;
        for(int i=0;i<k;i++){
            a[a[i]%k] += k;
        }

        int max = Integer.MIN_VALUE;
        int idx=0;
        for(int i=0;i<k;i++){
            if(a[i] > max){
                max = a[i];
                idx = i;
            }
        }
        return idx;
    }


    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervalsList) {
        if(intervalsList == null ) return null;
        int len = intervalsList.size();
        if( len == 1) return intervalsList;
        ArrayList<Interval> mergedInterval = new ArrayList<>();
        Collections.sort(intervalsList, new IntervalComparatorByFirstValue());
        Interval i1=null,i2=null;
        for(int i=1;i<len;i++){
            i1 = intervalsList.get(i-1);            i2 = intervalsList.get(i);

            if(i2.start <= i1.end){
                mergedInterval.add(new Interval(i1.start,i2.end));
            }else{
                mergedInterval.add(i1);
                mergedInterval.add(i2);
            }
            
        }

            return intervalsList;
    }

    static class IntervalComparatorByFirstValue implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }


    public static void main(String[] args) {
        System.out.println(duplicate(new int[]{1,5,23,2,6,3,1,8,12,3}));

    }
}


class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

class Interval {
    int start;
    int end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}