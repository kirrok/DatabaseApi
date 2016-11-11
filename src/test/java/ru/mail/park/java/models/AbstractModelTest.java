package ru.mail.park.java.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import ru.mail.park.models.Forum;
import ru.mail.park.models.User;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kirrok on 11.11.16.
 */
public abstract class AbstractModelTest {
    @Autowired
    protected JacksonTester<Forum> jsonTester;

    protected static final String USER_USERNAME = "USERNAME";
    protected static final String USER_NAME = "NAME";
    protected static final String USER_EMAIL = "test@email.ru";
    protected static final String USER_ABOUT = "Some text about user.";
    protected static final int USER_ID = 3;
    protected static final boolean IS_ANONYMOUS = true;
    protected static final ArrayList<String> FOLLOWERS = new ArrayList<String>(Arrays.asList("fols1", "fols2", "fols3"));
    protected static final ArrayList<String> FOLLOWING = new ArrayList<String>(Arrays.asList("folg1", "folg2"));
    protected static final ArrayList<Integer> SUBSCRIPTIONS = new ArrayList<Integer>(Arrays.asList(4, 11));

    protected static final String FORUM_NAME = "FORUM_NAME";
    protected static final String FORUM_SHORT_NAME = "FORUM_SHORT_NAME";
    protected static final int FORUM_ID = 12;


    protected static User user;

    public AbstractModelTest() {
        user = new User(USER_USERNAME, USER_NAME, USER_EMAIL, USER_ABOUT, IS_ANONYMOUS);
        user.setId(USER_ID);
        user.setIsAnonumous(IS_ANONYMOUS);
        user.setFollowers(FOLLOWERS);
        user.setFollowing(FOLLOWING);
        user.setSubscriptions(SUBSCRIPTIONS);
    }

}
