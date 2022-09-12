import java.io.FileNotFoundException;
import java.io.*;

public class Question1 {
    public static void main(String args[]) {

        try {
            int inum1 = 10;       //initializing two integers
            int inum2 = 0;        //inum2 is zero 

            int inum3;
            inum3 = inum1/inum2;  //here any number divide by zero is not defined 
        }                         //so it will throw an ArithmeticException
        catch(ArithmeticException e) {
            System.out.println(e.toString());
        }

        try {
            int[] A = new int[10];   //declaration of the array

            for(int i=0; i<12; i++) {  //filling values in array upto index 11
                A[i] = i;              //which is not valid 
            }                          //so it will throw ArrayIndexOutOfBoundsExcpetion

            for(int i=0; i<10; i++) {
                System.out.println(A[i]);
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }

        try {                       //searching the file which is not present
            File fl = new File("E:/java/file.txt");
                                    //throwing an error
            FileInputStream fr = new FileInputStream(fl);
        }                           //there is no any file named file.txt
                                    //so it will throw FileNotFoundException
        catch(FileNotFoundException e) {
            System.out.println(e.toString());
        }

    }
}
