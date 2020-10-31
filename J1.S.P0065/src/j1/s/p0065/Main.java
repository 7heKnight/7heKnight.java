package j1.s.p0065;

import data.Student;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        boolean check = false;
        char stop = 0;
        List<Student> students = new ArrayList<Student>();
        HashMap<String, Double> b = new HashMap<>();
//        process.averageStudent(students); used for hashmap

        while (stop != 'N') {
            stop = 0;
            process.createStudent(students);//createStudent
            while (stop != 'Y' && stop != 'N') {
                String a = MyTools.getAString("Do you want to enter more student information?(Y/N): ", "Error!");
                stop = a.toUpperCase().charAt(0);
                if (stop != 'Y' && stop != 'N') {
                    System.out.println("There is no option like that!");
                }
            }
            if (stop == 'N') {
                process.printStudent(process.averageStudent(students));
                process.displayHashMap(students);
            }
        }
    }

}
