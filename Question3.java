import java.util.Scanner;

public class Question3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the line of text : ");
        String s1 = sc.nextLine();          //taking user input as a line of text
             
        String s2 = "SDMCET";               //intialize the pattern to be found into another new string
        try {
            if(s1.toUpperCase().contains(s2)) {     //finding the pattern in the line of text 
                                            //irrespective of the uppercase or lowercase
                                            //so convert the line of text into any one of case
                System.out.println("SUCCESS in finding the substring\n");
            }                               //if pattern found then print appropriate mmessage
            else {
                throw new SubStringNotFoundException();     //else throw new SubStringNotFoundException
            }
        }
        catch(SubStringNotFoundException e) {   
            System.out.println(e.toString());   //printing the appropriate message
        }
    }
}

                    //definition of the SubStringNotFoundException class
class SubStringNotFoundException extends Exception {
    public String toString() {
        return super.toString()+": NOT SUCCESS in finding the substring\n";
    }
}