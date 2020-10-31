package j1.s.p0074;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Calculator {
    static Scanner sc = new Scanner(System.in);
    
    public static void scanf(int[][] matrix, int x, int y){
        for(int i=0; i<x;i++){
            for(int j=0;j<y;j++){
                System.out.printf("Enter Matrix [%d][%d]: ",i+1,j+1);
                    matrix[i][j] = MyTools.getAnIntergerForMatrix("Wrong! Re-enter:");
            }
        }
    }
    
    public static void printf(int[][] mtr,int x,int y){
        for(int i=0;i<x;i++){
            for(int j=0; j<y; j++){
                System.out.printf("[%d]",mtr[i][j]);
            }
            System.out.println("");
        }
    }
    
    private static int [][] addition(){
        int x=0, y=0; boolean check = false;
        int[][] matrix;
        int[][] matrix1;
        int[][] result;
        
        System.out.println("-------- Addition --------");
        while(check!=true){
            x = MyTools.getAnInteger("Enter Row Matrix 1: ", "Wrong format!");
            y = MyTools.getAnInteger("Enter Column Matrix 1: ", "Wrong format!");
            if(x<1||y<1){
                System.out.println("- Not allow digit lower than one");
            }
            else check=true;
        }
        
        matrix=new int [x][y];
            scanf(matrix,x,y);
        
        System.out.printf("Enter Row Matrix 2: %d\n",x);
        System.out.printf("Enter Column Matrix 2: %d\n",y);
        matrix1=new int [x][y];
            scanf(matrix1,x,y);
			
        System.out.println("-------- Result --------");
        printf(matrix,x,y);
        System.out.println("+");
        printf(matrix1, x, y);
        System.out.println("=");
		
        result = new int[x][y];
        for(int i=0; i<x;i++){
            for(int j=0; j<y;j++){
                result[i][j]=matrix[i][j]+matrix1[i][j];
            }
        }
        return result;
    }
	
    private static int[][] substraction(){
        int x=0, y=0; boolean check = false;
        int[][] matrix;
        int[][] matrix1;
        int[][] result;
        System.out.println("-------- Substraction --------");
        while(check!=true){
            x = MyTools.getAnInteger("Enter Row Matrix 1: ", "Wrong format!");
            y = MyTools.getAnInteger("Enter Column Matrix 1: ", "Wrong format!");
            if(x<1||y<1){
                System.out.println("- Not allow digit lower than one");
            }
            else check=true;
        }
        
        matrix=new int [x][y];
            scanf(matrix,x,y);
        
        System.out.printf("Enter Row Matrix 2: %d\n",x);
        System.out.printf("Enter Column Matrix 2: %d\n",y);
        matrix1=new int [x][y];
            scanf(matrix1,x,y);
			
        System.out.println("-------- Result --------");
        printf(matrix,x,y);
        System.out.println("-");
        printf(matrix1, x, y);
        System.out.println("=");
		
        result = new int[x][y];
        for(int i=0; i<x;i++){
            for(int j=0; j<y;j++){
                result[i][j]=matrix[i][j] - matrix1[i][j];
            }
	}
        return result;
    }
	
    private static int[][] multiplication() {
        int x=0, x1=0, y=0, y1=0; boolean check=false;
        int[][] matrix;
        int[][] matrix1;
        int[][] result;
        
        System.out.println("-------- Multiplication --------");
        while(check!=true){
            x = MyTools.getAnInteger("Enter Row Matrix 1: ", "Wrong format!");
            y = MyTools.getAnInteger("Enter Column Matrix 1: ", "Wrong format!");
            if(x<1||y<1){
                System.out.println("- Not allow digit lower than one");
            }
            else check=true;
        }check=false;
        matrix = new int [x][y];
            scanf(matrix, x, y);
        
        while(check!=true){
            x1 = MyTools.getAnInteger("Enter Row Matrix 2: ", "Wrong format!");
            y1 = MyTools.getAnInteger("Enter Column Matrix 2: ", "Wrong format!");
            if(x1<1||y1<1) System.out.println("- Not allow digit lower than one");
            else{
                if(x1==y) 
                    check = true;
                else System.out.println("Column 1 must equal to row 2 (COLUMN1 == ROW2)");
            }
        }
        matrix1 = new int [x1][y1];
            scanf(matrix1, x1, y1);
			
        System.out.println("-------- Result --------");
        printf(matrix,x,y);
        System.out.println("*");
        printf(matrix1, x1, y1);
        System.out.println("=");
        
        result = new int[x][y1];
        for(int i=0;i<x;i++){    
            for(int j=0;j<y1;j++){
                result[i][j]=0;    
                for(int k=0;k<y;k++){    
                    result[i][j]+= matrix[i][k] * matrix1[k][j];
                }    
            }    
        }
//        printf(result, x, y1);
        return result;
    }
    public static void display(int op){
        int[][] a;int row; int column;
        if(op == 1){
            a = addition();
            row = a.length;
            column=a[0].length;
            printf(a, row, column);
        }
        else if(op==2){
            a = substraction();
            row = a.length;
            column=a[0].length;
            printf(a, row, column);
        }
        else if(op==3){
            a = multiplication();
            row = a.length;
            column=a[0].length;
            printf(a, row, column);
        }
    }
}
