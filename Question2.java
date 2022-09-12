import java.util.Scanner;

public class Question2 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter an integer : ");
        int inum1 = sc.nextInt();           //taking input from the user
        int flag = 0;                       //flag variable initialization

        try {
            if(inum1 >= 0) {                //if inum < 0 then it will throw an NegativeNumberNotAllowedException
                try {
                    if(inum1 > 1) {         //prime number starts from 2
                        for(int i=2; i<Math.sqrt(inum1); i++) {
                            if(inum1%i == 0) {
                                flag = 1;   //if inum1%i == 0 then it is not a prime number
                                throw new NumberNotPrimeException();    //so throw NumberNotPrimeExcpetion
                            }
                        }
                    }                       
                    else {
                        flag = 1;           //if inum <=1 then throw NumberNotPrimeException
                        throw new NumberNotPrimeException();
                    }
                }
                catch(NumberNotPrimeException p) {      //printing the appropriate exception message
                    System.out.println(p.toString());
                }
            }
            else {                          //throwing NegativeNumberNotAllowedException
                flag = 1;
                throw new NegativeNumberNotAllowedException();
            }
        }
        catch(NegativeNumberNotAllowedException e) {    //printing the appropriate message
            System.out.println(e.toString());
        }

        if(flag == 0) {                     //if flag == 0 then the number is a prime number so print the appropriate message
            System.out.println("This number is a prime number and a positive number\n");
        }
    }

}
                    //definition of NegativeNumberNotAllowedException class
class NegativeNumberNotAllowedException extends Exception {
    public String toString() {              //printing the appropriate message     
        return super.toString()+" : This is a negative number\n";
    }
}

                    //definition of NumberNotPrimeException class
class NumberNotPrimeException extends Exception {
    public String toString() {              //printing the appropriate message
        return super.toString()+" : Number is not a prime number\n";
    }
}