package tr.com.sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Configuration
public class GeneralConfigurer {

    /*Swagger url icin http://hostyadaip:port/swagger-ui/index.html*/
    @Bean
    public OpenAPI customOpenAPI(@Value("${app.description}") String description, @Value("${app.version}") String version) {
        return new OpenAPI()
                .info(new Info().title("InMemoryCache Sample, Rest API")
                        .version(version)
                        .description(description)
                        .license(new License().name("Apache 2.0 API License")));
    }

    @Bean
    public WebClient webClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:80")
//                .defaultCookie("cookie-name", "cookie-value")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
        return webClient;
    }

    /*Eger eski projeler icin kullanma ihtiyac olursa diye eklendi*/
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .build();
    }
}
