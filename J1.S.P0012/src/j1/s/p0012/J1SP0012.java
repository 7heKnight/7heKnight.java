package j1.s.p0012;

import java.util.*;

/**
 *
 * @author ASUS
 */
public class J1SP0012 {

    public static void main(String[] args) {
        int op = 0;
        boolean check = false;
        HashMap<String, Data> hM = new HashMap<String, Data>();

        while (check != true) {
            System.out.println("===== MEMORY CACHED =====");
            System.out.println("1. Create a data with a key");
            System.out.println("2. Search data from the key");
            System.out.println("3. Remove the data and key (if found)");
            System.out.println("4. Remove all data and key");
            System.out.println("5. Exit program");
            op = Util.getAnInteger("Enter your option: ");
            System.out.println("--------------------\n");
            switch (op) {
                case 1:
                    process.hashMap(hM);
                    break;
                case 2:
                    process.searchData(hM);
                    break;
                case 3:
                    process.removeAD(hM);
                    break;
                case 4:
                    System.out.println("--- Remove all key and data ---");
                    hM.clear();
                    System.out.println("All of your key and data has been removed!");
                    break;
                case 5:
                    check = true;
                    System.out.println("Bái bai");
                    break;
                default:
                    System.out.println("Out of range!");
                    break;
            }
        }
    }

}
