class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       ArrayList<Integer> al=new ArrayList<>();
       int[] freq1=new int[1001];
       for(int num:nums1){
         freq1[num]++;
       }
       for(int num:nums2){
          if(freq1[num]>0){
            al.add(num);
            freq1[num]--;
          }
       }
       int arr[]=new int[al.size()];
       for(int i=0;i<al.size();i++){
        arr[i]=al.get(i);
       }
       return arr;
    }
}