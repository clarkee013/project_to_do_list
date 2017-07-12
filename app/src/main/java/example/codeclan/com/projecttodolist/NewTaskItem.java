package example.codeclan.com.projecttodolist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;

public class NewTaskItem extends AppCompatActivity {

    EditText title;
    EditText details;
    Button saveButton;
    SharedPreferences sharedPref;
    ArrayList<Task> allTasks;
    Gson gson;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task_item);

        title = (EditText) findViewById(R.id.newTitle);
        details = (EditText) findViewById(R.id.newDetails);
        saveButton = (Button) findViewById(R.id.saveButton);
    }

    public void onSaveButtonClick(View view){
        String newTitle = title.getText().toString();
        String newDetails = details.getText().toString();
        Task newTask = new Task(newTitle, newDetails, false);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("newTask", newTask);
        startActivity(intent);
    }




}
