package com.barath.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

@Configuration
public class RestConfiguration {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
               if(response.getStatusCode().is2xxSuccessful()){
                   return false;
               }

               return true;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                logger.error(" Rest client has error {}",response.getBody().toString());
            }
        });

        return restTemplate;
    }
}
