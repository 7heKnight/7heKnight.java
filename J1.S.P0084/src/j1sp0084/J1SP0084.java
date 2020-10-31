package j1sp0084;

import java.math.BigInteger;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class J1SP0084 {

    private static Scanner sc = new Scanner(System.in);

    public static String input() {
        String a;
        while (true) {
            a = sc.nextLine().trim();
            if (a.length() == 0 || a.isEmpty() || !check(a)) {
                System.out.println("Integer only, no float, no double, no characters");
            } else {
                return a;
            }
        }
    }

    public static boolean check(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (!(a.charAt(i) >= '0' && a.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean check = false;
        char opinion = 0;
        while (check != true) {
            System.out.println("Multiple 2 big integer.");
            System.out.println("Enter 1st number: ");
            String a = input();
            System.out.println("Enter 2nd number: ");
            String b = input();
            BigInteger aA = new BigInteger(a);
            BigInteger bB = new BigInteger(b);
            System.out.println("Result: " + aA.multiply(bB));
            while (opinion != 'Y' && opinion != 'N') {
                System.out.println("Do you want to add more? (Y/N)");
                String op = sc.nextLine().trim();
                opinion = op.toUpperCase().charAt(0);
                if (a.length() == 0 || a.isEmpty()) {
                    System.out.println("ERROR!");
                } else {
                    if (opinion == 'Y'); else if (opinion == 'N') {
                        check = true;
                    }
                }
            }
            opinion = 0;
        }
    }
}
