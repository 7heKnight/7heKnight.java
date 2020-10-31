package j1sp0068;

import java.util.*;

/**
 *
 * @author ASUS
 */
public class managementStudent {

    public static List<Student> addStudent(List<Student> students){
        String name;
        String classes;
        boolean check = false;
        float mark=0;

        name = MyTools.getAString("Name: ", "Error!");
        classes = MyTools.getAString("Classes: ", "Error!");
        while(check!=true){
            mark = (float )MyTools.getADouble("Mark: ", "Error!");
            if(mark<0) System.out.println("Mark must greater than 0");
            else if(mark>100) System.out.println("Mark must less than 100");
            else check =true;
        }
        
        Student a = new Student(name, classes, mark);
        students.add(a);
        return students;
    }
    public static List<Student> sortStudent(List<Student> students){
        
        Collections.sort(students);
        return students;
    }
    public static void display(List<Student> students){
        for(int i=0;i<students.size();i++){
            System.out.printf("-------------Student %d-------------\n",i+1);
            System.out.println(students.get(i));
        }
        
    }
}
