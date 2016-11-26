package ru.mail.park.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mail.park.dao.PostDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("OverlyBroadThrowsClause")
@RestController
public class PostController {
    @Autowired
    private PostDAO postDAO;


    @RequestMapping(path = "/db/api/post/create", method = RequestMethod.POST)
    public CustomResponse create(@RequestBody String body) throws IOException {
        return postDAO.create(body);
    }

    @RequestMapping(path = "/db/api/post/details", method = RequestMethod.GET)
    public CustomResponse details(@RequestParam("post") String postId,
                                  @RequestParam(value = "related", required = false) List<String> related) {
        if(related == null) {
            related = new ArrayList<>();
        }
        return postDAO.details(postId, related);
    }

    @RequestMapping(path = "/db/api/post/list", method = RequestMethod.GET)
    public CustomResponse list(@RequestParam(value = "forum", required = false) String forumShortName,
                               @RequestParam(value = "thread", required = false) String threadId,
                               @RequestParam(value = "since", required = false) String since,
                               @RequestParam(value = "limit", required = false) String limit,
                               @RequestParam(value = "order", required = false) String order) {
        return postDAO.list(forumShortName, threadId, since, limit, order);
    }

    @RequestMapping(path = "/db/api/post/remove", method = RequestMethod.POST)
    public CustomResponse remove(@RequestBody String postString) throws IOException {
        return postDAO.removeOrRestore(postString, "remove");
    }

    @RequestMapping(path = "/db/api/post/restore", method = RequestMethod.POST)
    public CustomResponse restore(@RequestBody String postString) throws IOException {
        return postDAO.removeOrRestore(postString, "restore");

    }

    @RequestMapping(path = "/db/api/post/vote", method = RequestMethod.POST)
    public CustomResponse vote(@RequestBody String voteString) throws IOException {
        return postDAO.vote(voteString);

    }

    @RequestMapping(path = "/db/api/post/update", method = RequestMethod.POST)
    public CustomResponse update(@RequestBody String postString) throws IOException {
        return postDAO.update(postString);
    }

}


