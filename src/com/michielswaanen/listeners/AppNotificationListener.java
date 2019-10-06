package com.michielswaanen.listeners;

import com.michielswaanen.objects.FacebookUser;

public class AppNotificationListener  implements IEventListener {

    private FacebookUser user;

    public AppNotificationListener(FacebookUser user) {
        this.user = user;
    }

    @Override
    public void update(String eventType, String displayName, String url) {
        System.out.println(
                "App Notification >> Hey " + this.user.getFirstName() + ", " +
                        displayName + " posted new content: " + eventType + " >> " + url);
    }

}
