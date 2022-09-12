import java.util.Timer;

public class L208_trie {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        boolean res;
        res = trie.search("apple");
        System.out.println("apple found="+res);
        res = trie.search("app");
        System.out.println("app found="+res);
        res = trie.startsWith("app");
        System.out.println("app startswith found="+res);

    }


}

class TrieNode {

    //data is not needed because array of 26 Trie[], each link represents the
    //
    //char data;
    TrieNode[] links;
    int size = 26;
    boolean isEnd;

    public TrieNode() {
        links = new TrieNode[size];
    }

    public boolean containsKey(char ch) {

        if(links[ch-'a'] != null) {
            return true;
        }
        return false;
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public TrieNode get(char ch){
        return links[ch - 'a'];
    }
    public void setEnd() {
        isEnd = true;
    }

    public boolean getEnd() {
        return isEnd;
    }
}

 class Trie{

     TrieNode root;

     Trie() {
         root = new TrieNode();
     }

     void insert(String word) {
         TrieNode node = root;


         for(int i=0; i<word.length(); i++){
             if(!node.containsKey(word.charAt(i))) {
                 node.put(word.charAt(i), new TrieNode());
             }
             //go to next node;
             node = node.get(word.charAt(i));
         }
         node.setEnd();
     }

     TrieNode searchPrefix(String word) {

         TrieNode node = root;

         for(int i=0; i<word.length(); i++){
             if(!node.containsKey(word.charAt(i))) {
                 return null;
             }
             //go to next node;
             node = node.get(word.charAt(i));
         }
         return node;
     }

     public boolean search(String word) {
         TrieNode node = searchPrefix(word);

         return node != null && node.isEnd;
     }

     public boolean startsWith(String prefix) {

         TrieNode node = searchPrefix(prefix);

         return node != null;
     }
}



