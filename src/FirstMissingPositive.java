public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0 ||nums[i]>nums.length){
                nums[i]=nums.length+1;
            }
        }
        for(int i=0;i<nums.length;i++){
            int positiveNumber=Math.abs(nums[i]);
            if(positiveNumber>nums.length){
                continue;
            }
            positiveNumber--;
            if(nums[positiveNumber]>0)
                nums[positiveNumber]=-nums[positiveNumber];

        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)return i+1;
        }
        return nums.length+1;
    }
    public static void main(String[] args){
        int k=firstMissingPositive(new int[]{1,2,3,0});
        System.out.println(k);
    }
}
