/**
 * 
 */
/**
 * @author Azizah
 *
 */
package com.packtpub.restapp.reportingservice;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.packtpub.service.ItemService;
import com.packtpub.model.Item;


@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService ItemService;

	@ResponseBody
	@RequestMapping("")
	public List<Item> getAllItems() {
		return ItemService.getAllItems();
	}

	@ResponseBody
	@RequestMapping("/{id}")
	public Item getItem(@PathVariable("id") Integer id) {
		return ItemService.getItem(id);
	}
	
	@ResponseBody
	@RequestMapping("/contain/{key}")
	public List<Item> getItemContain(@PathVariable("key") String key) {
		return ItemService.getItemContain(key);
	}
	
	@ResponseBody
	@RequestMapping("/penjualan_per_item/{key}")
	public List<Item> getItemPenjualan(@PathVariable("key") String key) {
		return ItemService.getItemPenjualan(key);
	}
	
	@ResponseBody
	@RequestMapping("/penjualan_per_bulan/{key}")
	public List<Item> getItemPenjualanPerBulan(@PathVariable("key") String key) {
		return ItemService.getItemPenjualanPerBulan(key);
	}
	
	@ResponseBody
	@RequestMapping("/harga/{min}")
	public List<Item> getItemHarga(@PathVariable("min") Integer min) {
		return ItemService.getItemHarga(min);
	}
	
	@ResponseBody
	@RequestMapping("/harga/{min}/{max}")
	public List<Item> getItemHargaMax(@PathVariable("min") Integer min,@PathVariable("max") Integer max) {
		return ItemService.getItemHargaMax(min,max);
	}
	
	@ResponseBody
	@RequestMapping("/barang_terjual/{min}")
	public List<Item> getItemTerjual(@PathVariable("min") Integer min) {
		return ItemService.getItemTerjual(min);
	}
	
	@ResponseBody
	@RequestMapping("/barang_terjual/{min}/{max}")
	public List<Item> getItemTerjualMax(@PathVariable("min") Integer min,@PathVariable("max") Integer max) {
		return ItemService.getItemTerjualMax(min,max);
	}
	

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Map<String, Object> createItem(@RequestParam(value = "itemid") Integer itemid,
			@RequestParam(value = "itemname") String itemname, @RequestParam(value = "date") String date,
			@RequestParam(value = "price") Integer price, @RequestParam(value = "totalitem") Integer totalitem ) {
		Map<String, Object> map = new LinkedHashMap<>();
		ItemService.createItem(itemid, itemname, date, price, totalitem);
		map.put("result", "added");
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Map<String, Object> updateItem(@RequestParam(value = "itemid") Integer itemid,
			@RequestParam(value = "itemname") String itemname, @RequestParam(value = "date") String date,
			@RequestParam(value = "price") Integer price, @RequestParam(value = "totalitem") Integer totalitem ) {
		Map<String, Object> map = new LinkedHashMap<>();
		ItemService.updateItem(itemid, itemname, date, price, totalitem);
		map.put("result", "updated");
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deleteItem(
			@PathVariable("id") Integer itemid) {
		Map<String, Object> map = new LinkedHashMap<>();   
	    ItemService.deleteItem(itemid);    
	    map.put("result", "deleted");
	    return map;
	}
}