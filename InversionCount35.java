

public class InversionCount35 {

    public static int InversionCount(int nums[],int leftIndex,int rightIndex){
        int count=0;
        if(leftIndex<rightIndex){
        int mid = (leftIndex + rightIndex)/2;
        
        count=InversionCount(nums, leftIndex, mid);
        count+=InversionCount(nums, mid+1,rightIndex);
        
        count+=merge(nums, leftIndex,mid,rightIndex);
        }
        return count;
    }

    public static int merge(int nums[],int leftIndex,int mid,int rightIndex){

       int temp[] = new int[rightIndex-leftIndex+1];
        int i=leftIndex;
        int j=mid+1;
        int k=0;
        int count =0 ;
        while (i<=mid&&j<=rightIndex) {
            if (nums[i]<=nums[j]) {
                temp[k++] = nums[i++];
            }else{
                count += mid-i+1;
                temp[k++] = nums[j++];
            }
        }
        while (i<=mid) {
            temp[k++] = nums[i++];
        }
        while (j<=rightIndex) {
            temp[k++] = nums[j++];
        }
        j=leftIndex;
        for (int l = 0; l < temp.length; l++,j++) {
            nums[j]=temp[l];
        }
        return count;
    }

   public static void main(String[] args) {
    System.out.println(InversionCount(new int[]{2,4,1,3,5}, 0,4 ));

   } 
}
