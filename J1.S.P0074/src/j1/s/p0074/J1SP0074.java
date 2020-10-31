/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

/**
 *
 * @author ASUS
 */
public class J1SP0074 {

    public static void main(String[] args) {

        int op = 0;
        boolean check = false;

        while (check != true) {
            System.out.println("======Calculator program======");
            System.out.println("1: Addition matrixes");
            System.out.println("2: Subtraction matrixes");
            System.out.println("3: Multiplication matrixes");
            System.out.println("4: Exit program.");
            op = MyTools.getAnInteger("Your choice: ", "Wrong format!");

            switch (op) {
                case 1:
                    Calculator.display(op);
                    break;
                case 2:
                    Calculator.display(op);
                    break;
                case 3:
                    Calculator.display(op);
                    break;
                case 4:
                    System.out.println("Bye bye!");
                    check = true;
                    break;
                default:
                    System.out.println("Wrong options!");
                    break;
            }
        }

    }

}
