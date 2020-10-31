package j1sp0011;

import java.util.*;
import java.util.*;
import java.math.*;

/**
 *
 * @author 7H3KNIGHT
 */
public class J1SP0011 {

    private static int binaryCheck() {
        while (true) {
            try {
                int inputData = MyTools.getAnInteger("[+] Enter Binary number: ");
                if ((inputData % 10 == 0 || inputData % 10 == 1) || inputData == 0) {
                    return Integer.parseInt(String.format("%d", inputData), 2);
                }
                System.err.println("[!] Allow 0 and 1 only");
            } catch (Exception e) {
                System.err.println("[!] Error!");
            }
        }
    }

    private static int decimalCheck() {//8 9
        while (true) {
            try {
                int inputData = MyTools.getAnInteger("[+] Enter Binary number:");
                return Integer.parseInt(String.format("%d", inputData), 10);
            } catch (Exception e) {
                System.err.println("[!] You should input Octal!");
            }
        }
    }

    private static int hexaDecimalCheck() {
        while (true) {
            try {
                String inputData = MyTools.getAString("[+] Enter HexaDecimal number:").toUpperCase();
                return Integer.parseInt(inputData, 16);
            } catch (Exception e) {
                System.err.println("[!] You should input HexaDecimal!");
            }
        }
    }

    public static int innerMenu() {
        System.out.println("1. Binary");
        System.out.println("2. Decimal");
        System.out.println("3. Hexadecimal");
        int op = MyTools.getAnInteger("Your choice: ");
        return op;
    }

    public static int input() {
        int op = innerMenu();
        int inputData;
        switch (op) {
            case 1:
                inputData = binaryCheck();
                System.out.println("[+] Added your value: " + Integer.toBinaryString(inputData));
                break;
            case 2:
                inputData = decimalCheck();
                System.out.println("[+] Added your value: " + inputData);
                break;
            case 3:
                inputData = hexaDecimalCheck();
                System.out.println("[+] Added your value: " + Integer.toHexString(inputData).toUpperCase());
                break;
            default:
                System.out.println("[!] Out of range...");
                System.out.println("[!] Returning to main menu.");
                inputData = -1;
                break;
        }
        return inputData;
    }

    private static int output(int inputData) {
        int op = innerMenu();
        switch (op) {
            case 1:
                System.out.println("[+] Your number changed to binary: " + Integer.toBinaryString(inputData));
                break;
            case 2:
                System.out.println("[+] Your number changed to decimal: " + inputData);
                break;
            case 3:
                System.out.println("[+]Your number changed to hexadecimal: " + Integer.toHexString(inputData).toUpperCase());
                break;
            default:
                System.out.println("[!] Out of range...");
                System.out.println("[!] Returning to main menu.");
                break;
        }
        System.err.println("[-] Flushing your cache...");
        return -1;
    }

    public static void main(String[] args) {
        int op = 0;
        boolean check = false;
        int inputData = -1;
        while (!check) {
            System.out.println("=== Change Base Number ===");
            System.out.println("1. Choose input option.");
            System.out.println("2. Choose output option.");
            System.out.println("3. Exit the program.");
            op = MyTools.getAnInteger("Your choice: ");
            System.out.println();
            switch (op) {
                case 1:
                    System.out.println("----- Input Menu -----");
                    inputData = input();
                    break;
                case 2:
                    System.out.println("----- Output Menu -----");
                    if (inputData == -1) {
                        System.err.println("[!] Non-data!");
                    }else
                        inputData = output(inputData);
                    break;
                case 3:
                    check = true;
                    System.err.println("[-] Exiting...");
                    break;
                default:
                    System.err.println("[!] Out of range!");
                    break;
            }
            System.out.println();
        }
    }

}
