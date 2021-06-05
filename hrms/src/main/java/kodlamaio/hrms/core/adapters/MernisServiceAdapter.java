package kodlamaio.hrms.core.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCheckService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
//import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements JobSeekerCheckService {

	@Override
	public boolean CheckIfRealJobSeeker(JobSeeker jobSeeker) {
		/*
		 * KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		 * 
		 * System.out.println("Burda1");
		 * 
		 * try { System.out.println("Burda11"); return
		 * client.TCKimlikNoDogrula(Long.parseLong(
		 * jobSeeker.getIdentificationNumber()), jobSeeker.getFirstName().toUpperCase()
		 * , jobSeeker.getLastName().toUpperCase(), jobSeeker.getDateOfBirth()); } catch
		 * (RemoteException e) { System.out.println("Burda2"); e.printStackTrace(); }
		 * 
		 * return false;
		 */
		return true;
	}

}