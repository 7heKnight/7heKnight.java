package j1sp0011;

import java.util.Scanner;

/**
 *
 * @author 7H3KNIGHT
 */
public class MyTools {

    private static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inputMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if(n>0)
                    return n;
                System.out.println("Must bigger than 0");
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
