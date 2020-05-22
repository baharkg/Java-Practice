public class Main {
    public static void main(String args[]){
        DLL T1 = new DLL();
        DLL T2 = new DLL();
        T1.push(5);
        T1.push(7); 
        T1.push(12);

        T1.print_DLL();

    
        T2.push(3);
        T2.push(4); 
        T2.push(8);

        T2.print_DLL();
        
        T1.attach_dll(T2);

        T1.print_DLL();

        

    }

}