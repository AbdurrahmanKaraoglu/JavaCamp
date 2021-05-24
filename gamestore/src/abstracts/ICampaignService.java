package abstracts;

import entities.Campaign;

public interface ICampaignService {
	void add(Campaign campaign);
	void update(Campaign campaign);
	void delete(Campaign campaign);
}
