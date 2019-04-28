package retailstore.integration;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author User
 *
 */
public class ItemRegistry {
	
	private List<ItemDTO> items = new ArrayList<>();
	
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
		for(int i = 0; i < items.size(); i++) {
			ItemDTO item = (ItemDTO) items.get(i);
			if(itemIdentifier.equals(item.itemIdentifier))
				break;
		}
		
		return item;
	}
	
	/**
	 * 
	 */
	private void addItems() {
		ItemIdentifierDTO itemIdentifierCorn = new ItemIdentifierDTO("0123456789");
		ItemIdentifierDTO itemIdentifierBread = new ItemIdentifierDTO("1231231231");
		ItemIdentifierDTO itemIdentifierChips = new ItemIdentifierDTO("5555555555");
		
		items.add(new ItemDTO(15, 0.25, "corn", itemIdentifierCorn));
		items.add(new ItemDTO(20, 0.2, "bread", itemIdentifierBread));
		items.add(new ItemDTO(25, 0.3, "chips", itemIdentifierChips));
	}
	

}
