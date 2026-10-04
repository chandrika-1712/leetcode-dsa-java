class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
         String[] week = {
            "Friday",
            "Saturday",
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday"
        };

        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };
        int days=0;
        for(int i=1971;i<year;i++){
            days+=365;
            if(leap(i))
             days++;
        }
        for(int i=1;i<month;i++){
            days+=daysInMonth[i-1];
            if(i==2&&leap(year)){
                days++;
            }
        }
        days+=day-1;
        return week[days%7];

    }
    boolean leap(int year){
        if(year%400==0||(year%4==0&&year%100!=0)){
            return true;
        }
        return false;
    }
}