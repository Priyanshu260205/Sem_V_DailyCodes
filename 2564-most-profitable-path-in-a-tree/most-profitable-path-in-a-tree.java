class Solution {
    List<Integer>[] graph;
    Map<Integer, Integer> map = new HashMap<>();
    int ans = Integer.MIN_VALUE;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        
        //add edges
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        findbob(bob, -1, 0);
        alicedfs(0,-1,0,0,amount);
        return ans;
    }

    public boolean findbob(int bob, int parent, int time){
        if(bob == 0){
            map.put(bob, time);
            return true;
        }

        for(int nbrs : graph[bob]){
            if(nbrs == parent){
                continue;
            }
            if(findbob(nbrs, bob, time+1)){
                map.put(bob, time);
                return true;
            }
        }
        return false;
    }

    public void alicedfs(int node, int parent, int profit, int time, int[] amount){
        if(!map.containsKey(node) || time < map.get(node)){
            profit += amount[node];
        }
        else if(time == map.get(node)){
            profit += amount[node]/2;
        }

        boolean isleaf = true;
        for(int nbrs : graph[node]){
            if(nbrs == parent){
                continue;
            }
            isleaf = false;
            alicedfs(nbrs, node, profit, time+1, amount);
        }

        if(isleaf){
            ans = Math.max(ans, profit);
        }
    }
}