package com.mouritech.manytomanyexamp;
import java.time.LocalDate;

import com.mouritech.manytomanyexample.dao.ItemsDao;
import com.mouritech.manytomanyexample.dao.OrdersDao;
import com.mouritech.manytomanyexample.entity.Items;
import com.mouritech.manytomanyexample.entity.Orders;


public class ManyToManyExample {

	public static void main(String[] args) {
		// create employee
				Orders ord = new Orders();
				ord.setOrderId(555L);
				ord.setCustomerId(101L);
				
				ord.setOrderDOB(LocalDate.of(2011, 19, 24));
				
				Orders ord1 = new Orders();
				ord1.setOrderId(556L);
				ord1.setCustomerId(102L);
				
				ord1.setOrderDOB(LocalDate.of(2009, 10, 15));
				
				//create project
				Items item= new Items();
				item.setItemId(201L);
				item.setItemName("Apple");
				
				item.setItemDesc("Sweet Fruit");
				
				
				//create project
				Items item1= new Items();
				item1.setItemId(202L);
				item1.setItemName("Banana");
				
				item1.setItemDesc("Healthy Fruit");
				
				//allocation of projects for employee
				ord.getItems().add(item);
				ord1.getItems().add(item1);
				
				//adding employee reference in the projects
				item.getOrders().add(ord);
				item1.getOrders().add(ord1);
				
			OrdersDao odao = new OrdersDao();
				odao.saveOrders(ord);
				odao.saveOrders(ord1);
				
				
				ItemsDao idao = new ItemsDao();
				idao.saveItems(item);
				idao.saveItems(item1);
				

			}


	}
