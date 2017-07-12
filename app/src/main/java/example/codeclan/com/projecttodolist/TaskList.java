package example.codeclan.com.projecttodolist;

import java.util.ArrayList;

/**
 * Created by user on 07/07/2017.
 */

public class TaskList {

    private ArrayList<Task> list;

    public TaskList(){
        list = new ArrayList<Task>();
        list.add(new Task("Dishes", "Put away dishes & wash what is there", false));
        list.add(new Task("Bathroom", "Clean the bathroom, including the window!", false));
        list.add(new Task("Tidy loft", "tidy the loft, including dusting the Lego collection", false));
        }

    public ArrayList<Task> getList() {
        return new ArrayList<Task>(list);
    }

}

