package example.codeclan.com.projecttodolist;

import android.content.SharedPreferences;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SingleTaskView extends AppCompatActivity {

    TextView singleTitle;
    TextView singleDetails;
    Button deleteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task_view);

        singleTitle = (TextView)findViewById(R.id.singleTitle);
        singleDetails = (TextView)findViewById(R.id.singleDetails);
        deleteButton = (Button)findViewById(R.id.deleteButton);

        Task task = (Task) getIntent().getExtras().get("task");
        singleTitle.setText(task.getTitle());
        singleDetails.setText(task.getDetails());


    }



}
