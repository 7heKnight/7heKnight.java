package j1.l.p0023;

import data.*;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class process {

    private static Scanner sc = new Scanner(System.in);

    //using ID to check fruit if existed
    private static int checkFruit(ArrayList<Fruit> fL, String id) {
        for (int i = 0; i < fL.size(); i++) {
            if (fL.get(i).getId().compareTo(id) == 0) {
                System.out.println("-----Update Fruit-----");
                System.out.println("The fruit is already added!"
                        + "Now you can update new price and new quantity.");
                System.out.println("Fruit ID: " + fL.get(i).getId());
                System.out.println("Fruit ID: " + fL.get(i).getName());
                System.out.println("Fruit ID: " + fL.get(i).getOrigin());
                fL.get(i).setPrice(MyTools.getADouble("Enter Fruit's price: $", "ERROR"));
//                System.out.println("If Quantity = 0 so you will remove this item!");
                fL.get(i).setQuantity(MyTools.getAnInteger("Enter Quanitiy: ", "ERROR!"));
                if (fL.get(i).getQuantity() == 0) {
                    remove(fL, i);
                }
                return 1;
            }
        }
        return -1;
    }

    //remove function
    private static void remove(ArrayList<Fruit> fL, int i) {
        System.out.println("You inputted 0 so program will remove it!");
        fL.remove(i);
    }

    //for ID only
    private static String checkValidID() {
        int a = 6;
        String id = MyTools.getAString("Enter ID(KKxxxx): ", "ERROR!").toUpperCase();
        if (id.length() != a) {
            System.out.println("You must enter 6 character");
            return checkValidID();
        } else {
            if (id.charAt(0) == 'K' && id.charAt(1) == 'K') {
                for (int i = 2; i < id.length(); i++) {
                    if (id.charAt(i) < '0' || id.charAt(i) > '9') {
                        System.out.println("x must be digits");
                        return checkValidID();
                    }
                }
            } else if (id.charAt(0) != 'K' && id.charAt(1) != 'K') {
                System.out.println("KK is ID name of shop! Must input it!");
                return checkValidID();
            }
        }
        return id;
    }

    //option 1: create Fruit
    public static void createFruit(ArrayList<Fruit> fL) {
        String id;
        String name;
        double price;
        int quantity = 0;
        String origin;
        String s2C;
        boolean check = false;
        char op = 0;
        int rtnCheckFruit = 0;
        do {
            System.out.println("-----Create New Fruit-----");
            id = checkValidID();
            rtnCheckFruit = checkFruit(fL, id);
            if (rtnCheckFruit == -1) {//meant ID not risgisted, add new fruit
                name = MyTools.getAString("Enter Fuit's name: ", "ERROR!");
//                price = MyTools.getADouble("Enter Fruit's price: $", "ERROR");
                price = checkNumber("Enter Fruit's price: $");
                quantity = checkNumber("Enter Quantity: ");
//                quantity = MyTools.getAnInteger("Enter Quanitiy: ", "ERROR!");
                origin = MyTools.getAString("Enter Origin: ", "ERROR!").toUpperCase();
                Fruit f = new Fruit(id, name, price, quantity, origin);
                fL.add(f);
            }
            op = checkUsingRecursion("Do you want to add more (Y/N): ");
            while (op != 'Y' || op != 'N') {
                if (op == 'N') {
                    check = true;
                    System.out.println("\nCreated list of fruit.");
                    break;
                } else if (op == 'Y') {
                    break;
                } else if (op != 'Y' || op != 'N') {
                    System.out.println("No option like this!");
                }
                s2C = MyTools.getAString("Do you want to add more (Y/N)", "Error!").toUpperCase();
                op = s2C.charAt(0);
            }
        } while (check != true);
        System.out.println("");
    }

    // option 2 view order list
    public static void viewOrder(Hashtable<String, ArrayList<Order>> hTable) {
        for (String name : hTable.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> oL = hTable.get(name);
            displayListOrder(oL);
        }
        System.out.println("");
    }

    //check user opinion to leave or not
    private static char checkUsingRecursion(String b) {
        char a = MyTools.getAString(b, "ERROR").toUpperCase().charAt(0);
        if (a == 'N') {
            return 'N';
        } else if (a == 'Y') {
            return 'Y';
        } else {
            System.out.println("Only yes or no, no other options!");
        }
        return checkUsingRecursion(b);
    }

    private static int getOption(ArrayList<Fruit> f) {
        int getop;
        getop = MyTools.getAnInteger("Enter Interger: ", "Error") - 1;
        if (getop < 0) {
            System.out.println("Out of range!");
            return getOption(f);
        } else if (getop >= f.size()) {
            System.out.println("out of range");
            return getOption(f);
        }
        if (getop >= 0 && getop < f.size()) {
            if (f.get(getop).getQuantity() == 0) {
                System.out.println("This item is on updating. Please try another option");
                return getOption(f);
            }
        }
        return getop;
    }

    private static void addOderList(List<Fruit> fL, ArrayList<Order> oL) {
        System.out.printf("%-10s%-10s%-10s%-10s\n", "Item", "Fruit Name", "Origin", "Price");
        for (int i = 0; i < fL.size(); i++) {
            if (fL.get(i).getQuantity() > 0) {
                System.out.printf("%-10d%-10s%-10s%-10.2f\n", (i + 1), fL.get(i).getName(), fL.get(i).getOrigin(), fL.get(i).getPrice());
            }
        }

    }

    private static int checkNumber(String str) {
        int a = MyTools.getAnInteger(str, "ERROR");
        if (a < 1) {
            System.out.println("Should enter 1 or more!");
            return checkNumber(str);
        }
        return a;
    }

    private static ArrayList<Order> addOrder(ArrayList<Fruit> fL, ArrayList<Order> oL) {
        int getOp = 0;
        int quantity = 0;
        boolean check = false;
        do {
            System.out.printf("%-10s%-10s%-10s%-10s\n", "Item", "Fruit Name", "Origin", "Price");
            for (int i = 0; i < fL.size(); i++) {
                if (fL.get(i).getQuantity() > 0) {
                    System.out.printf("%-10d%-10s%-10s%-10.2f\n", (i + 1), fL.get(i).getName(), fL.get(i).getOrigin(), fL.get(i).getPrice());
                }
            }
            getOp = getOption(fL);
            check = false;
            System.out.println("You selected: " + fL.get(getOp).getName());
            quantity = MyTools.getAnInteger("Please input quantity: ", "Digit only!");
            while (check != true) {
                //checkquantity
                if (quantity < 1 || quantity > fL.get(getOp).getQuantity()) {
                    System.out.println("The " + fL.get(getOp).getName() + " have  " + fL.get(getOp).getQuantity() + " product in shop");
                    quantity = MyTools.getAnInteger("please re-Enter it: ", "Must be digit!");
                } else {
                    check = true;
                }
            }
            check = false;
            double amount = quantity * fL.get(getOp).getPrice();
            double price = fL.get(getOp).getPrice();
            fL.get(getOp).setQuantity(fL.get(getOp).getQuantity() - quantity);

            //Order: ID, Name, Price, Quantity, Amount
            Order o = new Order(fL.get(getOp).getId(), fL.get(getOp).getName(), price, quantity, amount);
            oL.add(o);
//            }
            check = askUser(oL, fL);
        } while (check != true);
        return oL;
    }

    private static boolean askUser(ArrayList<Order> oL, ArrayList<Fruit> fL) {
        int count = 0;
        boolean check = false;
        char op = 0;
        for (int i = 0; i < fL.size(); i++) {
            if (fL.get(i).getQuantity() == 0) {
                count++;
            }
        }
        if (count == fL.size()) {
            op = 'Y';
        } else {
            op = MyTools.getAString("Do you want to order now? (Y/N)", "Do not leave it blank!").toUpperCase().charAt(0);
        }
        if (op == 'Y') {
            displayListOrder(oL);
            return check = true;
        } else if (op == 'N') {
            oL = addOrder(fL, oL);
        } else {
            return askUser(oL, fL);
        }
        return check = true;

    }

    // option 3 order fruit
    public static void shopping(Hashtable<String, ArrayList<Order>> hTable, ArrayList<Fruit> fL) {
        String name = new String();
        ArrayList<Order> payList = new ArrayList<>();
        int count = 0;
        ArrayList<Order> oL = new ArrayList<Order>();
        System.out.println("---- Ordering option ----");
        for (int i = 0; i < fL.size(); i++) {
            if (fL.get(i).getQuantity() == 0) {
                count++;
            }
        }
        if (fL.size() == 0 || count == fL.size()) {
            System.out.println("Shop on updating!");
        } else {
            payList = addOrder(fL, oL);
            name = MyTools.getAString("Input your name: ", "Must input your name!");
            System.out.println("Ordered the order of fruit.");
            System.out.println("----------------");
            hTable.put(name, payList);
        }
        System.out.println();
    }

    //display oL
    private static void displayListOrder(ArrayList<Order> oL) {
        double total = 0;
        System.out.printf("%-15s%-15s%-15s%-15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order o : oL) {
            System.out.println("----------------");
            System.out.printf("%-15s%-15d$%-15.2f$%-15.2f\n", o.getName(), o.getQuantity(), o.getPrice(), o.getAmout());
            total += o.getPrice() * o.getQuantity();
        }
        System.out.println("Total: $" + total);
    }

}
