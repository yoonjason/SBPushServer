package kr.co.iminpush.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class PushNotificationService {
    private static final String firebase_server_key = "AAAAmadRGjU:APA91bG_EDxc-p-gXaqvRHNch6YRWJZQF0UBhyyL779QxvGX3OON9In6Jx-n7DoD8rNlHPjGtvldjAnl-FIP6R-43JpndCCvrx1SqfHv17RzLWuPf8b8-npkczJVsKqR0VKZBI9LWVWj";
    private static final String firebase_api_url = "https://fcm.googleapis.com/fcm/send";

//    @Async
    public CompletableFuture<String > send(HttpEntity<String> entity){

        RestTemplate restTemplate = new RestTemplate();

        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Authorization", "key="+firebase_server_key));
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));

        restTemplate.setInterceptors(interceptors);

        String firebaseResponse = restTemplate.postForObject(firebase_api_url, entity, String.class);



        return CompletableFuture.completedFuture(firebaseResponse);
    }

}
