class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
        int astart=getDay(arriveAlice,days);
        int aend=getDay(leaveAlice,days);
        int bstart=getDay(arriveBob,days);
        int bend=getDay(leaveBob,days);
        int start=Math.max(astart,bstart);
        int end=Math.min(aend,bend);
        return Math.max(0,end-start+1);
    }
    private int getDay(String date,int[] days){
        int month=Integer.parseInt(date.substring(0,2));
        int day=Integer.parseInt(date.substring(3,5));
        for(int i=0;i<month-1;i++){
            day+=days[i];
        }
        return day;
    }
}