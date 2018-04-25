package io.nothanks.nothanks;

import io.nothanks.nothanks.api.RestApiClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SpringBootApplication
public class NothanksApplication {

	public static void main(String[] args) {
		SpringApplication.run(NothanksApplication.class, args);
	}

	@Bean
	public RestApiClient restApiClient() {
		return new Retrofit.Builder()
				.baseUrl("http://localhost:8080")
				.addConverterFactory(GsonConverterFactory.create())
				.build().create(RestApiClient.class);
	}
}
