package ru.mail.park.java.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import ru.mail.park.models.User;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kirrok on 11.11.16.
 */
@JsonTest
@RunWith(SpringRunner.class)

public class UserTest extends AbstractModelTest {

    @Autowired
    private JacksonTester<User> jsonTester;

    @Test
    public void testSerialize() throws IOException {
        assertThat(jsonTester.write(simpleUser))
                .hasJsonPathNumberValue("id")
                .hasJsonPathStringValue("about")
                .hasJsonPathStringValue("email")
                .hasJsonPathStringValue("name")
                .hasJsonPathStringValue("username")
                .hasJsonPathBooleanValue("isAnonymous")
                .hasJsonPathArrayValue("followers")
                .hasJsonPathArrayValue("following")
                .hasJsonPathArrayValue("subscriptions");

        assertThat(jsonTester.write(simpleUser)).extractingJsonPathNumberValue("id", USER_ID);
        assertThat(jsonTester.write(simpleUser)).extractingJsonPathStringValue("about", USER_ABOUT);
        assertThat(jsonTester.write(simpleUser)).extractingJsonPathStringValue("email", USER_EMAIL);
        assertThat(jsonTester.write(simpleUser)).extractingJsonPathStringValue("name", USER_NAME);
        assertThat(jsonTester.write(simpleUser)).extractingJsonPathStringValue("username", USER_USERNAME);
        assertThat(jsonTester.write(simpleUser)).extractingJsonPathBooleanValue("isAnonymous", IS_ANONYMOUS);
        assertThat(jsonTester.write(simpleUser)).extractingJsonPathArrayValue("followers", FOLLOWERS);
        assertThat(jsonTester.write(simpleUser)).extractingJsonPathArrayValue("following", FOLLOWING);
        assertThat(jsonTester.write(simpleUser)).extractingJsonPathArrayValue("subscriptions", SUBSCRIPTIONS);

    }
}
