class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> ans=new ArrayList<>();
        int n=asteroids.length;
        for(int i=0;i<n;i++){
            if(asteroids[i]>0)
             ans.add(asteroids[i]);
            else{
                while(!ans.isEmpty()&&ans.get(ans.size() - 1)>0&&ans.get(ans.size()-1)<Math.abs(asteroids[i])){
                     ans.remove(ans.size()-1);
                }
                if(!ans.isEmpty()&&ans.get(ans.size()-1)==Math.abs(asteroids[i]))
                  ans.remove(ans.size()-1);
                else if(ans.isEmpty()||ans.get(ans.size()-1)<0)
                 ans.add(asteroids[i]);
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        // Return the final state of asteroids
        return result;
    }
}