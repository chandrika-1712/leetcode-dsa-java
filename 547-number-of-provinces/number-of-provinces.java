class Solution {
     boolean[] visited;
    int[][] isConnected;
    int n;
    public int findCircleNum(int[][] isConnected) {
        this.isConnected = isConnected;
        n = isConnected.length;
        visited = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        return count;
    }
    void dfs(int i){
        visited[i]=true;
        for(int j=0;j<n;j++){
            if(isConnected[i][j]==1&&!visited[j]){
                dfs(j);
            }
        }
    }
}