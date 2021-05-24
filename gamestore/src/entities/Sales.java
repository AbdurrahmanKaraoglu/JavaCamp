package entities;

import java.time.LocalDate;

public class Sales {
	private int salesId;
	private int gameId;
	private int gamerId;
	private int campaignId;
	private LocalDate saleDate;
	private double price;

	public Sales() {
		super();
	}

	public Sales(int id, int gameId, int gamerId, int campaignId, LocalDate saleDate, double price) {
		super();
		this.salesId = id;
		this.gameId = gameId;
		this.gamerId = gamerId;
		this.campaignId = campaignId;
		this.saleDate = saleDate;
		this.price = price;
	}

	public int getsalesId() {
		return salesId;
	}

	public void setsalesId(int id) {
		this.salesId = id;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getGamerId() {
		return gamerId;
	}

	public void setGamerId(int gamerId) {
		this.gamerId = gamerId;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
