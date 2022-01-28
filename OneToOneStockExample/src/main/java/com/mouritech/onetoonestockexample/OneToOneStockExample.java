package com.mouritech.onetoonestockexample;

import com.mouritech.onetoonestockexample.dao.StockDao;
import com.mouritech.onetoonestockexample.model.Stock;
import com.mouritech.onetoonestockexample.model.Stock_Details;
public class OneToOneStockExample {

	public static void main(String[] args) {
		
		Stock stk = new Stock(1L, 100L, "SBI");
		Stock_Details stkdetails = new Stock_Details( "Google", "GoodCompany", "Good", "20/03/1998");
		stk.setStockDetails(stkdetails);
		
	StockDao stkDao = new StockDao();
		stkDao.saveStock(stk);

	}

}
