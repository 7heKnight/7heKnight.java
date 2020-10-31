/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0001;


/**
 *
 * @author ASUS
 */

public class J1SP0001 {
    
    public static void display(int a[]){
        for(int i=0; i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.print("\n");
    }
    
    public static void bubbleSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i]>a[j]){
                    int b=a[i];
                    a[i]=a[j];
                    a[j]=b;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int input=0;char opinion=0; String inp;
        int[] a;boolean check=false;
        while(opinion!='N'){
            while(check!=true){
                input = Mytools.getAnInteger("Enter number of array: ", "Wrong Format!");
                if(input<1){
                    System.out.println("Number must bigger than 0!");
                    input=0;
                }
                else check = true;
            } check = false;
            a = new int[input];

            for(int i=0; i<input;i++){
                a[i] = (int) (Math.random()*(input))+1;
            }
            int b[] = a;
            System.out.print("Unsorted array: ");
            display(a);
            bubbleSort(b);
            System.out.print("Sorted array: ");
            display(b);
            
            inp=Mytools.getAString("Do you want to add more(Y/N): ", "Error!").toUpperCase();
            opinion=inp.charAt(0);
            do {                
                if(opinion=='Y');
                else if(opinion=='N') {
                    System.out.println("Bái bai :)");
                    check = true;
                }
                else if(!(opinion=='Y'||opinion=='N')){
                    inp=Mytools.getAString("Just (Y/N). Re-enter your choice: ", "Error!").toUpperCase();
                    opinion=inp.charAt(0);
                }
            }while (opinion!='Y' && opinion!='N');
        }
    }
    
}
