package ru.mail.park.controllers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mail.park.dao.ForumDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("OverlyBroadThrowsClause")
@RestController()
public class ForumController {
    private final ForumDAO forumDAO;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    public ForumController(ForumDAO forumDAO) {
        this.forumDAO = forumDAO;
    }


    @RequestMapping(path = "/db/api/forum/create", method = RequestMethod.POST)
    public CustomResponse create(@RequestBody String body) throws IOException {
        CustomResponse cr = forumDAO.create(body);
        if (cr.getCode() != 0 ){
            logger.warn("path: \"/db/api/forum/create\", body: " + body);
        }
        return cr;
    }

    @RequestMapping(path = "/db/api/forum/details", method = RequestMethod.GET)
    public CustomResponse details(@RequestParam("forum") String forumShortName,
                                  @RequestParam(value = "related",required = false) List<String> related) {
        if (related == null) {
            related = new ArrayList<>();
        }
        CustomResponse cr = forumDAO.details(forumShortName, related);
        if (cr.getCode() != 0 ){
            logger.warn("path: \"/db/api/forum/details\", body: " + forumShortName + " " + related);
        }

        return cr;
    }

    @RequestMapping(path = "/db/api/forum/listPosts", method = RequestMethod.GET)
    public CustomResponse listPosts(@RequestParam("forum") String forumShortName,
                                    @RequestParam(value = "related",required = false) List<String> related,
                                    @RequestParam(value = "since",required = false) String since,
                                    @RequestParam(value = "limit",required = false) String limit,
                                    @RequestParam(value = "order",required = false) String order) {
        if (related == null) {
            related = new ArrayList<>();
        }
        return forumDAO.listPosts(forumShortName, related, since, limit, order);
    }

    @RequestMapping(path = "/db/api/forum/listThreads", method = RequestMethod.GET)
    public CustomResponse listThreads(@RequestParam("forum") String forumShortName,
                                      @RequestParam(value = "related",required = false) List<String> related,
                                      @RequestParam(value = "since",required = false) String since,
                                      @RequestParam(value = "limit", required = false) String limit,
                                      @RequestParam(value = "order",required = false) String order) {
        if (related == null) {
            related = new ArrayList<>();
        }
        return forumDAO.listThreads(forumShortName, related, since, limit, order);

    }

    @RequestMapping(path = "/db/api/forum/listUsers", method = RequestMethod.GET)
    public CustomResponse listUsers(@RequestParam("forum") String forumShortName,
                                    @RequestParam(value = "since_id",required = false) String since_id,
                                    @RequestParam(value = "limit",required = false) String limit,
                                    @RequestParam(value = "order",required = false) String order) {
        return forumDAO.listUsers(forumShortName, since_id, limit, order);

    }
}
