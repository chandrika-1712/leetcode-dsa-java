class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        int n=num.length();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&k>0&&st.peek()>num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        if(st.isEmpty())
         return "0";
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        while(sb.length()>0&&sb.charAt(sb.length()-1)=='0')
         sb.deleteCharAt(sb.length()-1);
        sb.reverse();
        if(sb.length()==0)
         return "0";
        return sb.toString();
    }
}