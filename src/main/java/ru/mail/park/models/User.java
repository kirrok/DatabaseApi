package ru.mail.park.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by kirrok on 11.11.16.
 */
public class User {
    private long id;
    private final String about;
    private final String email;
    private final String name;
    private final String username;
    @JsonProperty("isAnonymous")
    private boolean isAnonumous;
    private ArrayList<String> followers;
    private ArrayList<String> following;
    private ArrayList<Integer> subscriptions;

    public User(String username, String name, String email, String about, boolean isAnonumous) {
        this.about = about;
        this.email = email;
        this.name = name;
        this.username = username;
        this.isAnonumous = isAnonumous;
    }

    public long getId() {
        return id;
    }

    public String getAbout() {
        return about;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public boolean getIsAnonumous() {
        return isAnonumous;
    }

    public ArrayList<String> getFollowers() {
        return followers;
    }

    public ArrayList<String> getFollowing() {
        return following;
    }

    public ArrayList<Integer> getSubscriptions() {
        return subscriptions;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIsAnonumous(boolean anonumous) {
        isAnonumous = anonumous;
    }

    public void setFollowers(ArrayList<String> followers) {
        this.followers = followers;
    }

    public void setFollowing(ArrayList<String> following) {
        this.following = following;
    }

    public void setSubscriptions(ArrayList<Integer> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
