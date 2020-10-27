package kr.co.iminpush.service;

import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PushPeriodicNotifications {

    public static String PeriodicNotificationJson() throws JsonEOFException {
        LocalDate localDate = LocalDate.now();

        String sampleData[] = {"device token value 1", "device token value 2", "device token value 3"};

        JsonObject jsonObject = new JsonObject();

        List<String> tokenList = new ArrayList<String>();

        for (int i = 0; i < sampleData.length; i++){
            tokenList.add(sampleData[i]);
        }

        JsonArray jsonArray = new JsonArray();

        for (int i = 0; i < tokenList.size(); i++) {
            jsonArray.add(tokenList.get(i));
        }

        jsonObject.add("registration_ids", jsonArray);

        JsonObject notification = new JsonObject();

        notification.addProperty("title", "hello!");
        notification.addProperty("body", "Today is "+localDate.getDayOfWeek().name()+"!");
//        jsonObject.add(notification);
//        jsonObject.p

        System.out.println(jsonObject.toString());

        return jsonObject.toString();

    }

}
