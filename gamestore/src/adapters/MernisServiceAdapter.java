package adapters;

import java.rmi.RemoteException;

import abstracts.IGamerCheckService;
import entities.Gamer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements IGamerCheckService {

	@Override
	public boolean CheckIfRealPerson(Gamer gamer) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();

		try {
			return client.TCKimlikNoDogrula(Long.parseLong(gamer.getNationalityId()), gamer.getFirstName().toUpperCase(),
					gamer.getLastName().toUpperCase(), gamer.getDateOfBirth().getYear());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

}
