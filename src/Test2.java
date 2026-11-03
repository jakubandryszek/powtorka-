import java.io.FilterOutputStream;

public class Test2 {
    static void main() {
        //System.out.println(findMedianSortedArrays(new int[]{2, 2, 4, 4}, new int[]{2, 2, 2, 4, 4}));
        System.out.println(findMedianSortedArrays(new int[]{100001}, new int[]{100000}));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length<1){
            if(nums2.length%2==0){
                return (double) (nums2[nums2.length/2]+nums2[(nums2.length/2)-1])/2;
            }else{
                return nums2[nums2.length/2];
            }
        }
        if(nums2.length<1){
            if(nums1.length%2==0){
                return (double) (nums1[nums1.length/2]+nums1[(nums1.length/2)-1])/2;
            }else{
                return nums1[nums1.length/2];
            }
        }

        int counter = 0 ;
        int length = nums1.length+nums2.length;
        boolean isEven = length %2==0;
        int center = (length/2)+1;

        int cf = 0;
        int cs = 0;
        int lastChanged = 0;
        int actualChanged = 0;
        boolean end1 =false;
        boolean end2 = false;
        while(counter<center){

            if(nums1[cf]<=nums2[cs]&& !end1){
                lastChanged = actualChanged;
                actualChanged = nums1[cf];
                if(cf==(nums1.length-1)){
                    end1=true;
                }else{
                    cf++;
                }



            }else if (!end2){
                lastChanged = actualChanged;
                actualChanged = nums2[cs];
                if(cs==(nums2.length-1)){
                    end2=true;
                }else{
                    cs++;
                }

            }

            counter++;
        }
        System.out.println(actualChanged);
        System.out.println(lastChanged);
        System.out.println(counter);
        if(counter>=2){
            return isEven? (double)(lastChanged+actualChanged)/2:actualChanged;
        }else if(counter == 1){
            return actualChanged;
        }else{
            return 0;
        }



    }

}
