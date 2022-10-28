package com.training.pms.galaxe.modal;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table(name="freshproducts")

@Data
public class Product {
	@Id
		int productid;
		String productname;
		int quantityOnHand;
		int price;
		
//		public Product() {
//			// TODO Auto-generated constructor stub
//		}
//
//		public Product(int productid, String productname, int quantityOnHand, int price) {
//			super();
//			this.productid = productid;
//			this.productname = productname;
//			this.quantityOnHand = quantityOnHand;
//			this.price = price;
//		}
//
//		public int getProductid() {
//			return productid;
//		}
//
//		public void setProductid(int productid) {
//			this.productid = productid;
//		}
//
//		public String getProductname() {
//			return productname;
//		}
//
//		public void setProductname(String productname) {
//			this.productname = productname;
//		}
//
//		public int getQuantityOnHand() {
//			return quantityOnHand;
//		}
//
//		public void setQuantityOnHand(int quantityOnHand) {
//			this.quantityOnHand = quantityOnHand;
//		}
//
//		public int getPrice() {
//			return price;
//		}
//
//		public void setPrice(int price) {
//			this.price = price;
//		}
//
//		@Override
//		public String toString() {
//			return "Product [productid=" + productid + ", productname=" + productname + ", quantityOnHand="
//					+ quantityOnHand + ", price=" + price + "]";
//		}
//		
}
