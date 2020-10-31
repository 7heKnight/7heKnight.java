package j1sp0068;
import java.util.*;
/**
 *
 * @author ASUS
 */
public class J1SP0068 {
    
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        char stop=0;
        System.out.println("====== Collection Sort Program ======");
        while (stop!='N') {stop=0;  
            System.out.println("Please input student information ");
            students=managementStudent.addStudent(students);
            while(stop!='Y'&&stop!='N'){
                String a = MyTools.getAString("Do you want to enter more student information?(Y/N): ", "Error!");
                stop = a.toUpperCase().charAt(0);
                if(stop!='Y'&&stop!='N') System.out.println("There is no option like that!");
            }
            if(stop=='N') managementStudent.display(managementStudent.sortStudent(students));
        }
    }
    
}
