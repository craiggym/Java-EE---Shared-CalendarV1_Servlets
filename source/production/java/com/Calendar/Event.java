package com.Calendar;

import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by BHARATH on 2/26/2016.
 */
public class Event {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String eventName;
    private String eventDate;
    private String eventDescription;
    private String username;

    Event(String name, String date, String desc, String uname, Integer id) {
        this.eventName = name;
        this.eventDate = date;
        this.eventDescription = desc;
        this.username = uname;
        this.id = id;
    }

    //============== Getters ====================================
    public String getEventDate() {
        return this.eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDescription() {
        return eventDescription;
    }
    public String getUsername() {
        return username;
    }

    //============ Setters ==========================================
    public void setEventName(String name) {
        this.eventName = name;
    }

    public void setEventDate(String date) {
        this.eventDate = date;
    }

    public void setDescription(String body) {
        this.eventDescription = body;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}

/*
    private SimpleDateFormat eventDate;
    private String description;
    private String username;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public SimpleDateFormat getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}*/