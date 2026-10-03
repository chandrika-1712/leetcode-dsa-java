class Transaction{
    String name;
    int time;
    int amount;
    String city;
    Transaction(String str){
        String[] s=str.split(",");
        name=s[0];
        time=Integer.parseInt(s[1]);
        amount=Integer.parseInt(s[2]);
        city=s[3];
    }
}
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n=transactions.length;
        ArrayList<Transaction> al=new ArrayList<>();
        List<String> ans=new ArrayList<>();
        for(String s:transactions){
            al.add(new Transaction(s));
        }
        for(int i=0;i<n;i++){
            Transaction t1=al.get(i);
            boolean invalid=false;
            if(t1.amount>1000){
               invalid=true;
            }
            if(!invalid){
                for(int j=0;j<n;j++){
                    if(i==j)
                     continue;
                    Transaction t2=al.get(j);
                    if(Math.abs(t1.time-t2.time)<=60&&t1.name.equals(t2.name)&&!t1.city.equals(t2.city)){
                         invalid=true;
                         break;
                    }
                }
            }
            if(invalid){
                ans.add(transactions[i]);
            }
        }
        return ans;
    }
}