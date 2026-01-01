class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // stores word at end node
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        Set<String> result = new HashSet<>();

        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int r, int c,
                     TrieNode node, Set<String> result) {

        char ch = board[r][c];
        if (ch == '#' || node.children[ch - 'a'] == null) return;

        node = node.children[ch - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoid duplicates
        }

        board[r][c] = '#'; // mark visited

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < board.length &&
                nc >= 0 && nc < board[0].length) {
                dfs(board, nr, nc, node, result);
            }
        }

        board[r][c] = ch; // backtrack
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null)
                    curr.children[idx] = new TrieNode();
                curr = curr.children[idx];
            }
            curr.word = w;
        }
        return root;
    }
}