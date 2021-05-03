package abstracts;

import entities.Campaign;
import entities.Game;
import entities.Gamer;
import entities.Sales;

public interface ISalesService {
	void add(Sales sales,Gamer gamer, Game game, Campaign campaign);
	void buy(Gamer customer, Game game, Campaign campaign);
}
