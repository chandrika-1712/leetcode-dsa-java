class Pair{
     int row,col,step;
     Pair(int row,int col,int step){
        this.row=row;
        this.col=col;
        this.step=step;
     }
}class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] vis=new int[n][m];
        int[][] ans=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }else{
                    vis[i][j]=0;
                }
            }
        }
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        while(!q.isEmpty()){
           Pair curr=q.poll();
           int row=curr.row;
           int col=curr.col;
           int step=curr.step;
           ans[row][col]=step;
           for(int i=0;i<4;i++){
               int dr=row+delrow[i];
               int dc=col+delcol[i];
               if(dr>=0&&dr<n&&dc>=0&&dc<m&&vis[dr][dc]==0){
                 vis[dr][dc]=1;
                 q.add(new Pair(dr,dc,step+1));
               }
            }
        }
        return ans;
    }
}