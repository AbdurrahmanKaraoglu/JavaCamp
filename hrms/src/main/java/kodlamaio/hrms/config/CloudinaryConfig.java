package kodlamaio.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.utilities.cloudinary.CloudinaryManager;
import kodlamaio.hrms.core.utilities.cloudinary.CloudinaryService;

@Configuration
public class CloudinaryConfig {
		
	 	@Bean
	    public Cloudinary cloudinaryUser(){
	        return new Cloudinary(ObjectUtils.asMap(
	                "cloud_name", "abdurrahmankaraoglu11",
	                "api_key", "845763199661878",
	                "api_secret", "EZIGeycALnj8hzLS0x2otfdnE0U"));
	    }

	    @Bean
	    public CloudinaryService cloudinaryService(){
	        return new CloudinaryManager(cloudinaryUser());
	    }

}