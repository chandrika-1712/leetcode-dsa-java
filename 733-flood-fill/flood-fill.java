class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int original=image[sr][sc];
        if(original==color)
         return image;
        Queue<Pair> q=new LinkedList<>();
        image[sr][sc]=color;
        q.add(new Pair(sr,sc));
          int[] delrow={-1,0,1,0};
         int[] delcol={0,1,0,-1};
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int row=curr.row;
            int col=curr.col;
            for(int i=0;i<4;i++){
               int dr=row+delrow[i];
               int dc=col+delcol[i];
               if(dr>=0&&dr<m&&dc>=0&&dc<n&&image[dr][dc]==original){
                   q.add(new Pair(dr,dc));
                   image[dr][dc]=color;
               } 
            }
        }
        return image;
    }
}