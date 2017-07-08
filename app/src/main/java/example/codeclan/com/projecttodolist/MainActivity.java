package example.codeclan.com.projecttodolist;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TaskList taskList = new TaskList();
        ArrayList<Task> list = taskList.getList();

        TaskListAdapter taskAdapter = new TaskListAdapter(this, list);

        ListView listView = (ListView) findViewById(R.id.taskOverview);
        listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(taskAdapter);
        final CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.taskitem);
        checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkedTextView.isChecked()) {
                    checkedTextView.setChecked(false);
                }
                else
                    checkedTextView.setChecked(true);
            }
        });


    }
}





