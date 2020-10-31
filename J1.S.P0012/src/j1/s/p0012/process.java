package j1.s.p0012;

import java.time.*;
import java.util.*;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class process {

    //static time functions
    private static long getATime() {
        long a = System.currentTimeMillis();
        return a;
    }

    private static long deadSec() {
        long a = Util.getAnInteger("Enter time to dead(sec): ");
        if (a < 0) {
            System.out.println("You can't get back and recovery your data!");
            return deadSec();
        } else if (a == 0) {
            System.out.println("Sorry! I haven't set option for 0 yet, try input again!");
            return deadSec();
        }
        return a;
    }

    //static check functions
    private static boolean checkIfDead(long start, long time) {
        if ((System.currentTimeMillis() - start) > (time * 1000)) {
            return true;
        }
        return false;
    }

    private static boolean checkKey(HashMap<String, Data> hM, String key) {////////////check key sai
        if (hM.size() == 0) {
            return false;
        }
        for (String hashKey : hM.keySet()) {
            if (hashKey.compareTo(key) == 0) {
                return true;
            }
        }
        return false;
    }

    private static void checkListNRst(HashMap<String, Data> hM) {
        for (String key : hM.keySet()) {
            if ((System.currentTimeMillis()-hM.get(key).getStart()) > (hM.get(key).getTimeToLive() *1000)) {
                hM.remove(key);
            }
        }
    }

    //option 1; create new data
    public static void hashMap(HashMap<String, Data> hM) {
        String key = null;
        boolean check = false;
        System.out.println("--- Create a cached option ---");
        while (check != true) {
            key = Util.getAString("Enter the key: ");
            if (checkKey(hM, key) == true) {
                System.out.println(key + " found, please enter other.");
            } else {
                check = true;
            }
        }
        Data d = inputData();
        hM.put(key, d);
        System.out.println(d);
        System.out.println("--------------------\n");
    }

    private static Data inputData() {
        String data = Util.getAString("Enter your data: ");
        long timeToDead = deadSec();
        long start = getATime();
        Data d = new Data(data, timeToDead, start);
        return d;
    }

    //option 2: search data
    public static void searchData(HashMap<String, Data> hM) {
        System.out.println("--- Search data ---");
        for (String k : hM.keySet()) {
            System.out.println("Current Value: " + System.currentTimeMillis());
            System.out.println("Start Value: " + hM.get(k).getStart());
            System.out.println("time to live Value: " + hM.get(k).getTimeToLive());
            System.out.println(String.format("%d - %d  = %d > %d", System.currentTimeMillis(),hM.get(k).getStart(),System.currentTimeMillis()-hM.get(k).getStart(),hM.get(k).getTimeToLive()*1000));
        }

        if (hM.isEmpty()) {
            System.out.println("Empty List!");
            return;
        }
        checkListNRst(hM);

        String key = Util.getAString("Enter key to search: ");
        if (checkKey(hM, key) == true) {
            System.out.println("[+] Key founded!");
            System.out.println("[-] Your Key: " + key);
            System.out.println("[-] Your data: " + hM.get(key).getData());
        } else {
            System.out.println(key + " not found");
        }
        System.out.println("--------------------\n");
    }

    //option 3: remove the key and data
    public static void removeAD(HashMap<String, Data> hM) {
        System.out.println("---- Remove a Key and data ----");
        if (hM.isEmpty()) {
            System.out.println("Empty List!");
            return;
        }
        checkListNRst(hM);
        String key = Util.getAString("Enter key to remove: ");
        if (checkKey(hM, key) == true) {
            System.out.println("[+]Removing...");
            System.out.println("[-]Removed your key: " + key);
            System.out.println("[-]Removed your data: " + hM.get(key).getData());
            hM.remove(key);
        } else {
            System.out.println(key + " not found to remove");
        }
        System.out.println("--------------------\n");
    }
}
