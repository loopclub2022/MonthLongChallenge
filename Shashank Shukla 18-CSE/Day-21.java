/*
using BFS
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int res=0;
        Queue<Integer> q= new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(amount);
        q.offer(amount);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int cur = q.poll();
                if(cur == 0) return res;
                if(cur < 0) continue;
                for(int c: coins){
                    int n = cur-c;
                    if(n>=0 && !visited.contains(n)){
                        q.offer(n);
                        visited.add(n);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
