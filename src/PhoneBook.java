

import java.util.*;
import java.util.stream.Collectors;

/**
 * PhoneBook
 *
 * @author Harsh
 */
public class PhoneBook {

    /**
     * Stores String as key:Which will be the name of contact
     * Object of Contact is the value in the map
     */
    Map<String, Contact> phonebook = new HashMap<>(); //Will store all contacts
    HashMap<String,List<Contact>>cityContact = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    /**
     * addInfo
     *
     * @param contact
     * @return contact
     * <p>
     * This function accesses the setter functions in the Contact.Java class
     * It helps to edit/add the contact information
     */
    public Contact addInfo(String name, Contact contact) {

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
        String number = sc.next();
        System.out.println();
        System.out.println("Enter the email id");
        String id = sc.next();
        System.out.println();

        contact.setName(name);
        contact.setAddress(address);
        contact.setCity(city);
        contact.setState(state);
        contact.setPinCode(pinCode);
        contact.setPhoneNum(number);
        contact.setEmail(id);
        return contact;


    }

    /**
     * @param num This method. Adds the contact information given by the user into address book
     *            To add the info it calls the @addInfo method
     */
    public void addContact(int num) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < num; i++) {
            Contact contact = new Contact();
            System.out.println("Enter the name");
            String name = sc.next();
            System.out.println();
            contact = addInfo(name, contact);

            phonebook.put(name, contact);
        }
        return;
    }


    /**
     * This function edits the contact user wants to edit
     * It calls the addInfo method to add te edited info
     */
    public void editContact() {

        System.out.println("Enter the contact name you want to edit");
        String key = sc.next();
        boolean isKey = phonebook.containsKey(key); //Checks if the key exists or not
        if (isKey) {
            Contact obj;
            obj = phonebook.get(key);
            addInfo(key, obj);

        } else {
            System.out.println("Enter a valid key");
        }
        return;
    }

    /**
     * This function deletes the contact user wants to delete
     */
    public void deleteContact() {
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

    private void searchName() {
        System.out.println("Enter the name of person you want to search");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        Optional<Contact> obj = phonebook.entrySet()
                .stream()
                .filter(x -> phonebook.containsKey(name))
                .map(Map.Entry::getValue)
                .findFirst();
        Contact contact = obj.get();
        System.out.println(name);
        System.out.print("Address:" + contact.getAddress() + " ");
        System.out.print("City:" + contact.getCity() + " ");
        System.out.print("State:" + contact.getState() + " ");
        System.out.println("PinCode:" + contact.getPinCode() + " ");
        System.out.print("Number:" + contact.getPhoneNum() + " ");
        System.out.print("Email-id" + contact.getEmail());
    }


    public Map searchCity(Map<Object,Object>cityList, String city) {
         cityList = phonebook.entrySet()
                .stream()
                .filter(x -> x.getValue().getCity().equals(city))
                .collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));
        return cityList;
    }

    public int countCityContacts(String city) {
        int count = (int) phonebook.entrySet()
                .stream()
                .filter(x -> x.getValue().getCity().equals(city))
                .count();
        return count;
    }

    public HashMap<String, List<Contact>> viewByCity(String city){
        List<Contact>list = phonebook.entrySet()
                            .stream()
                            .filter(x->x.getValue().getCity().equals(city))
                            .map(Map.Entry::getValue)
                            .collect(Collectors.toList());
        cityContact.put(city,list);
        return cityContact;

    }


    public void main() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 6) {
            System.out.println("1)Add contact");
            System.out.println("2)Edit Contact");
            System.out.println("3)Delete Contact");
            System.out.println("4)Search for person via name");
            System.out.println("5)View Phonebook");
            System.out.println("6)Exit");
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
                    searchName();
                    break;
                case 5:
                    System.out.println(phonebook);
                    Iterator<Map.Entry<String, Contact>> itr = phonebook.entrySet().iterator();

                    while (itr.hasNext()) {
                        Map.Entry<String, Contact> book = itr.next();
                        System.out.println(book.getKey() + ":");
                        System.out.print("Address:" + book.getValue().getAddress() + " ");
                        System.out.print("City:" + book.getValue().getCity() + " ");
                        System.out.print("State:" + book.getValue().getState() + " ");
                        System.out.println("PinCode:" + book.getValue().getPinCode() + " ");
                        System.out.print("Number:" + book.getValue().getPhoneNum() + " ");
                        System.out.print("Email-id" + book.getValue().getEmail());
                        System.out.println();
                    }
                    break;
                case 6:
                    System.out.println("Exit:");
                    break;

            }
        }
        return;
    }

    public void sortAlphabetically(){
        Map<String,Contact> sorted = phonebook.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(e->e.getKey(),e->e.getValue(),(e1,e2)->e2,LinkedHashMap::new));
        phonebook = sorted;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phonebook=" + phonebook+
                '}';
    }
}


