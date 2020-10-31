package j1sp0063;

import java.util.*;

/**
 *
 * @author ASUS
 */
public class J1SP0063 {

    //my filters
    private static String digitFilter(String msg) {
        String input = Util.getAString(msg);
        for (int i = 0; i < input.length(); i++) {
            if (!((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') || input.charAt(i) == ' ')) {
                System.out.println("Not allow digit or special character");
                return digitFilter(msg);
            }
        }
        return input;
    }

    private static double charCheck(String msg) {
        double input = Util.getADouble(msg);
        if (input <= 0) {
            System.out.println("Must bigger than zero");
            return charCheck(msg);
        }
        return input;
    }

    //add person
    private static Person input() {
        String name = digitFilter("Enter Name: ");
        String address = digitFilter("Enter address: ");
        double salary = charCheck("Enter salary: ");
        Person p = new Person(name, address, salary);
        return p;
    }

    //bouble sort
    private static void bbsrt(List<Person> p) {
        for (int i = 0; i < p.size(); i++) {
            for (int j = i + 1; j < p.size(); j++) {
                if (p.get(i).getSalary() > p.get(i).getSalary()) {
                    Person b = p.get(i);
                    p.set(i, p.get(j));
                    p.set(j, b);
                }
            }
        }
    }

    //display list
    private static void display(List<Person> p) {
        bbsrt(p);
        for (int i = 0; i < p.size(); i++) {
            System.out.println("\n\nInformation of Person you have entered:");
            System.out.println(p.get(i));
            System.out.printf("Salary: %1.1f", p.get(i).getSalary());
        }
        System.out.println();
    }

    public static void main(String[] args) {////////////////////////MAIN
        boolean check = false;
        List<Person> p = new ArrayList<>();
        System.out.println("=====Management Person programer=====");
        while (check != true) {
            p.add(input());
            check = usrOpinion(p);
        }
    }

    // (yes/no) question
    private static boolean usrOpinion(List<Person> p) {
        char op = Util.getAString("Do you want to add more? (Y/N)").toUpperCase().charAt(0);
        if (op == 'N') {
            display(p);
            return true;
        } else if (op == 'Y') {
            return false;
        } else {
            System.out.println("Wrong option!");
            return usrOpinion(p);
        }
    }
}
