class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie t = new Trie();
        for(String s : dictionary){
            t.insert(s);
        }
        String arr[] = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String get = t.Search(arr[i]);
            sb.append(get + " ");
        }
        return sb.toString().trim();
    }

    static class Trie{
        class Node{
            char ch;
            String isTerminal;
            HashMap<Character, Node> child;

            public Node(char ch){
                this.ch = ch;
                child = new HashMap<>();
            }
        }
        private Node root = new Node('*');

        public void insert(String word){
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(curr.child.containsKey(ch)){
                    curr = curr.child.get(ch);
                }
                else{
                    Node nn = new Node(ch);
                    curr.child.put(ch, nn);
                    curr = nn;
                }
            }
            curr.isTerminal = word;
        }
        public String  Search(String word){
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(curr.child.containsKey(ch)){
                    curr = curr.child.get(ch);
                    if(curr.isTerminal != null){
                        return curr.isTerminal;
                    }
                }
                else{
                    return word;
                }
            }
            return word;
        }
    }
}