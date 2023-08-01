public class LongestString //with all prefixes im array (so all nodes in that string eow=true)
{
    static class Node{
        Node[] children;
        boolean eow;
        Node(){
            eow=false;
            children=new Node[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
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

        static String ans="";


        public static void longestWord(Node root,StringBuilder temp){
            if(root==null){
                return;
            }
            for (int i=0;i<26;i++)
            {
                if(root.children[i]!=null && root.children[i].eow)
                {
                    temp.append((char)(i+'a'));
                    if(temp.length()>ans.length()){
                        ans=temp.toString();
                    }
                    longestWord(root.children[i],temp);
                    temp.deleteCharAt(temp.length()-1);
                }
            }
        }
        public static void main(String[] args){
            String[] words ={"a","ab","abc","p","pb","pbd","pbdg","pbdw","pbdww"};
            for(String val:words){
                insert(val);
            }
            longestWord(root,new StringBuilder());
            System.out.println(ans);
        }
    }
}
