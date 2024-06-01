package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Items {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String itemname;
	private double price;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "model_item", joinColumns =@JoinColumn(name= "iid"), inverseJoinColumns = @JoinColumn(name="mid"))
	private List<MyModel> model;

	
    public List<MyModel> getModel() {
		return model;
	}
	public void setModel(List<MyModel> model) {
		this.model = model;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemname=" + itemname + ", price=" + price + "]";
	}
	

}
