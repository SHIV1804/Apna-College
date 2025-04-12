package Hashing;

import java.util.*;

public class HashSet88 {

    static void intersactionAndUnion(int[] nums1, int[] nums2) {
        System.out.println("Union : ");
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }
        for (Integer integer : set) {
            System.out.print(integer + " ");
        }

        System.out.println("\nIntersation : ");
        set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                System.out.print(nums2[i] + " ");
                set.remove(nums2[i]);
            }
        }
    }

    static class Node {
        int data;
        Node left, right;
        int verticalDistance;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
            this.verticalDistance = 0;
        }
    }

    static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.data + " : " + root.verticalDistance);
        preOrder(root.left);
        preOrder(root.right);
    }

    static LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    static void bottomView(Node root) {
        if (root == null)
            return;

        bottomView(root.left);
        bottomView(root.right);
        if (!map.containsKey(root.verticalDistance)) {
            map.put(root.verticalDistance, root.data);
        }
    }

    static void calculateVerticalDistance(Node root, int verticalDistance) {
        if (root == null)
            return;
        root.verticalDistance = verticalDistance;
        calculateVerticalDistance(root.left, verticalDistance + 1);
        calculateVerticalDistance(root.right, verticalDistance - 1);
    }

    static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revHashMap = new HashMap<>();
        for (String i : tickets.keySet()) {
            revHashMap.put(tickets.get(i), i);
        }
        for (String i : tickets.keySet()) {
            if (!revHashMap.containsKey(i)) {
                return i;
            }
        }
        return null;
    }

    static void itineraryTickets(HashMap<String, String> tickets) {
        String start = getStart(tickets);
        System.out.print(start);
        for (String i : tickets.keySet()) {
            System.out.print(" -> " + tickets.get(i));
            i = tickets.get(i);
        }

    }

    public static int[] twoSumApproach1(int[] nums, int target) {
        HashMap<Integer, Integer> tm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            tm.put(i, nums[i]);
        }
        for (Integer set : tm.keySet()) {
            int remaining = target - tm.get(set);
            tm.put(set, Integer.MAX_VALUE);
            if (tm.containsValue(remaining)) {
                nums[set] = Integer.MAX_VALUE;
                int i = 0;
                for (; i < nums.length; i++) {
                    if (nums[i] == remaining)
                        break;
                }
                return new int[] { set, i };
            }
        }
        return null;
    }

    public static int[] twoSumApproach2(int [] nums , int target){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if(map.containsKey(difference)){
                return new int[]{i,map.get(difference)};
            }
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3 };
        int nums2[] = { 2, 3, 4 };
        intersactionAndUnion(nums1, nums2);

        System.out.println("\n");
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(5);
        root.right = new Node(22);
        root.right.right = new Node(25);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        calculateVerticalDistance(root, 0);
        // preOrder(root);
        bottomView(root);

        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            System.out.print(map.get(integer) + " ");
        }

        System.out.println();
        HashMap<String, String> map = new HashMap<>();
        map.put("mumbai", "delhi");
        map.put("chennai", "japan");
        map.put("usa", "chennai");
        itineraryTickets(map);
        System.out.println();
        int temp[] = twoSumApproach1(new int[] { 3, 2, 4 }, 6);
        for (int i : temp) {
            System.out.print(i+" ");
        }
        System.out.println();
        temp = twoSumApproach2(nums2, 6);
        for (int i : temp) {
            System.out.print(i+" ");
        }
        System.out.println();
       LinkedHashMap<Integer, Integer>  temp2 = new LinkedHashMap<Integer, Integer>();
       temp2.put(1, 2);
       System.out.println(temp2.get(1));
    }
}