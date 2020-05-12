// Queue implementation of Java.

import java.util.NoSuchElementException;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello world!");

    MyQueue<Integer> q = new MyQueue<>();
    System.out.println(q.isEmpty());
    q.add(5);
    q.add(3);
    q.add(7);
    //System.out.println(q.peek());
    //System.out.println(q.isEmpty());
    q.print_queue();

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