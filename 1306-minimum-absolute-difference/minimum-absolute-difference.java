class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
          min=Math.min(min,arr[i]-arr[i-1]);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<n;i++){
           if(arr[i]-arr[i-1]==min){
            List<Integer> al=new ArrayList<>();
            al.add(arr[i-1]);
            al.add(arr[i]);
            ans.add(al);
           }
        }
        return ans;

    }
}