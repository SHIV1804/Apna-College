public class BacktrackingArray36 {
    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void backtrackingArray(int[] nums, int start, int end) {
        if (start == end) {
            print(nums);
            return;
        }
        nums[start] = start + 1;
        backtrackingArray(nums, start + 1, end);
        nums[start] = nums[start] - 2;
    }
    public static void stringSubsets(String string,StringBuilder answer,int i){
        if(i==string.length()) {
            System.out.println(answer);
            return;
        }
        stringSubsets(string, answer.append(string.charAt(i)), i+1);
        answer.deleteCharAt(answer.length()-1);
        stringSubsets(string, answer, i+1);
        
    }
    public static void main(String[] args) {
        int[] nums = new int[10];
        backtrackingArray(nums, 0, 10);
        stringSubsets("Ram",new StringBuilder(), 0);
    }
}
