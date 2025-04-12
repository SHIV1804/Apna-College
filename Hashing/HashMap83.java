package Hashing;
import java.util.*;




public class HashMap83 {

    public static class HashMap <K,V>{
        class Node{
            K key;
            V value;
            Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        int n=0,N=0;
        LinkedList<Node> bucket[];
        @SuppressWarnings("unchecked")
        HashMap(){
            this.N=4;
            this.bucket=new LinkedList[N];
            for (int i = 0; i < bucket.length; i++) {
                this.bucket[i]=new LinkedList<>();
            }
        }
        
        private int searchInLL(K key, int bi) {
            LinkedList<Node> temp = bucket[bi];
            int ni = 0;
            for (int i = 0; i < temp.size(); i++) {
                Node node = temp.get(i);
                if(key == node.key){
                    return ni;
                }
                ni++;
            }
            return -1;
        }

        private int hashFunction(K key) {
            int hashCode = key.hashCode();
            return Math.abs(hashCode)%N;
        }
        private void rehash(){
            LinkedList<Node> oldBucket[] = bucket;
            N= N*2;
            bucket = new LinkedList[N];
            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new LinkedList<>();
            }
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> temp = oldBucket[i];
                for (int j = 0; j < temp.size(); j++) {
                    put(temp.get(j).key, temp.get(j).value);
                }
            }
        }
        
        void put(K key, V value){
            int bi = hashFunction(key);
            int ni = searchInLL(key,bi);
            if(ni!=-1){
                bucket[bi].get(ni).value = value;
                // bucket[bi].set(ni,new Node(key, value));

            }else{
                n++;
                bucket[bi].add(new Node(key, value));
            }
            double lambda = (double)n/N;
            if (lambda>2.0) {
                rehash();
            } 
        }


        boolean containsKey(K key) {
            int bi = hashFunction(key);
            int ni = searchInLL(key, bi);
            if(ni != -1) {
                return true;
            }else{
                return false;
            }
        }
        V get(K key){
            int bi = hashFunction(key);
            int ni = searchInLL(key, bi);
            if(ni != -1) {
                return bucket[bi].get(ni).value;
            }else{
                return null;
            }
        }

        V remove(K key){
            int bi = hashFunction(key);
            int ni = searchInLL(key, bi);
            if(ni != -1) {
                V val = bucket[bi].get(ni).value;
                bucket[bi].remove(ni);
                n--;
                return val;
            }else{
                return null;
            }
        }

        ArrayList<K> getKeySet(){
        ArrayList<K> temp = new ArrayList<>();
        for (int i = 0; i < bucket.length; i++) {
            LinkedList<Node> tempLL = bucket[i];
            for (int j = 0; j < tempLL.size(); j++) {
                temp.add(tempLL.get(j).key);
            }
        }
        return temp;
        }

        
        boolean isEmpty(){
            return n==0;
        }


    }



    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        String country[] = {"India","Jamaica","Kiril"};
        hm.put(country[0],1000);
        hm.put(country[1],10000);
        hm.put(country[2],100);
        ArrayList <String> temp = hm.getKeySet();
        System.out.println(temp);
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.get("India"));
        int i=0;
        while (!hm.isEmpty()) {
            System.out.println(country[i]+" : "+hm.remove(country[i++]));
        }

        
        
        
    }
    
}