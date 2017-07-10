package example.codeclan.com.projecttodolist;

import java.io.Serializable;

/**
 * Created by user on 07/07/2017.
 */

public class Task {


    private String title;
    private String details;


    public Task(String title, String details) {
        this.title = title;
        this.details = details;
    }


    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}






