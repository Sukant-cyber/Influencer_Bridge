package influencer.bridge;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InfluencerBridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfluencerBridgeApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {return new ModelMapper();}

}
