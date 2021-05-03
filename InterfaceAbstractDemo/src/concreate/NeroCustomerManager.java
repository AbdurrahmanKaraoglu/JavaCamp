package concreate;

import abstracts.BaseCustomerManager;
import abstracts.ICustomerCheckService;
import entities.Customer;

public class NeroCustomerManager extends BaseCustomerManager {
	private ICustomerCheckService customerCheckService;

	public NeroCustomerManager(ICustomerCheckService customerCheckService) {
		super();
		this.customerCheckService = customerCheckService;
	}
	@Override
	public void save(Customer customer) {
		if (customerCheckService.CheckIfRealPerson(customer)) {
			super.save(customer);
		} else {
			System.out.println("Not a valid person");
		}
	}

}
