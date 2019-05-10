package com.packtpub.service;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.packtpub.model.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Override
	public List<Item> getAllItems() {
		return ItemServiceImpl.items;
	}

	@Override
	public List<Item> getItemContain(String key) {		
		
		Predicate<Item> filterOne = x -> x.getItemName().toLowerCase().contains(key);
		 
        //filter2
//		Predicate<Item> filterTwo = x -> x.getUserid() > 100;
//		Predicate<User> filterTwo = ;
        
      //filter2
//        Predicate<Item> filterThree = x -> x.getUserid() < 103;
        
		return (List<Item>) items.stream()
		.filter(filterOne)
//		.filter(filterOne.and(filterTwo).and(filterThree))
//		.findAny()
//		.orElse(new User(0, "Not Available"))
		.collect(Collectors.toList());
	}
	
	@Override
	public List<Item> getItemPenjualan(String key) {		
		
		Predicate<Item> filterOne = x -> x.getItemName().toLowerCase().matches(key);
		 
        //filter2
//		Predicate<Item> filterTwo = x -> x.getUserid() > 100;
//		Predicate<User> filterTwo = ;
        
      //filter2
//        Predicate<Item> filterThree = x -> x.getUserid() < 103;
        
		return (List<Item>) items.stream()
		.filter(filterOne)
//		.filter(filterOne.and(filterTwo).and(filterThree))
//		.findAny()
//		.orElse(new User(0, "Not Available"))
		.collect(Collectors.toList());
	}
	
	@Override
	public List<Item> getItemPenjualanPerBulan(String key) {		
		
		
		Predicate<Item> filterOne = x -> x.getDate().toLowerCase().contains(new StringBuilder().append("-").append(key).append("-"));
		 
        //filter2
//		Predicate<Item> filterTwo = x -> x.getUserid() > 100;
//		Predicate<User> filterTwo = ;
        
      //filter2
//        Predicate<Item> filterThree = x -> x.getUserid() < 103;
        
		return (List<Item>) items.stream()
		.filter(filterOne)
//		.filter(filterOne.and(filterTwo).and(filterThree))
//		.findAny()
//		.orElse(new User(0, "Not Available"))
		.collect(Collectors.toList());
	}
	
	@Override
	public List<Item> getItemHarga(Integer min) {		
		
		Predicate<Item> filterOne = x -> x.getPrice() >= min;
		 
        //filter2
//		Predicate<Item> filterTwo = x -> x.getUserid() > 100;
//		Predicate<User> filterTwo = ;
        
      //filter2
//        Predicate<Item> filterThree = x -> x.getUserid() < 103;
        
		return (List<Item>) items.stream()
		.filter(filterOne)
//		.filter(filterOne.and(filterTwo).and(filterThree))
//		.findAny()
//		.orElse(new User(0, "Not Available"))
		.collect(Collectors.toList());
	}
	
	@Override
	public List<Item> getItemHargaMax(Integer min,Integer max) {		
		
		Predicate<Item> filterOne = x -> x.getPrice() >= min;
		 
        //filter2
		Predicate<Item> filterTwo = x -> x.getPrice() <= max;
//		Predicate<User> filterTwo = ;
        
      //filter2
//        Predicate<Item> filterThree = x -> x.getUserid() < 103;
        
		return (List<Item>) items.stream()
//		.filter(filterOne)
		.filter(filterOne.and(filterTwo))
//		.findAny()
//		.orElse(new User(0, "Not Available"))
		.collect(Collectors.toList());
	}
	
	@Override
	public List<Item> getItemTerjual(Integer min) {		
		
		Predicate<Item> filterOne = x -> x.getTotalItem() >= min;
		 
        //filter2
//		Predicate<Item> filterTwo = x -> x.getUserid() > 100;
//		Predicate<User> filterTwo = ;
        
      //filter2
//        Predicate<Item> filterThree = x -> x.getUserid() < 103;
        
		return (List<Item>) items.stream()
		.filter(filterOne)
//		.filter(filterOne.and(filterTwo).and(filterThree))
//		.findAny()
//		.orElse(new User(0, "Not Available"))
		.collect(Collectors.toList());
	}
	
	@Override
	public List<Item> getItemTerjualMax(Integer min,Integer max) {		
		
		Predicate<Item> filterOne = x -> x.getTotalItem() >= min;
		 
        //filter2
		Predicate<Item> filterTwo = x -> x.getTotalItem() <= max;
//		Predicate<User> filterTwo = ;
        
      //filter2
//        Predicate<Item> filterThree = x -> x.getUserid() < 103;
        
		return (List<Item>) items.stream()
//		.filter(filterOne)
		.filter(filterOne.and(filterTwo))
//		.findAny()
//		.orElse(new User(0, "Not Available"))
		.collect(Collectors.toList());
	}
	
	@Override
	public Item getItem(Integer itemid) {		
		return items.stream()
				.filter(x -> x.getItemId()  == itemid)
				.findAny()
				.orElse(new Item(0, "Not Available", "Not Available", 0, 0 ));		
	}
	
	@Override
	public void createItem(Integer itemid, String itemname, String date, Integer price, Integer totalitem) {
		Item item = new Item(itemid, itemname, date, price, totalitem);
		this.items.add(item);
	}

	@Override
	public void updateItem(Integer itemid, String itemname, String date, Integer price, Integer totalitem) {
		items.stream()
				.filter(x -> x.getItemId()  == itemid)
				.findAny()
				.orElseThrow(() -> new RuntimeException("Item not found"))
				.setItemName(itemname);		
	}
	
	@Override
	public void deleteItem(Integer itemid) {   
		
		items.removeIf((Item i) -> i.getItemId() == itemid);
		
	}

	// Dummy items
	public static List<Item> items;

	public ItemServiceImpl() {
		items = new LinkedList<>();
		items.add(new Item(1, "kentang", "17-05-2019", 5000, 10));
		items.add(new Item(2, "gula", "19-05-2019", 7000, 19));
		items.add(new Item(3, "kecap", "03-05-2019", 5600, 8));
		items.add(new Item(4, "garam", "22-05-2019", 3000, 2));
		items.add(new Item(5, "susu", "10-05-2019", 10000, 20));
		items.add(new Item(6, "beras", "01-05-2019", 12000, 4));
		items.add(new Item(7, "tepung", "11-05-2019", 5000, 22));
		items.add(new Item(8, "kopi", "12-05-2019", 8000, 19));
		items.add(new Item(9, "rokok", "03-05-2019", 13000, 1));
		items.add(new Item(10, "kacang", "10-05-2019", 2000, 3));
		items.add(new Item(11, "minyak", "13-05-2019", 12000, 30));
		items.add(new Item(12, "roti", "19-05-2019", 15000, 10));
		
		items.add(new Item(13, "kentang", "17-04-2019", 5000, 9));
		items.add(new Item(14, "gula", "19-04-2019", 7000, 13));
		items.add(new Item(15, "kecap", "03-04-2019", 5600, 13));
		items.add(new Item(16, "garam", "22-04-2019", 3000, 21));
		items.add(new Item(17, "susu", "10-04-2019", 10000, 41));
		items.add(new Item(18, "beras", "01-04-2019", 12000, 5));
		items.add(new Item(19, "tepung", "11-04-2019", 5000, 12));
		items.add(new Item(20, "kopi", "12-04-2019", 8000, 17));
		items.add(new Item(21, "rokok", "03-04-2019", 13000, 11));
		items.add(new Item(22, "kacang", "10-04-2019", 2000, 12));
		items.add(new Item(23, "minyak", "13-04-2019", 12000, 31));
		items.add(new Item(24, "roti", "19-04-2019", 15000, 18));
		
		items.add(new Item(25, "kentang", "17-03-2019", 5000, 19));
		items.add(new Item(26, "gula", "19-03-2019", 7000, 16));
		items.add(new Item(27, "kecap", "03-03-2019", 5600, 10));
		items.add(new Item(28, "garam", "22-03-2019", 3000, 31));
		items.add(new Item(29, "susu", "10-03-2019", 10000, 28));
		items.add(new Item(30, "beras", "01-03-2019", 12000, 14));
		items.add(new Item(31, "tepung", "11-03-2019", 5000, 9));
		items.add(new Item(32, "kopi", "12-03-2019", 8000, 16));
		items.add(new Item(33, "rokok", "03-03-2019", 13000, 21));
		items.add(new Item(34, "kacang", "10-03-2019", 2000, 16));
		items.add(new Item(35, "minyak", "13-03-2019", 12000, 35));
		items.add(new Item(36, "roti", "19-03-2019", 15000, 8));
	}

}