package ru.mail.park.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kirrok on 11.11.16.
 */

public class Thread<U, F> {
    private long id;

    private F forum;
    private String title;
    @JsonProperty("isClosed")
    private boolean isClosed;
    private U user;
    private Date date;
    private String message;
    private String slug;

    @JsonProperty("isDeleted")
    private boolean isDeleted;

    private int dislikes;
    private int likes;
    private int points;
    private int posts;

    public Thread(String title, boolean isClosed, Date date, String message, String slug, F forum, U user) {
        this.forum = forum;
        this.title = title;
        this.isClosed = isClosed;
        this.user = user;
        this.date = date;
        this.message = message;
        this.slug = slug;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public F getForum() {
        return forum;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsClosed() {
        return isClosed;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getLikes() {
        return likes;
    }

    public int getPoints() {
        return points;
    }

    public int getPosts() {
        return posts;
    }

    public U getUser() {
        return user;
    }

    public String getDate() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formater.format(date.getTime());
    }

    public String getMessage() {
        return message;
    }

    public String getSlug() {
        return slug;
    }
}
