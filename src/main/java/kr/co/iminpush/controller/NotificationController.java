package kr.co.iminpush.controller;


import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import kr.co.iminpush.service.PushNotificationService;
import kr.co.iminpush.service.PushPeriodicNotifications;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class NotificationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PushNotificationService pushNotificationService;

    @RequestMapping(value = "/")
    public String main() {
        logger.trace("Trace Level 테스트");
        logger.debug("DEBUG Level 테스트");
        logger.info("INFO Level 테스트");
        logger.warn("Warn Level 테스트");
        logger.error("ERROR Level 테스트");
        System.out.println("/jsp잘 타는지222?");
        return "index";
    }

//    @RequestMapping(value = "/notification")
//    public String notfication() {
//        return "notification.html";
//    }

//    @RequestMapping(value = "/test")
//    public String contentView(Model model) {
//        model.addAttribute("value", "hi");
//        return "test.html";
//    }


    @RequestMapping("/test")
    public ModelAndView test() throws Exception{
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("name", "TEST");

        List<String> testList = new ArrayList<String>();
        testList.add("a");
        testList.add("b");
        testList.add("c");
        System.out.println("/jsp잘 타는지?");
        mav.addObject("list", testList);
        return mav;
    }


    @GetMapping(value = "/send")
    public @ResponseBody
    ResponseEntity<String> send() throws JSONException, InterruptedException {
        String notifications = PushPeriodicNotifications.PeriodicNotificationJson();

        HttpEntity<String> request = new HttpEntity<>(notifications);

        CompletableFuture<String> pushNotification = pushNotificationService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();
            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        } catch (InterruptedException e) {
            logger.debug("got interrupted!");
            throw new InterruptedException();
        } catch (ExecutionException e) {
            logger.debug("execution error!");
        }

        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
    }

}
