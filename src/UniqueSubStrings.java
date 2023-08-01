public class UniqueSubStrings {
    static class Node{
        Node[] children;
        boolean eow;
        Node(){
            children=new Node[26];
            for (int i=0;i<26;i++){
                children[i]=null;
            }
            eow=false;
        }

       static Node root=new Node();

        public static void insert(String word){
            Node curr=root;
            for(int i=0;i<word.length();i++){
                int indx=word.charAt(i)-'a';
                if(curr.children[indx]==null)
                {
                    curr.children[indx]=new Node();
                }
                if(i==word.length()-1)
                {
                    curr.children[indx].eow=true;
                }
                curr=curr.children[indx];
            }
        }

        public static int countNodes(Node root) //total no. of nodes(including start "")=unique subStrings
        {
            int count=1;
            for(int i=0;i<26;i++){
                if(root.children[i]!=null)
                {
                    count=count+countNodes(root.children[i]);
                }
            }
            return count;
        }
        public static void main(String[] args){
            String word="ababac";
            for(int i=0;i<word.length();i++){
                insert(word.substring(i));
            }
            System.out.println(countNodes(root));
        }
    }
}
