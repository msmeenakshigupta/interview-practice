/**
 * created by megupta on 03/05/20
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;

        merge(nums1, m, nums2, n);
        for(int i=0; i<nums1.length; i++){
            System.out.println(nums1[i]);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1; int j=n-1;
        int index=m+n-1;
        while( i>=0 && j>=0){
            if(nums1[i]<nums2[j]){
                nums1[index] = nums2[j];
                j--;
                index--;
            }else{
                nums1[index] = nums1[i];
                i--;
                index--;
            }
        }
        while(i>=0){
            nums1[index] = nums1[i];
            i--;
            index--;
        }
        while(j>=0){
            nums1[index] = nums2[j];
            j--;
            index--;
        }

    }
}
