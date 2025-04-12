package Greedy;

import java.util.*;


public class Greedy64 {
    static void activitySelectionWithOutSort(int[] start, int[] end) {
        int[][] temp = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            temp[i][0] = i;
            temp[i][1] = start[i];
            temp[i][2] = end[i];
        }
        Arrays.sort(temp, Comparator.comparingDouble(o -> o[2]));

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        tempList.add(temp[0][0]);
        int lastEnd = temp[0][2];
        for (int i = 1; i < start.length; i++) {
            if (temp[i][1] >= lastEnd) {
                lastEnd = temp[i][2];
                tempList.add(temp[i][0]);
            }
        }
        for (int i = 0; i < tempList.size(); i++) {
            System.out.print("A" + tempList.get(i) + " ");
        }
    }

    static void activitySelection(int[] start, int[] end) {
        int lastEnd = end[0];
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(0);
        int count = 1;
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                count++;
                lastEnd = end[i];
                temp.add(i);
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            System.out.print("A" + temp.get(i) + " ");
        }
    }

    static void fractionalKnapsack(int[] value, int[] weight, int capacity) {
        double[][] ratio = new double[value.length][2];
        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double) value[i] / (double) weight[i];
        }
        double maxProfit = 0;
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        for (int i = value.length - 1; i > -1; i--) {
            int index = (int) ratio[i][0];
            if (capacity >= weight[index]) {
                capacity = capacity - weight[index];
                maxProfit += value[index];
            } else {
                maxProfit = maxProfit + capacity * ratio[i][1];
                capacity = 0;
                break;
            }
        }
        System.out.println("MaxProfit : " + maxProfit);
    }

    public static void minimumAbsoluteDifferenceSum(int[] nums1, int[] nums2) {
        int minDifference = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
            minDifference += Math.abs(nums1[i] - nums2[i]);
        }
        System.out.println("Minimum absolute difference is : " + minDifference);
    }

    static void maxLengthOfChainPairs(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int length = 0;
        length++;
        int lastEnd = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] >= lastEnd) {
                lastEnd = pairs[i][1];
                length++;
            }
        }
        System.out.println("Max length: " + length);
    }

    static void indianCoins(int[] coins, int money) {
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (coins[i] <= money) {
                money = money - coins[i];
                count++;
            }
        }
        System.out.println("Minimum coins : " + count);
    }

    class jobs {

        int id;
        int deadline;
        int profit;

        public jobs(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

    }

    void jonSequence(int[][] nums) {

        ArrayList<jobs> jobsInfo = new ArrayList<jobs>();
        for (int i = 0; i < nums.length; i++) {
            jobsInfo.add(new jobs(i, nums[i][0], nums[i][1]));
        }

        Collections.sort(jobsInfo,(a, b) -> b.profit - a.profit);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int time = 0;
        for (int i = 0; i < jobsInfo.size(); i++) {
            if (jobsInfo.get(i).deadline > time) {
                time++;
                temp.add(jobsInfo.get(i).id);
            }
        }

        // printing
        for (int i = 0; i < temp.size(); i++) {
            System.out.print(temp.get(i)+" ");
        }
    }

    public static void main(String[] args) {
        int[] start = { 0, 1, 3, 5, 5, 8 };
        int[] end = { 6, 2, 4, 7, 9, 9 };

        // activitySelectionWithOutSort(start, end);

        int[] value = { 60, 100, 120 };
        int[] weight = { 10, 20, 30 };
        int capacity = 50;
        // fractionalKnapsack(value, weight, capacity);

        // minimumAbsoluteDifferenceSum(new int[]{4,1,8,7},new int[]{2,3,6,5} );

        // maxLengthOfChainPairs(new int[][]{{5,24},{39,60},{5,28},{27,40},{50,90}});

        // indianCoins(new int[] { 1, 2, 5, 10, 50, 100, 500, 2000 }, 1000);

        // int [][] jobs = {{2,100},{1,19},{2,27},{1,25},{3,15}};

        // Greedy64 greedy64 = new Greedy64();
        // greedy64.jonSequence(jobs);

        
    }

   
}