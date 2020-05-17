

import java.util.*;


public class Main {

  public static void main(String[] args) {

    Graph g1 = new Graph(5); 
    g1.addEdge(1, 0); 
    g1.addEdge(0, 2); 
    //g1.addEdge(2, 1); 
    g1.addEdge(0, 3); 
    g1.addEdge(3, 4); 
    
    ArrayList<Integer> distance_time = new ArrayList<Integer>();
    distance_time = g1.DFS();
    
    boolean has_cycle;
    has_cycle =g1.has_cycle;
    System.out.println(has_cycle);
    
  }

  
  public static class Graph{
   
      private int V;   // No. of vertices 
      private ArrayList<ArrayList<Integer>> adj; // Adjacency List Represntation 
      private int time;
      private ArrayList<Integer> color;
      private ArrayList<Integer> d;
      private ArrayList<Integer> f;
      private ArrayList<Integer> parent;
      private boolean has_cycle;
    
      // Constructor 
      Graph(int v) { 
          V = v; 
          adj  = new ArrayList<ArrayList<Integer>>(V); 
          for (int i = 0; i < V; i++) 
            adj.add(new ArrayList<Integer>());

          has_cycle = false;
          
      } 
    
      // Function to add an edge into the graph 
      void addEdge(int v,int w) { 
          adj.get(v).add(w); 
          adj.get(w).add(v); 
      } 



      public ArrayList<Integer> DFS(){
        color = new ArrayList<Integer>(V); 
        d= new ArrayList<Integer>(V); 
        f= new ArrayList<Integer>(V); 
        parent= new ArrayList<Integer>(V); 

        for(int i=0; i<V; i++) {
          //white = -1, gray =0, black =1
          color.add(-1);
          parent.add(-1); // -1 stands for NIL
          d.add(0);
          f.add(0);
        }
        time = 0;
        for (int u = 0; u<V; u++){
          if (color.get(u) == -1){
            DFS_visit(u);
          }
        } 
        return d;
      }
      void DFS_visit(int u){
        time++;
        d.set(u, time);
        color.set(u,0);
        for (int v : adj.get(u)){
          
          if (color.get(v) == -1){
            parent.set(v,u);
            DFS_visit(v);
          } else{
            process_cycle(u,v);
          }
          
        }
        color.set(u,1);
        time++;
        f.set(u,time);
      }

      void process_cycle(int x,int y){
        if (parent.get(x) !=y){
          has_cycle = true;
        }
      }

      public ArrayList<Integer> BFS(int s){
        if (s >= V) throw new NoSuchElementException();
        ArrayList<Integer> color = new ArrayList<Integer>(V); 
        ArrayList<Integer> distance= new ArrayList<Integer>(V); 
        ArrayList<Integer> parent= new ArrayList<Integer>(V); 
        MyQueue<Integer> Q = new MyQueue<>();
        int u;

        for(int i=0; i<V; i++) {
          //white = -1, gray =0, black =1
          color.add(-1);
          distance.add(-1);; // -1 stands for infonity
          parent.add(-1);; // -1 stands for NIL
        }

        color.set(s,0);
        distance.set(s,0);
        parent.set(s,-1);

        Q.add(s);
        while (!Q.isEmpty()){
          u = Q.remove();

          for (int v : adj.get(u)){
            if (color.get(v) == -1){
              color.set(v, 0);
              distance.set(v,distance.get(u)+1);
              parent.set(v,u);
              Q.add(v);

            }


          }
          color.set(u,1);

          
        }
              
        return distance;
      }
  
  
  
// This code is contributed by Aakash Hasija

}

  public static class MyQueue<T> {

    private static class QueueNode<T> {
      private T data;
      private QueueNode<T> next;

      public QueueNode(T data) {
        this.data = data;
      }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item) {
      QueueNode<T> t = new QueueNode<T>(item);
      if (last != null) {
        last.next = t;
      }
      last = t;
      if (first == null) {
        first = last;
      }
    }

    public T remove() {
      if (first == null) throw new NoSuchElementException();
      T data = first.data;
      first = first.next;
      if (first == null) {
        last = null;
      }
      return data;
    }

    public T peek() {
      if (first == null) throw new NoSuchElementException();
      return first.data;
    }

    public boolean isEmpty() {
      return first == null;
    }
    public void print_queue(){
        QueueNode pointer_print = first;
        System.out.print(pointer_print.data+ ", ");
    
        while (pointer_print.next != null){
            pointer_print = pointer_print.next;
            System.out.print(pointer_print.data+ ", ");
            
        }
            
        }
  }
  
      
    

}