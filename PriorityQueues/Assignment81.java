


package PriorityQueues;
import java.util.*;




public class Assignment81 {

    static List<Integer> getAllKIntegers(int [] nums,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        List<Integer> answer = new ArrayList<Integer>();

        for (int integer : nums) {
            if (pq.size()<k) {
                pq.add(integer);
            }else{
                if(integer>pq.peek()){
                    pq.poll();
                    pq.add(integer);
                }
            }
            if (pq.size()>=k) {
                answer.add(pq.peek());

            }else{
                answer.add(-1);
            }

        }
        return answer;
    }

    class pathInfo{
        int data;
        int i;
        int j;
        char move;
        pathInfo(int data,int i, int j,char move){
            this.i = i;
            this.j = j;
            this.move = move;
        }
    }


    // public static int pathWithMinCost(int [][] grid,int i,int j){
    //     if (i>=grid.length||j>=grid.length) {
    //         return 0;
    //     }

    //     PriorityQueue<pathInfo> pq = new PriorityQueue<pathInfo>();
    //     int minCost = 0;
    //     if(i<grid.length&&j<grid.length&&i>-1&&j>-1){
    //        if(i==0&&j==0){
    //         pq.add(new pathInfo(grid[i][j+1],i,j,'r'));
    //         pq.add(new pathInfo(grid[i+1][j],i,j,'b'));
    //        }else{
            
    //        }
           
            
    //     }
        
        
    // }
    
    public static void main(String[] args) {
        List<Integer> answer = new ArrayList<Integer>();
        int []nums = {10, 20, 11, 70, 50, 40, 100, 5};
        answer = getAllKIntegers(nums, 3);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i)+" ");
        }
    }
}