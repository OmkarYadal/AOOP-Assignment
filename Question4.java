import java.util.Scanner;
import java.io.*;

public class Question4 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int var1;
        System.out.println("\nEnter the data to be entered into the file");
        String s1 = sc.nextLine();      //taking the input from the user as a line of text
        
        try {
            File f1 = new File("E:/java/Alphabets.txt");    //giving the path of Alphabets.txt file
            f1.createNewFile();         //if file not found then creating new file
            FileOutputStream fout = new FileOutputStream(f1);       //creating object of FileOutputStream

            for(int i=0; i<s1.length(); i++) {  
                fout.write(s1.charAt(i));   //writing the line of text into the file
            }

            File f2 = new File("E:/java/Consonants.txt");   //giving the path of Consonants.txt file
            f2.createNewFile();         //if file not found then creating new file
            FileOutputStream fout1 = new FileOutputStream(f2);      //creating object of FileOutputStream

            FileInputStream fin = new FileInputStream(f1);          //creating object of FileInputStream for first file

            do {                                    
                var1 = fin.read();      //reading the input from the file
                if(var1 != -1) {        
                    try {   
                        char var2 = (char)var1;     //converting the int to char datatype

                        switch(var2) {  //checking whether char is vowel or a consonant
                            case 'a' : 
                            case 'A' : 
                            case 'e' :
                            case 'E' :
                            case 'i' :
                            case 'I' :
                            case 'o' :
                            case 'O' :
                            case 'u' :  //if character read is a vowel then throw VowelNotAllowedException
                            case 'U' : throw new VowelNotAllowedException(var2);
                            
                            default : fout1.write(var2);    //else write the character into the Consonants.txt file
                        }
                    }
                    catch(VowelNotAllowedException p) {
                        System.out.println(p);      //printing the appropriate exception message
                    }
                }
            }
            while(var1 != -1);          //checking the end of file
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}

                    //definition of VowelNotAllowedExcpetion class
class VowelNotAllowedException extends Exception {
    char a;
    public VowelNotAllowedException(char a) {
        this.a = a;
    }
    public String toString() {
        return  "'"+a+"' "+super.toString()+": Vowels are not allowed";
    }
}
