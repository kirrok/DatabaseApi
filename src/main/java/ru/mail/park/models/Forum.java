package ru.mail.park.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kirrok on 10.11.16.
 */
public class Forum<T> {
    private long id;
    private String name;
    @JsonProperty("short_name")
    private String shortName;
    private T user;

    public Forum(String name, String shortName, T user) {
        this.name = name;
        this.shortName = shortName;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public T getUser() {
        return user;
    }
}
