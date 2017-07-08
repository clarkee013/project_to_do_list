package example.codeclan.com.projecttodolist;

import java.io.Serializable;

/**
 * Created by user on 07/07/2017.
 */

public class Task {


    private String title;
    private String details;
    private boolean tick;

    public Task(String title, String details, Boolean tick) {
        this.title = title;
        this.details = details;
        this.tick = tick;
    }


    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public boolean getTick() {
        return tick;
    }
}






