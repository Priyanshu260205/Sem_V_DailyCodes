class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> map = new ArrayList<>();
        for(int i=0; i<n; i++){
            map.add(new ArrayList<>());
        }
        int[] outdegree = new int[n];
        for(int i=0; i<n; i++){
            outdegree[i] = graph[i].length;
            for(int v : graph[i]){
                map.get(v).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(outdegree[i] == 0){
                q.offer(i);
            }
        }
        boolean[] safe = new boolean[n];

        while(!q.isEmpty()){
            int rv = q.poll();
            safe[rv] = true;

            for(int p : map.get(rv)){
                outdegree[p]--;
                if(outdegree[p] == 0){
                    q.offer(p);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(safe[i]) res.add(i);
        }
        return res;
    }
}