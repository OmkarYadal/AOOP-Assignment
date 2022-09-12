import java.util.*;
import java.io.*;

class Threading extends Thread {
    String name;
    int start,ending;

    public Threading(String name,int start,int ending) {
        this.name = name;
        this.start = start;
        this.ending = ending;
    }
    public void run() {
        System.out.println("Thread "+name+" is starting");
        Question5.answer(start,ending);
    }
}

class Threading2 extends Thread {
    String name;
    int start,ending;

    public Threading2(String name,int start,int ending) {
        this.name = name;
        this.start = start;
        this.ending = ending;
    }
    public void run() {
        System.out.println("Thread "+name+" is starting");
        Question5.answer2(start,ending);
    }
}
public class Question5 { 
    static int[] A = new int[1000];
    static int n;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the n");
        n = sc.nextInt();
        System.out.println("Enter the integers");
        
        for(int i=0; i<n; i++) {
            A[i] = sc.nextInt();
        }
    
        File f1 = new File("E:/java/Integers.txt");
        try {
            f1.createNewFile();
           
            FileInputStream fin = new FileInputStream("Integers.txt");
            
            Writer fout = new FileWriter(f1);
            for(int i=0; i<n; i++) {
                fout.append(String.valueOf(A[i])+" ");
            }
            
            fout.close();
            
        
            int inum1 = n/3;
            int inum2 = 2*(n/3);
        
            Threading t1 = new Threading("T1",0,inum1-1);
            Threading t2 = new Threading("T2",inum1,inum2-1);
            Threading t3 = new Threading("T3",inum2,n-1);
            Threading2 t4 = new Threading2("T4",0,n);

            try {
                t1.start();
                t1.join();
                t2.start();
                t2.join();
                t3.start();
                t3.join();
                t4.start();
                t4.join();
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    public static void answer(int start,int ending) {
        Arrays.sort(A,start,ending);

        System.out.println("Thread has ended here");
    }

    public static void answer2(int start,int ending) {
        Arrays.sort(A,start,ending);

        for(int i=0; i<n; i++) {
            System.out.println(A[i]);
        }
        File f2 = new File("E:/java/SortedIntegers.txt");

        try {
            f2.createNewFile();
            Writer fout = new FileWriter(f2);
                
            for(int i=0; i<n; i++) {
                fout.append(String.valueOf(A[i])+" ");
            }
            
            fout.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        
        System.out.println("Thread has ended here");
    }
}
