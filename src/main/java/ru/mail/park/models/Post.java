package ru.mail.park.models;

import java.sql.Date;

/**
 * Created by kirrok on 11.11.16.
 */
public class Post<U, T, F> {
    private long id;
    private Date date;
    private F forum;
    private boolean isApproved;
    private boolean isDeleted;
    private boolean isEdited;
    private boolean isHighlighted;
    private boolean isSpam;
    private User message;
    private Integer parent;
    private T thread;
    private U user;

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public F getForum() {
        return forum;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public boolean isEdited() {
        return isEdited;
    }

    public boolean isHighlighted() {
        return isHighlighted;
    }

    public boolean isSpam() {
        return isSpam;
    }
}
