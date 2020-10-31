package j1sp0010;

import java.util.*;

/**
 *
 * @author ASUS
 */
public class J1SP0010 {

    static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inputMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
    }

    public static String getAString(String inputMsg){
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println("ERROR!");
            } else {
                return id;
            }
        }
    }
    
    public static void main(String[] args) {
        int numOfArray; boolean check=false;
        int search;char opinion;int[] a = new int[0];
        do{
            ArrayList index = new ArrayList();
            numOfArray = getAnInteger("Enter number of array:\n");
            a = new int[numOfArray];
            search = getAnInteger("Enter search value:\n");
            for (int i = 0; i < numOfArray; i++) {
                a[i] = (int) (Math.random() * (numOfArray + 1));
                if (a[i] == search) {
                    index.add(i);
                }
            }
            System.out.printf("The Array: [");
            for (int i = 0; i < a.length; i++) {
                if (i == a.length - 1) {
                    System.out.printf("%d]\n", a[i]);
                } else {
                    System.out.printf("%d, ", a[i]);
                }
            }
            if (index.isEmpty()) {
                System.out.printf("The value %d is not found.\n", search);
            } else {
                System.out.printf("Found %d at index: ", search);
                for (int i = 0; i < index.size(); i++) {
                    System.out.printf("%d ", index.get(i));
                }
                System.out.println();
            }
            String inp=getAString("Do you want to add more(Y/N): ").toUpperCase();
            opinion=inp.charAt(0);
            do {                
                if(opinion=='Y');
                else if(opinion=='N') {
                    System.out.println("Bái bai :)");
                    check = true;
                }
                else if(!(opinion=='Y'||opinion=='N')){
                    inp=getAString("Just (Y/N). Re-enter your choice: ").toUpperCase();
                    opinion=inp.charAt(0);
                }
            }while (opinion!='Y' && opinion!='N');
            
        }while (check!=true);
    }
}
