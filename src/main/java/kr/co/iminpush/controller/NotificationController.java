package kr.co.iminpush.controller;


import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import kr.co.iminpush.service.PushNotificationService;
import kr.co.iminpush.service.PushPeriodicNotifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CompletableFuture;

@RestController
public class NotificationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PushNotificationService pushNotificationService;

//    @GetMapping(value = "/send")
//    public @ResponseBody ResponseEntity<String> send() throws JsonObject, InterruptedException  {
//        String notifications = PushPeriodicNotifications.PeriodicNotificationJson();
//
//        HttpEntity<String> request = new HttpEntity<>(notifications);
//
//        CompletableFuture<String> pushNotification = pushNotificationService.send(request);
//        CompletableFuture.allOf(pushNotification).join();
//
//        try{
//            String firebaseResponse = pushNotification.get();
//            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
//        }
//        catch (InterruptedException e){
//            logger.debug("got interrupted!");
//            throw new InterruptedException();
//        }
//        catch (ExecutionException e){
//            logger.debug("execution error!");
//        }
//
//        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
//    }

}