package did.lemonaid.solution.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.Collections;


//@Configuration
public class RestTemplateConfig {

//    @Bean
//    public RestTemplate restTemplate() {
//
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//
//        HttpClient client = HttpClientBuilder.create().setMaxConnTotal(50)
//                .setMaxConnPerRoute(20).build();
//
//        factory.setHttpClient(client);
//        factory.setConnectTimeout(2000);
//        factory.setReadTimeout(5000);
//
//        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(factory));
//        restTemplate.setInterceptors(Collections.singletonList(new RestTemplateLoggingRequestInterceptor()));
//
//        return restTemplate;
//
//    }
}
