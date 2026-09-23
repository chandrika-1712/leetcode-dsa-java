class Solution {
    public String capitalizeTitle(String tit) {
        String title=tit.toLowerCase();
        StringBuilder sb=new StringBuilder();
        String[] arr=title.split(" ");
        for(String s:arr){
           if(!sb.isEmpty()){
             sb.append(" ");
           }
           if(s.length()<=2){
            sb.append(s);
            continue;
           }
           sb.append(Character.toUpperCase(s.charAt(0)));
            sb.append(s.substring(1)); 
        }
        return sb.toString();
    }
}