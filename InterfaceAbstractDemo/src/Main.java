import java.time.LocalDate;

import abstracts.BaseCustomerManager;
import adapters.MernisServiceAdapter;
import concreate.CustomerCheckManager;
import concreate.NeroCustomerManager;
import concreate.StarbucksCustomerManager;
import entities.Customer;

public class Main {

	public static void main(String[] args) {
		
		
		//BaseCustomerManager customerManager = new NeroCustomerManager();
		//BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter()); -- real
		//BaseCustomerManager customerManager = new StarbucksCustomerManager(new CustomerCheckManager()); -- fake
		
		//BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		
		
		BaseCustomerManager customerManager = new NeroCustomerManager(new MernisServiceAdapter());
		
		customerManager.save(new Customer(1,"Abdurrahman","Karaoðlu",LocalDate.of(1111,1,11),"11111111111"));
		System.out.println();
	}

}
