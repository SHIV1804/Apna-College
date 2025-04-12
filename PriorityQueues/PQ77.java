package PriorityQueues;

import java.util.*;


public class PQ77 {
    static PriorityQueue<Integer> creatingPQ(int num){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < num; i++) {
            pq.add((int)Math.floor(Math.random() *1000));
        }
        return pq;
    }
    static<T> void printPQ(PriorityQueue<T> temp){
        while (!temp.isEmpty()) {
            System.out.print(temp.peek()+" ");
            temp.remove();
        }
    }

    static class ItemList implements Comparable<ItemList>{
        int price;
        String itemName;
        ItemList(int price,String itemName){
            this.price = price;
            this.itemName = itemName;
        }
        
        @Override
        public int compareTo(ItemList o) {
            return this.price - o.price;
        }
    }



    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue = creatingPQ(10);
        printPQ(queue);
        System.out.println();
        PriorityQueue<ItemList> priorityQueue = new PriorityQueue<ItemList>(Comparator.reverseOrder());
        for (int i = 0; i < 10; i++) {
            ItemList itemList = new ItemList((int)Math.floor(Math.random() *1000),""+i);
            priorityQueue.add(itemList);

        }
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.peek().itemName+" "+priorityQueue.peek().price);
            priorityQueue.remove();
        }
        
    }
    
}