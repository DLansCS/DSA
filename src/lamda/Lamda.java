package lamda;

import java.util.Scanner;

public class Lamda {

        public void Run(){
            try {
                try (Scanner scan = new Scanner(System.in)) {
                    System.out.println("Enter first number");
                    int a = scan.nextInt();
                    System.out.println("Enter second number");
                    int b = scan.nextInt();
                    
                    System.out.println("First lamda expression using values passed in");
                    printed(a, b, (c, d) -> c + d);
                    
                    System.out.println("Second lamda expression using object passed in");
                    InterfaceTest add = (c, d) -> c+d;
                    printed(a, b, add);
                    
                    System.out.println("Third lamda expression using object passed in");
                    InterfaceTest multiply = (c, d) -> c*d;
                    printed(a, b, multiply);
                }
        }finally{}
    }
    static void printed(int a, int b, InterfaceTest inter){
        System.out.println(inter.doSomething(a, b));
    }
}
