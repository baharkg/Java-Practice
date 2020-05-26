
//import java.util.*;

public class Tree{
    Node head;

Tree (Node n){
    head = n;
}

    

    public class Node{
        int data;
        Node right;
        Node left;        
        
        Node(int d){
            data =d;
        }
    }
     
    public void print(String prefix, Node n, boolean isLeft){
        if (n != null) {
            print(prefix + "     ", n.right, false);
            System.out.println (prefix + ("|-- ") + n.data);
            print(prefix + "     ", n.left, true);
        }

    }

    
    
    
}