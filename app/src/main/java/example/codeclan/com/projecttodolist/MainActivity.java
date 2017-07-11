package example.codeclan.com.projecttodolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    ArrayList<Task> oneSingleTask;
    ArrayList<Task> list;
    SharedPreferences sharedPref;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TaskList taskList = new TaskList();
//        ArrayList<Task> list = taskList.getList();
//        TaskListAdapter taskAdapter = new TaskListAdapter(this, list);
//        ListView listView = (ListView) findViewById(R.id.taskOverview);
//        listView.setAdapter(taskAdapter);

        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.clear().commit();
//        two lines above clear the list

        String singleTask = sharedPref.getString("SingleTask", new ArrayList<Task>().toString());
        Log.d("new task string", singleTask);

        gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
        oneSingleTask = gson.fromJson(singleTask, taskArrayList.getType());
        Log.d("oneSingleTask", oneSingleTask.toString());
        if (getIntent().getExtras() != null ) {
            Task newTask = (Task) getIntent().getExtras().get("newTask");
            oneSingleTask.add(newTask);
//            Log.d("oneSingleTask", oneSingleTask.toString());
        }

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("SingleTask", gson.toJson(oneSingleTask));
        editor.apply();
        //the above 3 lines are saving the details so it persists.

        TaskListAdapter taskListAdapter = new TaskListAdapter(this, oneSingleTask);
        ListView list = (ListView) findViewById(R.id.taskOverview);
        list.setAdapter(taskListAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_button) {
            Intent intent = new Intent(this, NewTaskItem.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View listItem) {
        Task task = (Task) listItem.getTag();
        Log.d("Task Title: ", task.getTitle());

        Intent intent = new Intent(this, SingleTaskView.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }

//    Should the below View and view be Button and button?
    public void onDeleteButtonClick(View view){
        View parent = (View) view.getParent();
        String tag = parent.getTag().toString();
        for (Task task : oneSingleTask){
            if (task.getTitle().equals(tag)){
                oneSingleTask.remove(task);
                break;
            }
        }
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("task", gson.toJson(oneSingleTask));
        editor.apply();
        finish();
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
        startActivity(getIntent());
    }


}





