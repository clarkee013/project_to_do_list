package example.codeclan.com.projecttodolist;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static android.R.id.list;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static org.junit.Assert.assertEquals;

/**
 * Created by user on 07/07/2017.
 */

public class TaskListTest {

    TaskList taskList;

    @Test
    public void getListTest(){
        TaskList taskList = new TaskList();
        assertEquals(3, taskList.getList().size());
    }

}

