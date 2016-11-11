package ru.mail.park.models;

import java.sql.Date;

/**
 * Created by kirrok on 11.11.16.
 */
public class Thread<U, F> {
    private long id;
    private Date date;
    private F forum; //parent forum short_name
    private int dislikes;
    private int likes;
    private boolean isClosed;
    private boolean isDeleted;
    private User message;
    private int points;
    private int posts;
    private User slug;
    private User title;
    private U user;

}
