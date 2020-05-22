
//import java.util.*;

public class DLL{
    Node head;
    

    public  class Node{
        int data;
        Node next;
        Node prev;        
        
        Node(int d){
            data =d;
        }
    }
    public void push(int new_data) 
    { 
    /* 1. allocate node  
    * 2. put in the data */
    Node new_Node = new Node(new_data); 
  
    // Add a node to the endd of a linked list
    new_Node.next = head; 
    new_Node.prev = null; 
  
    /* 4. change prev of head node to new node */
    if (head != null) 
        head.prev = new_Node; 
  
    /* 5. move the head to point to the new node */
    head = new_Node; 
    } 
    public void print_DLL(){
        
        Node print_pointer = head;


        while (print_pointer != null){
            System.out.print(print_pointer.data+" ");
            print_pointer = print_pointer.next;
            
        }
        System.out.print("\n");
    }

    public void attach_dll(DLL T2){

        Node pointer_attach = head;
        while (pointer_attach.next !=null){
            pointer_attach = pointer_attach.next;
        }
        pointer_attach.next = T2.head;
        T2.head.prev = pointer_attach;

    }
    
    
}