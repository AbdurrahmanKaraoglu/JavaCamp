package adapters;


import abstracts.ICustomerCheckService;
import entities.Customer;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

import java.rmi.RemoteException;

public class MernisServiceAdapter implements ICustomerCheckService {

	@Override
	public boolean CheckIfRealPerson(Customer customer) {

		KPSPublicSoapProxy client = new KPSPublicSoapProxy();


		try {
			return client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()),customer.getFirstName(),customer.getLastName(),customer.getDateOfBirth().getYear());
		} catch (RemoteException e) {
			e.printStackTrace();
		}


		return false;
	}

}
