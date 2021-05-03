package gamestore;

import java.time.LocalDate;
import adapters.MernisServiceAdapter;
import concrete.CampaignManager;
import concrete.GameManager;
import concrete.GamerManager;
import concrete.SalesManager;
import entities.Campaign;
import entities.Game;
import entities.Gamer;
import entities.Sales;

public class Main {

	public static void main(String[] args) {
		
		
		GameManager gameManager = new GameManager();
		Game game = new Game(1, "Farming Simulator 2019 – Platinum Edition", 130);
		
		gameManager.add(game);	
		gameManager.update(game);
		gameManager.delete(game);
		
		System.out.println("---------------");
		
		CampaignManager campaignManager = new CampaignManager();
		Campaign campaign = new Campaign(1, "Yaz Kampanyasi", 25, LocalDate.of(2021, 5, 5), LocalDate.of(2021, 10, 10));
		
		campaignManager.add(campaign);
		campaignManager.update(campaign);
		campaignManager.delete(campaign);
		
		System.out.println("---------------");
		
		GamerManager gamerManager = new GamerManager(new MernisServiceAdapter());
		Gamer gamer = new Gamer(1, "Abdurrahman", "Karaoðlu", LocalDate.of(1995, 5, 24), "11111111111",
				"a_karaoglu@hotmail.com", "deneme123");
		
		gamerManager.add(gamer);
		gamerManager.update(gamer);
		gamerManager.delete(gamer);
		
		System.out.println("---------------");

		SalesManager salesManager = new SalesManager();
		Sales sales = new Sales(4, 1, 1, 1, LocalDate.of(2021, 5, 3), game.getPrice());
		salesManager.buy(gamer, game, campaign);
		salesManager.add(sales,gamer, game, campaign);
		
		System.out.println("---------------");
		
	}

}
