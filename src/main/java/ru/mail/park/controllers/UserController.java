package ru.mail.park.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mail.park.dao.UserDAO;


@RestController
public class UserController {
    private final UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(path = "/db/api/user/details", method = RequestMethod.GET)
    public CustomResponse details(@RequestParam("user") String email) {
        return userDAO.details(email);
    }

    @RequestMapping(path = "/db/api/user/create", method = RequestMethod.POST)
    public CustomResponse create(@RequestBody String userString) {
        return userDAO.create(userString);
    }

    @RequestMapping(path = "/db/api/user/follow", method = RequestMethod.POST)
    public CustomResponse follow(@RequestBody String followString) {
        return userDAO.follow(followString);
    }

    @RequestMapping(path = "/db/api/user/unfollow", method = RequestMethod.POST)
    public CustomResponse unfollow(@RequestBody String unfollowString) {
        return userDAO.unfollow(unfollowString);
    }

    @SuppressWarnings("MethodParameterNamingConvention")
    @RequestMapping(path = "/db/api/user/listFollowers", method = RequestMethod.GET)
    public CustomResponse listFollowers(@RequestParam("user") String email,
                                        @RequestParam(value = "since_id",required = false) String since_id,
                                        @RequestParam(value = "order",required = false) String order,
                                        @RequestParam(value = "limit",required = false) String limit) {
        return userDAO.listFollowers(email, since_id, limit, order);
    }

    @SuppressWarnings("MethodParameterNamingConvention")
    @RequestMapping(path = "/db/api/user/listFollowing", method = RequestMethod.GET)
    public CustomResponse listFollowing(@RequestParam("user") String email,
                                        @RequestParam(value = "since_id",required = false) String since_id,
                                        @RequestParam(value = "order",required = false) String order,
                                        @RequestParam(value = "limit",required = false) String limit) {
        return userDAO.listFollowing(email, since_id, limit, order);
    }

    @RequestMapping(path = "/db/api/user/listPosts", method = RequestMethod.GET)
    public CustomResponse listPosts(@RequestParam("user") String email,
                                    @RequestParam(value = "since", required = false) String since,
                                    @RequestParam(value = "order",required = false) String order,
                                    @RequestParam(value = "limit",required = false) String limit) {
        return userDAO.listPosts(email, since, limit, order);
    }

    @RequestMapping(path = "/db/api/user/updateProfile", method = RequestMethod.POST)
    public CustomResponse updateProfile(@RequestBody String userString) {
        return userDAO.updateProfile(userString);
    }
}