package example.codeclan.com.projecttodolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.id.list;

public class NewTaskItem extends AppCompatActivity {

    EditText newTitle;
    EditText newDetails;
    Button saveButton;
    ArrayList<Task> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task_item);

        newTitle = (EditText)findViewById(R.id.newTitle);
        newDetails = (EditText)findViewById(R.id.newDetails);
        saveButton = (Button)findViewById(R.id.saveButton);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String newTitle = extras.getString("newTitle");
        String newDetails = extras.getString("newDetails");

    }

    @Override
    protected void onClick(Button saveButton) {

    }

}