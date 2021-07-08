import java.util.*;

public class AddressBook {

    HashMap<String, PhoneBook> hashMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to address book program");
        AddressBook addressBook = new AddressBook();
        int choice = 0;
        while (choice != 7) {
            System.out.println("1)To create a new address book");
            System.out.println("2)To access an existing address book");
            System.out.println("3)Search a person using city/state across multiple address book");
            System.out.println("4)Count the number  of contacts in a city");
            System.out.println("5)Store contacts in a city together");
            System.out.println("6)Sort Contacts alphabetically");
            System.out.println("6)Exit");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addressBook.newBook();
                    break;
                case 2:
                    addressBook.accessBook();
                    break;
                case 3:
                    addressBook.searchViaCity();
                    break;
                case 4:
                    addressBook.countCity();
                    break;
                case 5:
                    addressBook.cityDictionary();
                    break;
                case 6:
                    addressBook.sort();
                case 7:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Enter valid choice");

            }
        }

    }

    /**
     * \
     * This function creates  a new address book
     */
    public void newBook() {
        PhoneBook phoneBook = new PhoneBook();
        System.out.println("Enter the name of the new address book");
        String name = sc.next();
        hashMap.put(name, phoneBook);
        return;
    }

    /**
     * Accesses a particluar address book
     */
    public void accessBook() {
        System.out.println("Enter the name of the book you want to access");
        String name = sc.next();
        PhoneBook phoneBook = hashMap.get(name);
        phoneBook.main();
        return;

    }


    /**
     * Takes the city name as input
     * calls function search city
     * Then prints the returned list
     */
    public void searchViaCity() {
        System.out.println("Enter the name of city");
        String city = sc.next();
        Iterator<Map.Entry<String, PhoneBook>> book = hashMap.entrySet().iterator();
        Map<Object, Object> contacts = new HashMap<>();
        while (book.hasNext()) {
            Map.Entry<String, PhoneBook> bookName = book.next();
            PhoneBook phoneBook = bookName.getValue();
            contacts = phoneBook.searchCity(contacts, city);
        }
        System.out.println("The contacts in city are");
        Iterator<Map.Entry<Object, Object>> cityList = contacts.entrySet().iterator();
        while (cityList.hasNext()) {
            Map.Entry<Object, Object> contactName = cityList.next();
            System.out.print(contactName.getKey() + " ");
            Contact contact = (Contact) contactName.getValue();
            System.out.print(contact.getCity());
            System.out.println();
        }
    }

    public void countCity() {
        System.out.println("Enter the name of city");
        String city = sc.next();
        Iterator<Map.Entry<String, PhoneBook>> book = hashMap.entrySet().iterator();
        int count = 0;
        while (book.hasNext()) {
            Map.Entry<String, PhoneBook> bookName = book.next();
            PhoneBook phoneBook = bookName.getValue();
            count += phoneBook.countCityContacts(city);
        }
        System.out.println("The number of contacts in " + city + " are " + count);
    }

    public void cityDictionary() {
        System.out.println("Enter the name of city");
        String city = sc.next();
        Iterator<Map.Entry<String, PhoneBook>> book = hashMap.entrySet().iterator();
        Map<String, List<Contact>> contacts = new HashMap<>();

        while (book.hasNext()) {
            Map.Entry<String, PhoneBook> bookName = book.next();
            PhoneBook phoneBook = bookName.getValue();
            contacts = phoneBook.viewByCity(city);
        }

        Iterator<Map.Entry<String, List<Contact>>> iterator = contacts.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<Contact>> list = iterator.next();
            System.out.println(list.getKey());
            for (int i = 0; i < list.getValue().size(); i++) {
                Contact temp = list.getValue().get(i);
                System.out.println(temp.getName());
            }
        }
    }

    public void sort(){
        Iterator<Map.Entry<String, PhoneBook>> book = hashMap.entrySet().iterator();
        while (book.hasNext()){
            book.next().getValue().sortAlphabetically();
        }
    }
}
