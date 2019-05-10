/**
 * 
 */
/**
 * @author Azizah
 *
 */
package com.packtpub.model;

public class Item {	

	private Integer itemid;
	public Integer getItemId() {
		return itemid;
	}
	public void setItemId(Integer itemid) {
		this.itemid = itemid;
	}
	
	private String itemname;
	public String getItemName() {
		return itemname;
	}
	public void setItemName(String itemname) {
		this.itemname = itemname;
	}

	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	private Integer price;
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	private Integer totalitem;
	public Integer getTotalItem() {
		return totalitem;
	}
	public void setTotalItem(Integer totalitem) {
		this.totalitem = totalitem;
	}
	
	public Item(Integer itemid, String itemname, String date, Integer price, Integer totalitem) {
		this.itemid = itemid;
		this.itemname = itemname;
		this.date = date;
		this.price = price;
		this.totalitem = totalitem;
	}
	
	
	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", itemname=" + itemname + ", date=" + date + ", price=" + price + ", totalitem=" + totalitem + "]";
	}
}