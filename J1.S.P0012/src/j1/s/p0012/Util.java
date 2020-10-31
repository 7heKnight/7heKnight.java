package j1.s.p0012;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Util {
    private static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inputMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println("Must be integer!");
            }
        }
    }
    public static String getAString(String inputMsg) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println("ERROR");
            } else {
                return id;
            }
        }
    }
    
}
