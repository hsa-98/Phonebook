import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {

    HashMap<String,PhoneBook> hashMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
     public static void main(String[] args) {
         System.out.println("Welcome to address book program");
        AddressBook addressBook = new AddressBook();
        int choice =0;
        while (choice!=3) {
            System.out.println("1)To create a new address book");
            System.out.println("2)To access an existing address book");
            System.out.println("3)Exit");
            
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addressBook.newBook();
                    break;
                case 2:
                    addressBook.accessBook();
                    break;
                case 3:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Enter valid choice");

            }
        }

    }
    public void newBook(){
        PhoneBook phoneBook = new PhoneBook();
        System.out.println("Enter the name of the new address book");
        String name = sc.next();
        hashMap.put(name,phoneBook);
        return;
    }
    public void accessBook(){
         System.out.println("Enter the name of the book you want to access");
         String name = sc.next();
         PhoneBook phoneBook = hashMap.get(name);
         phoneBook.main();
         return;

    }
}
