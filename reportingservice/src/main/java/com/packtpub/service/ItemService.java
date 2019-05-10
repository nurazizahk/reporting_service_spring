/**
 * 
 */
/**
 * @author Azizah
 *
 */
package com.packtpub.service;

import java.util.List;

import com.packtpub.model.Item;

public interface ItemService {

	List<Item> getAllItems();

	Item getItem(Integer itemid);
	
	void createItem(Integer itemid, String itemname, String date, Integer price, Integer totalitem);
	
	void updateItem(Integer itemid, String itemname, String date, Integer price, Integer totalitem);
	
	void deleteItem(Integer itemid);
	
	List<Item> getItemContain(String key);
	
	List<Item> getItemPenjualan(String key);
	
	List<Item> getItemPenjualanPerBulan(String key);
	
	List<Item> getItemHarga(Integer min);
	
	List<Item> getItemHargaMax(Integer min,Integer max);
	
	List<Item> getItemTerjual(Integer min);
	
	List<Item> getItemTerjualMax(Integer min,Integer max);
}