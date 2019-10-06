package com.michielswaanen;

import com.michielswaanen.listeners.AppNotificationListener;
import com.michielswaanen.listeners.EmailNotificationListener;
import com.michielswaanen.objects.FollowType;
import com.michielswaanen.publisher.FacebookPage;
import com.michielswaanen.objects.FacebookUser;

/**
 * @author Michiel Swaanen
 */
public class Main {

    public static void main(String[] args) {

        // Initialization
        FacebookPage facebookPage = new FacebookPage("Coding Memes");

        FacebookUser john = new FacebookUser("John", "john@gmail.com");
        FacebookUser jane = new FacebookUser("Jane", "jane@gmail.com");

        // Observer Pattern

        // John
        AppNotificationListener johnAppNotification = new AppNotificationListener(john);

        facebookPage.follow(FollowType.VIDEO, johnAppNotification);
        facebookPage.follow(FollowType.LIVE_STREAM, johnAppNotification);
        facebookPage.follow(FollowType.ARTICLE, johnAppNotification);

        // Jane
        EmailNotificationListener janeEmailNotification = new EmailNotificationListener(jane);
        AppNotificationListener janeAppNotification = new AppNotificationListener(jane);

        facebookPage.follow(FollowType.VIDEO, janeEmailNotification);
        facebookPage.follow(FollowType.LIVE_STREAM, janeEmailNotification);
        facebookPage.follow(FollowType.LIVE_STREAM, janeAppNotification);

        // Notify
        facebookPage.startLiveStream("https://example.com/livestream");
        facebookPage.publishVideo("https://example.com/video");

        facebookPage.unfollow(FollowType.LIVE_STREAM, janeAppNotification);

        facebookPage.startLiveStream("https://example.com/other-livestream");
        facebookPage.publishArticle("https://example.com/article");
    }
}
