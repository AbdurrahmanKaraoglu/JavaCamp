package concrete;

import abstracts.IGamerCheckService;
import abstracts.IGamerService;
import entities.Gamer;

public class GamerManager implements IGamerService{
	
	private IGamerCheckService gamerCheckService;
	

	public GamerManager(IGamerCheckService gamerCheckService) {
		super();
		this.gamerCheckService = gamerCheckService;
	}

	@Override
	public void add(Gamer gamer) {
		
		if (gamerCheckService.CheckIfRealPerson(gamer)) {
			System.out.println(gamer.getFirstName() + " isimli oyuncu eklendi.");
		} else {
			System.out.println(gamer.getFirstName() + " isimli oyuncu eklenemedi!!!.");
			gamer.setFirstName(null);
			gamer.setLastName(null);
		}
		
	}

	@Override
	public void update(Gamer gamer) {
		System.out.println(gamer.getFirstName() + " isimli oyuncu guncellendi.");
	}

	@Override
	public void delete(Gamer gamer) {
		System.out.println(gamer.getFirstName() + " isimli oyuncu silindi.");
	}

}
