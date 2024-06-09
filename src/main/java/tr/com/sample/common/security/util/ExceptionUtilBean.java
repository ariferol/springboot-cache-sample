package tr.com.sample.common.security.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tr.com.sample.common.security.model.request.LoginRequest;

@Component
@Slf4j
public class ExceptionUtilBean {

    private static WebClient webClient;
    private static final String EXCEPTION_SERVICE_BASE_URL = "http://localhost:80";

    @Autowired
    public ExceptionUtilBean(WebClient.Builder builder) {
        webClient = builder
                .baseUrl(EXCEPTION_SERVICE_BASE_URL)
                .build();
    }

    private static Mono<ResponseEntity> consumeRestService(WebClient webClient, String pathParam) {
        /*Consume edilecek servis reactive ise;*/
//        Flux<Object> recipientListStream2 = webClient.get().uri("/addlog")
//                .retrieve()
//                .bodyToFlux(Object.class);
//        /*reactive olarak gelen data mono ya ceviriliyor;*/
//        Mono<List<Object>> collectedRecipesStream = recipientListStream2.collectList();
//        List<Object> recipientList2 = collectedRecipesStream.block();
//
//        return recipientList;
//        return recipientList2;

        /*Consume edilecek servis reactive degil ise;*/
        LoginRequest sampleExceptionLogModel = new LoginRequest();
        Mono<ResponseEntity> responseEntityMono = webClient.post()
                .uri(pathParam)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(sampleExceptionLogModel), LoginRequest.class)
                .retrieve()
                .bodyToMono(ResponseEntity.class);
        return responseEntityMono;
    }

    public static int addExceptionLog(RuntimeException exception) {
        log.error(exception.getMessage(), exception);
        int exceptionId = 0;
        Mono<ResponseEntity> result = consumeRestService(webClient, "/addlog");
        return exceptionId;
    }
}
