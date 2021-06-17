package Controller;

import Model.Inventory;
import Service.InventoryService;
import Service.InventoryServiceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryMain {

    static Scanner sc = new Scanner(System.in);
    static InventoryServiceInterface inventoryServiceInterface = new InventoryService();

    public static void main(String args[]) {

        List<Inventory> inventoryList = new ArrayList();

        int choice = 0;
        while (choice != 6) {

            System.out.println("1)Add inventory");
            System.out.println("2)View Inventory");
            System.out.println("3)Edit Inventory");
            System.out.println("4)Delete Inventory");
            System.out.println("5)Count Inventory");
            System.out.println("6)Exit");
            choice = sc.nextInt();


            switch (choice) {
                case 1:
                    Inventory inventory = new Inventory();
                    System.out.println("Add inventory");
                    System.out.println("Enter the name");
                    String name = sc.next();
                    inventory.setName(name);
                    System.out.println("Enter the price ");
                    double price = sc.nextInt();
                    inventory.setPrice(price);
                    System.out.println("weight");
                    double weight = sc.nextInt();
                    inventory.setWeight(weight);
                    inventoryList.add(inventory);
                    inventoryServiceInterface.addInventory(inventory, inventoryList);


                    inventoryServiceInterface.addInventory(inventory, inventoryList);

                    break;
                case 2:
                    System.out.println("View Inventory");
                    for (Inventory i : inventoryList) {
                        System.out.println(i);
                    }
                    break;
                case 3:
                    System.out.println("Edit Inventory");
                    System.out.println("Enter the name you want to edit");
                    String nameChange = sc.next();
                    for (int i = 0; i < inventoryList.size(); i++) {
                        if (((Inventory)inventoryList.get(i)).getName() == nameChange){
                            System.out.println("Enter the price ");
                            double priceNew = sc.nextInt();
                            inventoryList.get(i).setPrice(priceNew);
                            System.out.println("weight");
                            double weightNew = sc.nextInt();
                            inventoryList.get(i).setWeight(weightNew);
                            break;

                        }
                    }
                    break;

                case 4:
                    System.out.println("Delete Inventory");
                    System.out.println("Enter the name you want to delete");
                    String nameDelete = sc.next();
                    for (int i=0; i<inventoryList.size();i++) {
                        if (inventoryList.get(i).getName() == nameDelete) {
                            inventoryList.remove(i);
                        }

                    }
                    break;

                    case 5:
                    System.out.println("Count Inventory"+inventoryList.size());

                    break;
                case 6:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Enter a valid input");

            }
        }

    }
}
