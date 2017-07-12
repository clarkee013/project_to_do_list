package example.codeclan.com.projecttodolist;

import java.io.Serializable;

/**
 * Created by user on 07/07/2017.
 */

public class Task implements Serializable{


    private String title;
    private String details;
    private Boolean tick;


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

    public Boolean getTick(){
        return tick;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setTick(Boolean tick){
        this.tick = tick;
    }

    public void toggleComplete() {
        this.tick = !this.tick;
    }

}






