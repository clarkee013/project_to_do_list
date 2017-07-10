package example.codeclan.com.projecttodolist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 07/07/2017.
 */

public class TaskTest {

    Task task;

    @Before
    public void before(){
    task = new Task("test task", "test details", true);
    }

    @Test
    public void getTitleTest(){
        assertEquals("test task", task.getTitle());
    }

    @Test
    public void getDetailsTest(){
        assertEquals("test details", task.getDetails());
    }

    @Test
    public void getTickTest(){
        assertEquals(true, task.getTick());
    }

    @Test
    public void setTitleTest(){
        task.setTitle("set title test");
        assertEquals("set title test", task.getTitle());

    }

    @Test
    public void setDetailsTest(){
        task.setDetails("set details test");
        assertEquals("set details test", task.getDetails());
    }

    @Test
    public void setTickTest(){
        task.setTick(false);
        assertEquals(false, task.getTick());
    }
}






