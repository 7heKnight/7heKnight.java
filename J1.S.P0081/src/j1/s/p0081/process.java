package j1.s.p0081;

import java.util.*;
/**
 *
 * @author ASUS
 */
public class process {
    static Random rand;
    static data[] beeList = new data[10];
    
    public static void createBee(){
        String name;
        
        String[] a={"Drone","Queen","Worker"};
        
        for (int i = 0; i < 10; i++) {
            rand = new Random();
            name=a[rand.nextInt(3)];
            beeList[i] = new data(name, 100, "Alive");
            System.out.println(beeList[i]);
        }
    }
    //Worker has a health below 70% 
    //Queen has a health below 20%
    //Drone below 50%
    public static void checkStatus(int i){
        if(beeList[i].getName()=="Worker"){
            if(beeList[i].getHealth()<70){
                beeList[i].setStatus("Dead");
            }
        }
        if(beeList[i].getName()=="Drone"){
            if(beeList[i].getHealth()<50){
                beeList[i].setStatus("Dead");
            }
        }
        if(beeList[i].getName()=="Queen"){
            if(beeList[i].getHealth()<20){
                beeList[i].setStatus("Dead");
            }
        }
    }
    
    public static boolean checkList(){
        int count=0;
        for(int i=0; i<beeList.length;i++){
            if(beeList[i].getHealth()==0) count++;
        }
        if(count==10) return true;
        else return false;
        
    }
    
    public static void Damage() {
        int hp;
        for (int i = 0; i < 10; i++) {
            rand = new Random();
            hp = rand.nextInt(80);
            beeList[i].setHealth( beeList[i].getHealth() - hp );
            if(beeList[i].getHealth()<0) beeList[i].setHealth(0);
            checkStatus(i);
            System.out.println(beeList[i]);
        }
    }
}
