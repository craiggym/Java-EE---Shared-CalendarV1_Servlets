package com.Calendar;

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
/*<<<<<<< HEAD
    private Date eventDate;
    private String eventDescription;

    Event(String name, Date date, String desc){
        this.eventName = name;
        this.eventDate = date;
        this.eventDescription = desc;
    }

    //============== Getters ====================================
    public Date getEventDate() { return eventDate; }
    public String getEventName() { return eventName; }
    public String getDescription() { return eventDescription;  }

    //============ Setters ==========================================
    public void setEventName(String name) { this.eventName = name; }
    public void setEventDate(Date date) { this.eventDate = date; }
    public void setDescription(String body) { this.eventDescription = body; }

=======*/

    private String eventDate;

    private String description;
    private String username;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
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
}