package kr.co.iminpush.service;

import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PushPeriodicNotifications {

    public static String PeriodicNotificationJson() throws JSONException {
        LocalDate localDate = LocalDate.now();
        String to = "fUnv4h10ykkvg3zHWnI8OD:APA91bGCAYWIi7CII34MFoBMGywK3jT0mf5gEv6PN6_c5g4x-vDsAdKXax11amMSZRcZHvzC0SdMPLIZChRc_PMfBDl5n6Mr0koydxKqHGI1u-3BoC5xhuz2K_PNOLNTS6yZMRSqZZSY";

        String sampleData[] = {"device token value 1", "device token value 2", "device token value 3"};
//        String sampleData[] = {};

        JSONObject jsonObject = new JSONObject();

        List<String> tokenList = new ArrayList<String>();

        for (int i = 0; i < sampleData.length; i++){
            tokenList.add(sampleData[i]);
        }

        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < tokenList.size(); i++) {
            jsonArray.put(tokenList.get(i));
        }

//        jsonObject.put("registration_ids", jsonArray);
        jsonObject.put("to", to);

        JSONObject notification = new JSONObject();


        notification.put("title", "hello!");
        notification.put("body", "Today is "+localDate.getDayOfWeek().name()+"!");
        jsonObject.put("notification", notification);

        System.out.println(jsonObject.toString());

        return jsonObject.toString();

    }

}
