package ru.mail.park.java.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import ru.mail.park.models.Forum;
import ru.mail.park.models.Post;
import ru.mail.park.models.Thread;
import ru.mail.park.models.User;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by kirrok on 11.11.16.
 */
@JsonTest
@RunWith(SpringRunner.class)
public class PostTest extends AbstractModelTest {


    @Autowired
    private JacksonTester<Post<?, ?, ?>> jsonTester;

    private Post<?, ?, ?> post;

    @Test
    public void testSerializationWithRelated() throws IOException {
        post = new Post<User, Thread<String, String>, Forum<String>>(POST_DATE_OF_CREATION, simpleThread,
                simpleForum, simpleUser, POST_MESSAGE);
        post.setId(POST_ID);
        post.setDislikes(POST_DISLIKES);
        post.setLikes(POST_LIKES);
        post.setPoints(POST_POINTS);
        post.setApproved(POST_IS_APPROVED);
        post.setDeleted(POST_IS_DELETED);
        post.setEdited(POST_IS_EDITED);
        post.setHighlighted(POST_IS_HIGHLIGHTED);
        post.setSpam(POST_IS_SPAM);
        post.setParent(POST_PARENT);

        assertThat(jsonTester.write(post))
                .hasJsonPathNumberValue("id")
                .hasJsonPathNumberValue("parent")
                .hasJsonPathNumberValue("likes")
                .hasJsonPathNumberValue("dislikes")
                .hasJsonPathNumberValue("points")
                .hasJsonPathBooleanValue("isApproved")
                .hasJsonPathBooleanValue("isEdited")
                .hasJsonPathBooleanValue("isDeleted")
                .hasJsonPathBooleanValue("isHighlighted")
                .hasJsonPathBooleanValue("isSpam")
                .hasJsonPathStringValue("message")
                .hasJsonPathStringValue("date")
                .hasJsonPathMapValue("forum")
                .hasJsonPathMapValue("thread")
                .hasJsonPathMapValue("user");
    }
}
