package retailstore.integration;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author User
 *
 */
public class ItemRegistry {
	
	private List<ItemDTO> exampleItemDB = new ArrayList<>();
	
	/**
	 * Creates an instance
	 */
	ItemRegistry() {	
		addItems();
	}
	
	/**
	 * 
	 * @param itemIdentifier
	 * @return
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
	
	/**
	 * 
	 */
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
