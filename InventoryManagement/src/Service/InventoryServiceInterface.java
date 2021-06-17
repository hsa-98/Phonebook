package Service;

import Model.Inventory;

import java.util.ArrayList;
import java.util.List;

public interface InventoryServiceInterface {
    public abstract List<Inventory> addInventory(Inventory inventory, List<Inventory>arrayList);
}
