package concrete;

import abstracts.ISalesService;
import entities.Campaign;
import entities.Game;
import entities.Gamer;
import entities.Sales;

public class SalesManager implements ISalesService {

	@Override
	public void add(Sales sales, Gamer gamer, Game game, Campaign campaign) {
		System.out.println(sales.getsalesId() + " id li sipariþ eklendi.");
	}

	@Override
	public void buy(Gamer gamer, Game game, Campaign campaign) {
		System.out
				.println(gamer.getFirstName() + " " + gamer.getLastName() + " isimli oyuncu, " + game.getName()
						+ " oyununu " + (campaign.getName() + " ile %" + campaign.getDiscount()
								+ " indirimle " + game.getPrice() * (100 - campaign.getDiscount()) / 100)
						+ " tl ye satin aldi.");
		
	}

}
