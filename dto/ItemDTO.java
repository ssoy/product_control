package org.spring.item.dto;

public class ItemDTO {
	private String itemcode;
	private String itemname;
	private int price;
	private String bigo;
	private String regdate;
	public ItemDTO() {
		super();
	}
	public ItemDTO(String itemcode, String itemname, int price, String bigo, String regdate) {
		super();
		this.itemcode = itemcode;
		this.itemname = itemname;
		this.price = price;
		this.bigo = bigo;
		this.regdate = regdate;
	}
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBigo() {
		return bigo;
	}
	public void setBigo(String bigo) {
		this.bigo = bigo;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "ItemDTO [itemcode=" + itemcode + ", itemname=" + itemname + ", price=" + price + ", bigo=" + bigo
				+ ", regdate=" + regdate + "]";
	}
	
	
}
