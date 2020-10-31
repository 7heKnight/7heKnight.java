package j1.s.p0081;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        int op = 0;
        boolean check = false;
        Scanner sc = new Scanner(System.in);

        while (check != true) {
            System.out.println("----BEE----");
            System.out.println("1. Create new bee list.");
            System.out.println("2. Damage bee.");
            System.out.println("3. Quit.");
            op = MyTools.getAnInteger("Choose an option: ", "Wrong format!");

            switch (op) {
                case 1:
                    process.createBee();
                    break;
                case 2:
                    if(process.checkList()==false)
                        process.Damage();
                    else System.out.println("All bees are dead, create new bee's list please!");
                    break;
                case 3:
                    System.out.println("Quitting !");
                    check = true;
                    break;
                default:
                    System.out.println("There is no option like that!");
                    break;
            }

        }
    }

}
