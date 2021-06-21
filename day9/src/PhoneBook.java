

import java.util.*;

/**
 * PhoneBook
 * @author Harsh
 */
public class PhoneBook {

    static HashMap<String, Contact> phonebook = new HashMap<String, Contact>(); //Will store all contacts
    static Scanner  sc = new Scanner(System.in);

    /**
     * addInfo
     * @param contact
     * @return contact
     *
     * This function acceses the setter functions in the Contact.Java class
     * It helps to edit/add the contact information
     */
    public static Contact addInfo(Contact contact){

        System.out.println("Enter the address");
        String address = sc.next();
        System.out.println();
        System.out.println("Enter the City");
        String city = sc.next();
        System.out.println();
        System.out.println("Enter the State");
        String state = sc.next();
        System.out.println();
        System.out.println("Enter the pin-code");
        int pinCode = sc.nextInt();
        System.out.println();
        System.out.println("Enter the contact num");
        int number = sc.nextInt();
        System.out.println();
        System.out.println("Enter the email id");
        String id = sc.next();
        System.out.println();
        contact.setAddress(address);
        contact.setCity(city);
        contact.setState(state);
        contact.setPinCode(pinCode);
        contact.setPhoneNum(number);
        contact.setEmail(id);
        return contact;


    }

    /**
     *
     * @param num
     * This method. Adds the contact information given by the user into address book
     * To add the info it calls the @addInfo method
     */
    public static void addContact(int num) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < num; i++) {
            Contact contact = new Contact();
            System.out.println("Enter the name");
            String name = sc.next();
            System.out.println();
            contact = addInfo(contact);

            phonebook.put(name, contact);
        }
        return;
    }


    /**
     * This function edits the contact user wants to edit
     * It calls the addInfo method to add te edited info
     */
    public static void editContact() {

        System.out.println("Enter the contact name you want to edit");
        String key = sc.next();
        boolean isKey = phonebook.containsKey(key); //Checks if the key exists or not
        if (isKey) {
            Contact obj;
            obj = phonebook.get(key);
            obj = addInfo(obj);

        }
        else {
            System.out.println("Enter a valid key");
        }
        return;
    }

    /**
     * This function deletes the contact user wants to delete
     */
    public static void deleteContact() {
        System.out.println("Enter the contact name you want to delete");
        String key = sc.next();
        boolean isKey = phonebook.containsKey(key); //Checks if the key exists or not
        if (isKey) {
            phonebook.remove(key); //removes a key from hashmap.
            System.out.println("Contact is deleted");
        } else {
            System.out.println("Enter a valid key");
        }
        return;
    }
    public static void main(String args[]) {
        System.out.println("Welcome to address book program");

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("1)Add contact");
            System.out.println("2)Edit Contact");
            System.out.println("3)Delete Contact");
            System.out.println("4)View Phonebook");
            System.out.println("5)Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the number of contacts you want too enter");
                    int num = sc.nextInt();
                    addContact(num);
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    for (Map.Entry<String,Contact> book : phonebook.entrySet()){
                        System.out.println(book.getKey()+":");
                        System.out.print("Address:" +book.getValue().getAddress()+" ");
                        System.out.print("City:" +book.getValue().getCity()+" ");
                        System.out.print("State:" +book.getValue().getState()+" ");
                        System.out.println("Pincode:" +book.getValue().getPinCode()+" ");
                        System.out.print("Number:" +book.getValue().getPhoneNum()+" ");
                        System.out.print("Email-id" +book.getValue().getEmail());
                        break;


                    }
                case 5:
                    System.out.println("Exit:");
                    break;

                }
            }
        }
    }


