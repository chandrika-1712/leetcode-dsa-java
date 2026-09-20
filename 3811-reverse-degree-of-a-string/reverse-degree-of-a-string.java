class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int ind=26-(ch-'a');
            int prod=(i+1)*ind;
            sum+=prod;
        }
        return sum;
    }
}