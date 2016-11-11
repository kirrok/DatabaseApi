package ru.mail.park.java.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import ru.mail.park.models.Forum;
import ru.mail.park.models.Thread;
import ru.mail.park.models.User;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kirrok on 11.11.16.
 */
@JsonTest
@RunWith(SpringRunner.class)
public class ThreadTest extends AbstractModelTest {
    @Autowired
    private JacksonTester<Thread<?, ?>> jsonTester;

    private Thread<?, ?> thread;

    private void testSerialization() throws IOException {

        thread.setId(THREAD_ID);
        thread.setDislikes(THREAD_DISLIKES);
        thread.setLikes(THREAD_LIKES);
        thread.setPoints(THREAD_POINTS);
        thread.setPosts(THREAD_POSTS);
        thread.setIsDeleted(THREAD_IS_DELETED);

        assertThat(jsonTester.write(thread))
                .hasJsonPathNumberValue("id")
                .hasJsonPathNumberValue("dislikes")
                .hasJsonPathNumberValue("likes")
                .hasJsonPathNumberValue("points")
                .hasJsonPathNumberValue("posts")
                .hasJsonPathStringValue("message")
                .hasJsonPathStringValue("slug")
                .hasJsonPathStringValue("title")
                .hasJsonPathStringValue("date")
                .hasJsonPathBooleanValue("isClosed")
                .hasJsonPathBooleanValue("isDeleted");

        assertThat(jsonTester.write(thread)).extractingJsonPathNumberValue("id").isEqualTo(THREAD_ID);
        assertThat(jsonTester.write(thread)).extractingJsonPathNumberValue("dislikes").isEqualTo(THREAD_DISLIKES);
        assertThat(jsonTester.write(thread)).extractingJsonPathNumberValue("likes").isEqualTo(THREAD_LIKES);
        assertThat(jsonTester.write(thread)).extractingJsonPathNumberValue("points").isEqualTo(THREAD_POINTS);
        assertThat(jsonTester.write(thread)).extractingJsonPathNumberValue("posts").isEqualTo(THREAD_POSTS);
        assertThat(jsonTester.write(thread)).extractingJsonPathStringValue("message").isEqualTo(THREAD_MESSAGE);
        assertThat(jsonTester.write(thread)).extractingJsonPathStringValue("slug").isEqualTo(THREAD_SLUG);
        assertThat(jsonTester.write(thread)).extractingJsonPathStringValue("title").isEqualTo(THREAD_TITLE);
        assertThat(jsonTester.write(thread)).extractingJsonPathStringValue("date").isEqualTo(formatter.format(THREAD_DATE_OF_CREATION));
        assertThat(jsonTester.write(thread)).extractingJsonPathBooleanValue("isClosed").isEqualTo(THREAD_IS_CLOSED);
        assertThat(jsonTester.write(thread)).extractingJsonPathBooleanValue("isDeleted").isEqualTo(THREAD_IS_DELETED);
    }

    @Test
    public void testSerializeWithRelated() throws IOException {
        thread = new Thread<User, Forum>(THREAD_TITLE, THREAD_IS_CLOSED, THREAD_DATE_OF_CREATION,
                THREAD_MESSAGE, THREAD_SLUG, simpleForum, simpleUser);
        assertThat(jsonTester.write(thread))
                .hasJsonPathMapValue("forum")
                .hasJsonPathMapValue("user");
        testSerialization();
    }

    @Test
    public void testSerializationWithoutRelated() throws IOException {
        thread = new Thread<String, String>(THREAD_TITLE, THREAD_IS_CLOSED, THREAD_DATE_OF_CREATION,
                THREAD_MESSAGE, THREAD_SLUG, FORUM_SHORT_NAME, USER_EMAIL);
        assertThat(jsonTester.write(thread))
                .hasJsonPathStringValue("forum")
                .hasJsonPathStringValue("user");
        testSerialization();
        assertThat(jsonTester.write(thread)).extractingJsonPathStringValue("forum").isEqualTo(FORUM_SHORT_NAME);
        assertThat(jsonTester.write(thread)).extractingJsonPathStringValue("user").isEqualTo(USER_EMAIL);

    }
}
