import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Contact: This class creates a phonebook and keeps em together
 * @author Harsh
 */

public class Contact {
    HashMap<String ,List<String>> phonebook = new HashMap<String, List<String>>();

    /**
     * Contact is a constructor. When called takes input from user.
     */
    public void  Contact(int num){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<num;i++) {
            System.out.println("Enter the name");
            String name = sc.next();
            System.out.println("Enter the address");
            String address = sc.next();
            System.out.println("Enter the pin-code");
            String pinCode = sc.next();
            System.out.println("Enter the contact num");
            String number = sc.next();
            System.out.println("Enter the email id");
            String id = sc.next();
            List<String> contact = new ArrayList<String>();
            contact.add(address);
            contact.add(pinCode);
            contact.add(number);
            contact.add(id);
            this.phonebook.put(name, contact);
        }
        System.out.println(phonebook);
    }
}
