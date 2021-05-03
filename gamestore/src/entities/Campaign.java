package entities;

import java.time.LocalDate;

public class Campaign {
	private int id;
	private String name;
	private double discount;
	private LocalDate campaignStartDate;
	private LocalDate campaignEndDate;

	public Campaign() {
		super();
	}

	public Campaign(int id, String name, double price, LocalDate campaignStartDate, LocalDate campaignEndDate) {
		super();
		this.id = id;
		this.name = name;
		this.discount = price;
		this.campaignStartDate = campaignStartDate;
		this.campaignEndDate = campaignEndDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double price) {
		this.discount = price;
	}

	public LocalDate getCampaignStartDate() {
		return campaignStartDate;
	}

	public void setCampaignStartDate(LocalDate campaignStartDate) {
		this.campaignStartDate = campaignStartDate;
	}

	public LocalDate getCampaignEndDate() {
		return campaignEndDate;
	}

	public void setCampaignEndDate(LocalDate campaignEndDate) {
		this.campaignEndDate = campaignEndDate;
	}

}
