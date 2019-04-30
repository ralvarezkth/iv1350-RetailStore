package retailstore.integration;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all calls to the item registry with items that may be purchased.
 */
public class ItemRegistry {
	
	private List<ItemDTO> exampleItemDB = new ArrayList<>();
	
	ItemRegistry() {	
		addItems();
	}
	
	/**
	 * Finds the item corresponding to the scanned item identifier.
	 * 
	 * @param itemIdentifier The item identifier of the scanned item.
	 * @return foundItem The found item that corresponds to the scanned item identifier.
	 */
	public ItemDTO findItem(ItemIdentifierDTO itemIdentifier) {
		ItemDTO foundItem = null;
		
		for(int i = 0; i < exampleItemDB.size(); i++) {
			if(itemIdentifier.getItemIdentifier().equals(exampleItemDB.get(i).getItemIdentifierDTO().getItemIdentifier())) {
				foundItem = exampleItemDB.get(i);
				break;
			}
		}
		
		return foundItem;
	}
	
	private void addItems() {
		ItemIdentifierDTO itemIdentifierCorn = new ItemIdentifierDTO("0123456789");
		ItemIdentifierDTO itemIdentifierBread = new ItemIdentifierDTO("1231231231");
		ItemIdentifierDTO itemIdentifierChips = new ItemIdentifierDTO("5555555555");
		
		Amount cornPrice 	= new Amount(15);
		Amount cornVATrate 	= new Amount(25);
		Amount breadPrice 	= new Amount(20);
		Amount breadVATrate = new Amount(12);
		Amount chipsPrice 	= new Amount(25);
		Amount chipsVATrate = new Amount(6);
		
		exampleItemDB.add(new ItemDTO(cornPrice, cornVATrate, "Corn", itemIdentifierCorn));
		exampleItemDB.add(new ItemDTO(breadPrice, breadVATrate, "Bread", itemIdentifierBread));
		exampleItemDB.add(new ItemDTO(chipsPrice, chipsVATrate, "Chips", itemIdentifierChips));
	}
	

}
