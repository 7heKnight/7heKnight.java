package j1.l.p0023;

import java.util.*;
import data.*;

/**
 *
 * @author ASUS
 */
public class J1LP0023 {

    public static void main(String[] args) {
        int op = 0;
        ArrayList<Fruit> fL = new ArrayList<Fruit>();
        ArrayList<Order> oL = new ArrayList<Order>();
        Hashtable<String, ArrayList<Order>> hTable = new Hashtable<>();
        while (op != 4) {
            System.out.println("==== WELCOME TO FRUIT SHOP SYSTEM ====");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            op = MyTools.getAnInteger("(Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program).\n", "ERROR!");
            switch (op) {
                case 1:
                    process.createFruit(fL);
                    break;
                case 2:
                    System.out.println("------ Order List ------");
                    for(String name : hTable.keySet()){
                        oL = hTable.get(name);
                    }
                    if (oL.size() < 1) {
                        System.out.println("No order List yet");
                    } else {
                        process.viewOrder(hTable);
                    }
                    System.out.println();
                    break;
                case 3:
                    process.shopping(hTable,fL);
                    break; 
                case 4:
                    System.out.println("See you again!");
                    break;
                default:
                    System.out.println("There is no option like this");
                    break;
            }
        }
    }
}
