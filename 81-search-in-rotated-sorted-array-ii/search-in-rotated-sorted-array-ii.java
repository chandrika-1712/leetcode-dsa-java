class Solution {
    public boolean search(int[] arr, int key) {
        int l=0;
        int h=arr.length-1;
        while(l<=h){
            int m=(l+h)/2;
            if(arr[m]==key){
                return true;
            }
             if (arr[l] == arr[m] && arr[m] == arr[h]) {
                l++;
                h--;
            }
            else if(arr[l]<=arr[m]){
                if(arr[l]<=key&&key<arr[m]){
                    h=m-1;
                }
                else{
                    l=m+1;
                }
            }
            else{
                if(arr[h]>=key&&key>arr[m]){
                    l=m+1;
                }
                else{
                    h=m-1;
                }
            }
        }
        return false;
    }
}