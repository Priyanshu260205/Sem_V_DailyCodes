class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String rv = q.poll();
                if(rv.equals(endWord)) return level;

                char[] arr = rv.toCharArray();
                for(int j=0; j<arr.length; j++){
                    char o = arr[j];
                    for(char k = 'a'; k<='z'; k++){
                        if(k == o) continue;

                        arr[j] = k;
                        String e = new String(arr);
                        if(set.contains(e)){
                            q.offer(e);
                            set.remove(e);
                        }
                    }
                    arr[j] = o;
                }
            }
            level++;
        }
        return 0;
    }
}