/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

// Queue implementation of Java.

import java.util.Scanner;

public class Main {

  public static Graph scan_graph() {
    Scanner input = new Scanner(System.in);
    int num_v = input.nextInt();
    Graph g1 = new Graph(num_v); 


    int num_yal = input.nextInt();
    int yal_h, yal_t;
    for (int i = 0; i<num_yal;i++){
        yal_h = input.nextInt();
        yal_t = input.nextInt();
        
        g1.addEdge(yal_h, yal_t); 
    }
    input.close();

    return g1;

  }

  

  
}