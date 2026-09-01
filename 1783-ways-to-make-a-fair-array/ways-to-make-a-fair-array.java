class Solution {
    public int waysToMakeFair(int[] nums) {
        int evensum=0,oddsum=0,lefteven=0,leftodd=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0)
             evensum+=nums[i];
            else
             oddsum+=nums[i];
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            int righteven=evensum-lefteven;
            int rightodd=oddsum-leftodd;
            if(i%2==0){
                righteven-=nums[i];
            }
            else{
                rightodd-=nums[i];
            }
            int neweven=lefteven+rightodd;
            int newodd=leftodd+righteven;
            if(neweven==newodd)
              count++;
             if(i%2==0){
                lefteven+=nums[i];
            }
            else{
                leftodd+=nums[i];
            }

        }
        return count;
    }
}