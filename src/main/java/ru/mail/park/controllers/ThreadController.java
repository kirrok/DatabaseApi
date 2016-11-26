package ru.mail.park.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mail.park.dao.ThreadDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ThreadController {
    @Autowired
    private ThreadDAO threadDAO;

    @RequestMapping(path = "/db/api/thread/create", method = RequestMethod.POST)
    public CustomResponse create(@RequestBody String threadString) throws IOException {
        return threadDAO.create(threadString);
    }

    @RequestMapping(path = "/db/api/thread/details", method = RequestMethod.GET)
    public CustomResponse details(@RequestParam("thread") String threadId,
                                  @RequestParam(value = "related", required = false) List<String> related) throws IOException {
        if(related == null) {
            related = new ArrayList<>();
        }
        return threadDAO.details(threadId, related);
    }

    @RequestMapping(path = "/db/api/thread/close", method = RequestMethod.POST)
    public CustomResponse close(@RequestBody String threadString) throws IOException {
        return threadDAO.close(threadString);
    }

    @RequestMapping(path = "/db/api/thread/open", method = RequestMethod.POST)
    public CustomResponse open(@RequestBody String threadString) throws IOException {
        return threadDAO.open(threadString);
    }

    @RequestMapping(path = "/db/api/thread/list", method = RequestMethod.GET)
    public CustomResponse list(@RequestParam(value = "forum", required = false) String forumShortName,
                               @RequestParam(value = "user", required = false) String email,
                               @RequestParam(value = "since",required = false) String since,
                               @RequestParam(value = "limit",required = false) String limit,
                               @RequestParam(value = "order", required = false) String order) throws IOException {
        return threadDAO.list(forumShortName, email, since, limit, order);
    }

    @RequestMapping(path = "/db/api/thread/remove", method = RequestMethod.POST)
    public CustomResponse remove(@RequestBody String threadString) throws IOException {
        return threadDAO.remove(threadString);
    }

    @RequestMapping(path = "/db/api/thread/restore", method = RequestMethod.POST)
    public CustomResponse restore(@RequestBody String threadString) throws IOException {
        return threadDAO.restore(threadString);
    }

    @RequestMapping(path = "/db/api/thread/subscribe", method = RequestMethod.POST)
    public CustomResponse subscribe(@RequestBody String subscribeString) throws IOException {
        return threadDAO.subscribe(subscribeString);
    }

    @RequestMapping(path = "/db/api/thread/unsubscribe", method = RequestMethod.POST)
    public CustomResponse unsubscribe(@RequestBody String unsubscribeString) throws IOException {
        return threadDAO.unsubscribe(unsubscribeString);
    }

    @RequestMapping(path = "/db/api/thread/update", method = RequestMethod.POST)
    public CustomResponse update(@RequestBody String threadString) throws IOException {
        return threadDAO.update(threadString);
    }

    @RequestMapping(path = "/db/api/thread/vote", method = RequestMethod.POST)
    public CustomResponse vote(@RequestBody String voteString) throws IOException {
        return threadDAO.vote(voteString);
    }

    @RequestMapping(path = "/db/api/thread/listPosts", method = RequestMethod.GET)
    public CustomResponse listPosts(@RequestParam("thread") String threadId,
                                    @RequestParam(value = "sort", required = false) String sort,
                                    @RequestParam(value = "since",required = false) String since,
                                    @RequestParam(value = "limit",required = false) String limit,
                                    @RequestParam(value = "order",required = false) String order) throws IOException {
        return threadDAO.listPosts(threadId, sort, since, limit, order);
    }
}
