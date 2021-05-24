package concrete;

import abstracts.IGameService;
import entities.Game;

public class GameManager implements IGameService{

	@Override
	public void add(Game game) {
		System.out.println(game.getName() + " isimli oyun eklendi.");
	}

	@Override
	public void update(Game game) {
		System.out.println(game.getName() + " isimli oyun guncellendi.");
	}

	@Override
	public void delete(Game game) {
		System.out.println(game.getName() + " isimli oyun silindi.");
	}

}
