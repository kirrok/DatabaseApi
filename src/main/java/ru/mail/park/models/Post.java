package ru.mail.park.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kirrok on 11.11.16.
 */
public class Post<U, T, F> {
    private long id;

    private Date date;
    private T thread;
    private F forum;
    private U user;
    private String message;

    private int dislikes;
    private int likes;
    private int points;

    private Integer parent;
    @JsonProperty("isApproved")
    private boolean isApproved;
    @JsonProperty("isDeleted")
    private boolean isDeleted;
    @JsonProperty("isEdited")
    private boolean isEdited;
    @JsonProperty("isHighlighted")
    private boolean isHighlighted;
    @JsonProperty("isSpam")
    private Boolean isSpam;

    public Post(Date date, T thread, F forum, U user, String message) {
        this.date = date;
        this.thread = thread;
        this.forum = forum;
        this.user = user;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formater.format(date.getTime());
    }

    public F getForum() {
        return forum;
    }

    public boolean getIsApproved() {
        return isApproved;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public boolean getIsEdited() {
        return isEdited;
    }

    public boolean getIsHighlighted() {
        return isHighlighted;
    }

    public boolean getIsSpam() {
        return isSpam;
    }

    public T getThread() {
        return thread;
    }

    public U getUser() {
        return user;
    }

    public String getMessage() {
        return message;
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

    public Integer getParent() {
        return parent;
    }

    public boolean isApproved() {
        return isApproved;
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

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setEdited(boolean edited) {
        isEdited = edited;
    }

    public void setHighlighted(boolean highlighted) {
        isHighlighted = highlighted;
    }

    public void setSpam(Boolean spam) {
        isSpam = spam;
    }

    public void setId(long id) {
        this.id = id;
    }
}
