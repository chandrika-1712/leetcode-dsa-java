class Pair{
    int row;
    int col;
    int tm;
    Pair(int row,int col,int tm){
        this.row=row;
        this.col=col;
        this.tm=tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int time=0;
        Queue<Pair> q=new LinkedList<>();
        int[][] visited=new int[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                else{
                    visited[i][j]=0;
                }
                if(grid[i][j]==1)
                 count++;
            }
        }

         int[] delrow={-1,0,1,0};
         int[] delcol={0,1,0,-1};
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int row=curr.row;
            int col=curr.col;
            int tm=curr.tm;
            time=Math.max(time,tm);
            for(int i=0;i<4;i++){
               int dr=row+delrow[i];
               int dc=col+delcol[i];
               if(dr>=0&&dr<m&&dc>=0&&dc<n&&visited[dr][dc]!=2&&grid[dr][dc]==1){
                   q.add(new Pair(dr,dc,tm+1));
                   visited[dr][dc]=2;
                   count--;
               } 
            }
        }
        if(count!=0)
         return -1;
        return time;
    }
}