import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * PhoneBook
 * @author Harsh
 */
public class PhoneBook {
    /**
     * addContact: Calls the contact class
     */
    public static void addContact(int num){
        Scanner sc = new Scanner(System.in);
        HashMap<String, List<String>> phonebook = new HashMap<String, List<String>>();
        Contact num1 = new Contact();
        num1.Contact(num);
        }




    public static void main(String args[]){
        System.out.println("Welcome to address book program");
        System.out.println("ENter the number of contacts you want to enter");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        addContact(num);
    }
}
