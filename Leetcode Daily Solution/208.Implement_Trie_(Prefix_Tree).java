// Solution Link -https://leetcode.com/problems/implement-trie-prefix-tree/

class Trie {
    HashSet<String> hs;
    public Trie() {
        hs=new HashSet<>();
    }
    
    public void insert(String word) {
        hs.add(word);
    }
    
    public boolean search(String word) {
        if(hs.contains(word))
            return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        for(String it:hs){
            if(it.startsWith(prefix))
                return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
