package com.barath.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class HashTagController {

    private static final Logger logger= LoggerFactory.getLogger(HashTagController.class);

        private String GRAPH_URL="https://graph.facebook.com/search?q=%23";

        private RestTemplate restTemplate;

        private Facebook facebook;

        public HashTagController(Facebook facebook,RestTemplate restTemplate){
            this.restTemplate=restTemplate;
            this.facebook=facebook;
        }


        @GetMapping(value = "/search")
        public List<String> getFeedsByHashTag(@RequestParam String hashTag){
            String baseGraphUrl=facebook.getBaseGraphApiUrl();
            System.out.println("Get GRAPH BASE URL "+baseGraphUrl);
            System.out.println("Hash tag to search for "+hashTag);


            return new ArrayList<>();

        }
}
