class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original=image[sr][sc];
        if(original==color)
         return image;
        dfs(image,original,color,sr,sc);
        return image;
    }
    void dfs(int[][] image,int original,int color,int sr,int sc){
        if(sr<0||sr>=image.length||sc<0||sc>=image[0].length||
          image[sr][sc]!=original)
           return;
        image[sr][sc]=color;
        dfs(image,original,color,sr-1,sc);
        dfs(image,original,color,sr,sc+1);
        dfs(image,original,color,sr+1,sc);
        dfs(image,original,color,sr,sc-1);
    }
}