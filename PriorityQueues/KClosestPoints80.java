

package PriorityQueues;
import java.util.*;

public class KClosestPoints80 {

    static class PiontsInfo implements Comparable<PiontsInfo> {
        int x,y,distSq,i;
        PiontsInfo(int x,int y,int distSq,int i) {
            this.x=x;this.y=y;this.distSq=distSq;this.i=i;
        }
        @Override
        public int compareTo(PiontsInfo temp){
            return this.distSq-temp.distSq;
        }
    }
    static void findKClosestPoints(int [][]points,int k){
        PriorityQueue<PiontsInfo> pq = new PriorityQueue<>();
        for (int index = 0; index < points.length; index++) {
            pq.add(new PiontsInfo(points[index][0], points[index][1],( points[index][0]*points[index][0]+points[index][1]*points[index][1] ),index));
        }
        for (int i = 0; i < k; i++) {
            System.out.print("P"+pq.remove().i+" ");
        }
    }

    static int minCostToConnectRopes(int []ropes){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int cost=0;
        while(pq.size()>1){
            int sum = pq.remove()+pq.remove();
            cost+=sum;
            pq.add(sum);
        }
        return cost;
    }

    static class matrixInfo implements Comparable<matrixInfo>{
        int count;
        int index;
        matrixInfo(int count, int index){
            this.count = count;
            this.index = index;
        }
        @Override
        public int compareTo(matrixInfo temp){
            return (this.count == temp.count)?this.index-temp.index:this.count-temp.count;
        }
    }

    static void weakestSoldier(int [][] binaryMatrix,int k){
        PriorityQueue<matrixInfo> pq = new PriorityQueue<>();
        for (int i = 0; i < binaryMatrix.length; i++) {
            int count=0;
            for(int j = 0; j < binaryMatrix[0].length; j++){
                if(binaryMatrix[i][j] ==1){
                    count++;
                }
            }
            pq.add(new matrixInfo(count, i));
        }
        for (int i = 0; i < k; i++) {
            System.out.print("Row "+pq.remove().index+" ");
        }
    }



    public static void slidingWindowsMaxApproach1(int [] nums,int k){
        
        PriorityQueue <Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i; j < k+i; j++) {
                pq.add(nums[j]);
            }
            System.out.print(pq.remove()+" ");
            while (pq.size()==0) {
                pq.remove();
            }
        }
        
    }


    static class slidingWindowsMaxInfo implements Comparable<slidingWindowsMaxInfo>{
        int data;
        int index;
        slidingWindowsMaxInfo(int data, int index){
            this.data = data;
            this.index = index;
        }
        @Override
        public int compareTo(slidingWindowsMaxInfo temp){
            return  temp.data-this.data ;
        }
    }

    public static void slidingWindowsMaxApproach2(int [] nums,int k){
        int answer[] = new int[nums.length-k+1];
        PriorityQueue <slidingWindowsMaxInfo> pq = new PriorityQueue<slidingWindowsMaxInfo>();
        for (int i = 0; i < k; i++) {
            pq.add(new slidingWindowsMaxInfo(nums[i],i));
        }
        answer[0] = pq.peek().data;

        for (int i = k; i < nums.length; i++) {
            while (i>=k-1&&pq.peek().index<=(i-k)) {
                pq.remove();
            }
            pq.add(new slidingWindowsMaxInfo(nums[i], i));
            answer[i-k+1] = pq.peek().data;
            
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]+" ");
        }
        System.out.println();
    } 

    public static void main(String[] args) {
        int points[][] = {{3,3},{5,-1},{-2,4}};
        findKClosestPoints(points, 2);
        
        System.out.println();
        int ropes[] = {2,3,3,4,6};
        
        System.out.println(minCostToConnectRopes(ropes));

        int soldier[][] = {{1,1,1,1},{1,0,0,0},{1,0,0,0},{1,0,0,0}};
        weakestSoldier(soldier, 2);

        System.out.println();
        int nums[] = {1,3,-1,-3,5,3,6,7};
        slidingWindowsMaxApproach2(nums, 3);
    }
    
}