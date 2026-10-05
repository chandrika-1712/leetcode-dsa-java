class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strst=new Stack<>();
        Stack<Integer> numst=new Stack<>();
        StringBuilder currstr=new StringBuilder();
        int currnum=0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                currnum=currnum*10+(ch-'0');
            }
            else if(ch=='['){
                numst.push(currnum);
                strst.push(currstr);
                currnum=0;
                currstr=new StringBuilder();
            }
            else if(Character.isLetter(ch)){
                currstr.append(ch);
            }
            else{
                int k=numst.pop();
                StringBuilder prev=strst.pop();
                for(int j=0;j<k;j++){
                   prev.append(currstr);
                }
                currstr=prev;
            }
        }
        return currstr.toString();
    }
}