package com.Calendar;

/**
 * Created by BHARATH on 2/26/2016.
 */
public class event {


    private String userName;

    private String title;

    private String description;

    // private Map<String, Attachment> attachments = new LinkedHashMap<>();
    public String getuserName()
    {
        return userName;
    }

    public void setCustomerName(String customerName)
    {
        this.userName = userName;
    }

    public String getSubject()
    {
        return title;
    }

    public void setSubject(String subject)
    {
        this.title = subject;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String body)
    {
        this.description = description;
    }
}