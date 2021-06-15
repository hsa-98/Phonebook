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
        editContact(num1);
        deleteContact(num1);
        return;

        }

    /**
     * method editContact
     * @param num1(class object)
     * Takes the name of contact as input and edits the contact info if it exists.
     */
    public static void editContact(Contact num1){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the contact name you want to edit");
        String key= sc.next();
        boolean isKey = num1.phonebook.containsKey(key); //Checks if the key exists or not
        if(isKey){
            System.out.println("Enter the address");
            String address = sc.next();
            System.out.println("Enter the pin-code");
            String pinCode = sc.next();
            System.out.println("Enter the contact num");
            String number = sc.next();
            System.out.println("Enter the email id");
            String id = sc.next();
            List <String> newInfo= new ArrayList<>();
            newInfo.add(address);
            newInfo.add(pinCode);
            newInfo.add(number);
            newInfo.add(id);
            num1.phonebook.replace(key,newInfo);
            System.out.println(num1.phonebook);
        }
        else {
            System.out.println("Enter a valid key");
        }
        return;
    }

    /**
     * deleteContact:
     * @param num1
     * This function deletes the contact input by the user.
     */
    public static void  deleteContact(Contact num1){
        System.out.println("Enter the contact name you want to delete");
        Scanner sc = new Scanner(System.in);
        String key = sc.next();
        boolean isKey = num1.phonebook.containsKey(key); //Checks if the key exists or not
        if(isKey){
            num1.phonebook.remove(key); //removes a key from hashmap.
            System.out.println("Key is deleted");
            System.out.println(num1.phonebook);
        }
        else{
            System.out.println("Enter a valid key");
        }
        return;
    }



    public static void main(String args[]){
        System.out.println("Welcome to address book program");
        System.out.println("ENter the number of contacts you want to enter");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        addContact(num);

    }
}
