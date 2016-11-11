package ru.mail.park.java.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import ru.mail.park.models.Forum;
import ru.mail.park.models.User;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kirrok on 11.11.16.
 */
@JsonTest
@RunWith(SpringRunner.class)
public class ForumTest extends AbstractModelTest {
    @Autowired
    protected JacksonTester<Forum<?>> jsonTester;

    private Forum<?> forum;

    private void testSerialization() throws IOException {
        assertThat(jsonTester.write(forum)).hasJsonPathNumberValue("id")
                .hasJsonPathStringValue("name")
                .hasJsonPathStringValue("short_name");

        assertThat(jsonTester.write(forum)).extractingJsonPathNumberValue("id").isEqualTo(FORUM_ID);
        assertThat(jsonTester.write(forum)).extractingJsonPathStringValue("name").isEqualTo(FORUM_NAME);
        assertThat(jsonTester.write(forum)).extractingJsonPathStringValue("short_name").isEqualTo(FORUM_SHORT_NAME);

    }

    @Test
    public void testSerializeWithRelated() throws IOException {
        forum = new Forum<User>(FORUM_NAME, FORUM_SHORT_NAME, simpleUser);
        forum.setId(FORUM_ID);

        testSerialization();

        assertThat(jsonTester.write(forum)).hasJsonPathMapValue("user");

        assertThat(jsonTester.write(forum)).extractingJsonPathMapValue("user")
                .containsEntry("about", USER_ABOUT)
                .containsEntry("email", USER_EMAIL)
                .containsEntry("name", USER_NAME)
                .containsEntry("username", USER_USERNAME)
                .containsEntry("id", USER_ID)
                .containsEntry("isAnonymous", IS_ANONYMOUS)
                .containsEntry("following", FOLLOWING)
                .containsEntry("followers", FOLLOWERS)
                .containsEntry("subscriptions", SUBSCRIPTIONS);
    }


    @Test
    public void testSerializeWithoutRelated() throws IOException {
        final String userEmail = "email@mail.ru";
        forum = new Forum<String>(FORUM_NAME, FORUM_SHORT_NAME, userEmail);
        forum.setId(FORUM_ID);

        testSerialization();

        assertThat(jsonTester.write(forum)).hasJsonPathStringValue("user");

        assertThat(jsonTester.write(forum)).extractingJsonPathStringValue("user").isEqualTo(userEmail);

    }

}
