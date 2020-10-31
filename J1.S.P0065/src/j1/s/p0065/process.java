package j1.s.p0065;

import data.*;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class process {
//    static Student studens;
//    List<Student> students;
//    List<Student> averageStudent;

    public static void createStudent(List<Student> students) {
        boolean check = false;
        String name = null;
        String classes = null;
        double maths = 0;
        double chemistry = 0;
        double physics = 0;
        int i = 0;

        System.out.println("====== Management Student Program ======");
        name = MyTools.getAString("Name: ", "Error!");
        classes = MyTools.getAString("Classes: ", "Error!");
        while (check != true) {
            maths = MyTools.getADouble("Maths: ", "Maths is digit");
            if (maths > 0 && maths < 11) {
                check = true;
            } else if (maths > 10) {
                System.out.println("Maths is less than equal ten");
            } else if (maths < 0) {
                System.out.println("Maths is greater than equal zero");
            }
        }
        check = false;
        while (check != true) {
            chemistry = MyTools.getADouble("Chemistry: ", "Chemistry is digit");
            if (chemistry > 0 && chemistry < 11) {
                check = true;
            } else if (chemistry > 10) {
                System.out.println("Chemistry is less than equal ten");
            } else if (chemistry < 0) {
                System.out.println("Chemistry is greater than equal zero");
            }
        }
        check = false;
        while (check != true) {
            physics = MyTools.getADouble("Physics: ", "Physics is digit");
            if (physics > 0 && physics < 11) {
                check = true;
            } else if (physics > 10) {
                System.out.println("Physics is less than equal ten");
            } else if (physics < 0) {
                System.out.println("Physics is greater than equal zero");
            }
        }
        Student a = new Student(name, classes, maths, chemistry, physics);
        students.add(a);
    }

    public static List<Student> averageStudent(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            students.get(i).setAvg((students.get(i).getMathM() + students.get(i).getPhysicalM() + students.get(i).getChemistryM()) / 3);
            if (students.get(i).getAvg() > 7.5) {
                students.get(i).setType('A');
            } else if (6 <= students.get(i).getAvg() && students.get(i).getAvg() <= 7.5) {
                students.get(i).setType('B');
            } else if (4 <= students.get(i).getAvg() && students.get(i).getAvg() < 6) {
                students.get(i).setType('C');
            } else if (students.get(i).getAvg() < 4) {
                students.get(i).setType('D');
            }
        }
        return students;
    }

    public static void printStudent(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.printf("------ Student%d Info ------\n", i + 1);
            System.out.println("Name: " + students.get(i).getName());
            System.out.println("Class: " + students.get(i).getClasses());
            System.out.println(String.format("AVG: %.2f", students.get(i).getAvg()) + "%");;
            System.out.println("Type: " + students.get(i).getType());
        }
    }

    private static HashMap<String, Double> getPercentTypeStudent(List<Student> students) {
        HashMap<String, Double> a = new HashMap<>();
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int total = students.size();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getType() == 'A') {
                countA++;
            }
            if (students.get(i).getType() == 'B') {
                countB++;
            }
            if (students.get(i).getType() == 'C') {
                countC++;
            }
            if (students.get(i).getType() == 'D') {
                countD++;
            }
        }
        if (countA > 0) {
            a.put("A", (double) countA / total * 100);
        } else if (countA == 0) {
            a.put("A", (double) 0);
        }
        if (countB > 0) {
            a.put("B", (double) countB / total * 100);
        } else if (countB == 0) {
            a.put("B", (double) 0);
        }
        if (countC > 0) {
            a.put("C", (double) countC / total * 100);
        } else if (countC == 0) {
            a.put("C", (double) 0);
        }
        if (countD > 0) {
            a.put("D", (double) countD / total * 100);
        } else if (countD == 0) {
            a.put("D", (double) 0);
        }

        return a;
    }

    public static void displayHashMap(List<Student> students) {
        HashMap<String, Double> getPercentTypeStudent = getPercentTypeStudent(students);
        for (Map.Entry student : getPercentTypeStudent.entrySet()) {
            System.out.println(student.getKey() + ": " + String.format("%.2f", student.getValue()) + "%");
        }
    }
}
