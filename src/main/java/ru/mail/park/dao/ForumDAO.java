package ru.mail.park.dao;

import ru.mail.park.controllers.CustomResponse;

import java.util.List;


public interface ForumDAO {
    void truncateTable();

    int count();

    CustomResponse create(String body);

    CustomResponse details(String forumShortName, final List<String> related);

    CustomResponse listPosts(String forumShortName,
                             final List<String> related,
                             String since,
                             String limit,
                             String order);

    CustomResponse listThreads(String forumShortName,
                               final List<String> related,
                               String since,
                               String limit,
                               String order);

    @SuppressWarnings("MethodParameterNamingConvention")
    CustomResponse listUsers(String forumShortName, String since_id, String limit, String order);
}
