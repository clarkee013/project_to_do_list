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

    ArrayList<Task> allTasks;
    ListView listView;
    SharedPreferences sharedPref;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.clear().commit();
//        two lines above clear the list

        String singleTask = sharedPref.getString("SingleTask", new ArrayList<Task>().toString());
//      Boolean tickStatus = sharedPref.getBoolean("TickStatus", false);
        Log.d("new task string", singleTask);

        gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>() {
        };
        allTasks = gson.fromJson(singleTask, taskArrayList.getType());
        Log.d("allTasks", allTasks.toString());
        if (getIntent().getExtras() != null) {
            Task newTask = (Task) getIntent().getExtras().get("newTask");
            if(newTask != null){
                allTasks.add(newTask);
            }
//            Log.d("allTasks", allTasks.toString());
        }


        saveSharedPref();

        //the above 3 lines are saving the details so it persists.

        TaskListAdapter taskListAdapter = new TaskListAdapter(this, allTasks);
        listView = (ListView) findViewById(R.id.taskOverview);
        listView.setAdapter(taskListAdapter);


    }

    public void saveSharedPref(){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("SingleTask", gson.toJson(allTasks));
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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

    public void onCheckboxClicked(View view) {
        // Get the position of the parent item in the list
        View parent = (View) view.getParent();
        int position = listView.getPositionForView(parent);

        // Toggle the truthiness of the task at position X
        Task taskObject = allTasks.get(position);
        taskObject.toggleComplete();
        allTasks.remove(position);
        allTasks.add(position, taskObject);

        // save the arraylist in shared prefs
        saveSharedPref();

    }









}


