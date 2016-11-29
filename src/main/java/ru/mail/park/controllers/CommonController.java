package ru.mail.park.controllers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.park.dao.ForumDAO;
import ru.mail.park.dao.PostDAO;
import ru.mail.park.dao.ThreadDAO;
import ru.mail.park.dao.UserDAO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("OverlyBroadThrowsClause")
@RestController
public class CommonController {
    private final UserDAO userDAO;
    private final ForumDAO forumDAO;
    private final ThreadDAO threadDAO;
    private final PostDAO postDAO;

    private static final Logger LOGGER = LogManager.getLogger("COMMON");
    @Autowired
    public CommonController(UserDAO userDAO, ForumDAO forumDAO, ThreadDAO threadDAO, PostDAO postDAO) {
        this.userDAO = userDAO;
        this.forumDAO = forumDAO;
        this.threadDAO = threadDAO;
        this.postDAO = postDAO;
    }

    @RequestMapping(path = "/db/api/clear", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public CustomResponse clear() throws IOException {
        userDAO.truncateTable();
        forumDAO.truncateTable();
        threadDAO.truncateTable();
        postDAO.truncateTable();

        LOGGER.info("clear");
        return new CustomResponse("OK", CustomResponse.OK);
    }

    @RequestMapping(path = "/db/api/status", method = RequestMethod.GET)
    public CustomResponse status() throws IOException {
        final Map<String, Integer> responseBody = new HashMap<>();
        responseBody.put("user", userDAO.count());
        responseBody.put("thread", threadDAO.count());
        responseBody.put("forum", forumDAO.count());
        responseBody.put("post", postDAO.count());

        LOGGER.info("status");
        return new CustomResponse(responseBody, CustomResponse.OK);
    }
}