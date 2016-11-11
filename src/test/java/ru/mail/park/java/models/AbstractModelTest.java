package ru.mail.park.java.models;

import org.springframework.boot.test.context.SpringBootTest;
import ru.mail.park.models.Forum;
import ru.mail.park.models.Thread;
import ru.mail.park.models.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by kirrok on 11.11.16.
 */
@SpringBootTest
public abstract class AbstractModelTest {

    protected static final String USER_USERNAME = "Test usernama";
    protected static final String USER_NAME = "Test name";
    protected static final String USER_EMAIL = "test@email.ru";
    protected static final String USER_ABOUT = "Some text about simpleUser.";
    protected static final int USER_ID = 3;
    protected static final boolean IS_ANONYMOUS = false;
    protected static final ArrayList<String> FOLLOWERS = new ArrayList<String>(Arrays.asList("fols1", "fols2", "fols3"));
    protected static final ArrayList<String> FOLLOWING = new ArrayList<String>(Arrays.asList("folg1", "folg2"));
    protected static final ArrayList<Integer> SUBSCRIPTIONS = new ArrayList<Integer>(Arrays.asList(4, 11));

    protected static final String FORUM_NAME = "Test forum name";
    protected static final String FORUM_SHORT_NAME = "Test forum short name";
    protected static final int FORUM_ID = 12;

    protected static final String THREAD_TITLE = "Test thread title";
    protected static final boolean THREAD_IS_CLOSED = true;
    protected static final boolean THREAD_IS_DELETED = false;
    protected static final Date THREAD_DATE_OF_CREATION = new Date();
    protected static final String THREAD_MESSAGE = "Test thread message";
    protected static final String THREAD_SLUG = "Test thread slug";
    protected static final int THREAD_ID = 73;
    protected static final int THREAD_DISLIKES = 3;
    protected static final int THREAD_LIKES = 5;
    protected static final int THREAD_POINTS = 2;
    protected static final int THREAD_POSTS = 4;


    protected static final Date POST_DATE_OF_CREATION = new Date();
    protected static final String POST_MESSAGE = "Test post message";
    protected static final int POST_DISLIKES = 3;
    protected static final int POST_LIKES = 7;
    protected static final int POST_POINTS = 4;
    protected static final Integer POST_PARENT = 11;
    protected static final int POST_ID = 12;
    protected static final boolean POST_IS_DELETED = false;
    protected static final boolean POST_IS_APPROVED = true;
    protected static final boolean POST_IS_EDITED = false;
    protected static final boolean POST_IS_HIGHLIGHTED = true;
    protected static final boolean POST_IS_SPAM = false;

    protected static User simpleUser;
    protected static Forum<String> simpleForum;
    protected static Thread<String, String> simpleThread;

    protected SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public AbstractModelTest() {
        simpleUser = new User(USER_USERNAME, USER_NAME, USER_EMAIL, USER_ABOUT, IS_ANONYMOUS);
        simpleUser.setId(USER_ID);
        simpleUser.setIsAnonumous(IS_ANONYMOUS);
        simpleUser.setFollowers(FOLLOWERS);
        simpleUser.setFollowing(FOLLOWING);
        simpleUser.setSubscriptions(SUBSCRIPTIONS);

        simpleForum = new Forum<String>(FORUM_NAME, FORUM_SHORT_NAME, USER_EMAIL);
        simpleForum.setId(FORUM_ID);

        simpleThread = new Thread<String, String>(THREAD_TITLE, THREAD_IS_CLOSED, THREAD_DATE_OF_CREATION, THREAD_MESSAGE,
                THREAD_SLUG, FORUM_SHORT_NAME, USER_EMAIL);
        simpleThread.setId(THREAD_ID);
        simpleThread.setPoints(THREAD_POINTS);
        simpleThread.setPosts(THREAD_POSTS);
        simpleThread.setDislikes(THREAD_DISLIKES);
        simpleThread.setLikes(THREAD_LIKES);
        simpleThread.setIsDeleted(THREAD_IS_DELETED);
    }

}
