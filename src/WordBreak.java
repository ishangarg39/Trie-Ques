public class WordBreak {
    static class Node{
        Node[] children; //26 characters
        boolean eow; //end of word
        public Node(){
            children=new Node[26]; //a to z
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            eow=false;
        }
    }

    static Node root=new Node();
    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int indx=word.charAt(i)-'a'; // character-'a' gives index on array of children
            if(curr.children[indx]==null){
                curr.children[indx]=new Node();
            }
            if(i==word.length()-1) //End of word
            {
                curr.children[indx].eow=true;
            }
            curr=curr.children[indx];
        }
    }

    public static boolean wordExists(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int indx=key.charAt(i)-'a';
            if(curr.children[indx]==null) //when next alphabet not in trie
            {
                return false;
            }

            if(curr.children[indx].eow==true){
                if(i==key.length()-1){
                    return true;
                }
                else{
                    boolean word= wordExists(key.substring(i+1));
                    if(word) //whole word exist then return otherwise continue
                    {
                        return true;
                    }
                }
            }
            curr=curr.children[indx];

        }
        return false;
    }
    public static void main(String[] args){
        String words[]={"i","like","samsung","sam","mob","mobile"};
        for(String val: words){
            insert(val);
        }
        System.out.println(wordExists("ilikesamsungmobile")); //here samsung and sam are presesnt so,exception
        System.out.println(wordExists("ilikesamsungds"));

    }
}
