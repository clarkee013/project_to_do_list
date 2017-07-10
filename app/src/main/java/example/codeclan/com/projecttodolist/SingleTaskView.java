package example.codeclan.com.projecttodolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SingleTaskView extends AppCompatActivity {

    TextView title;
    TextView details;
    Button deleteButton;
    ArrayList<Task> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task_view);

        title = (TextView)findViewById(R.id.title);
        details = (TextView)findViewById(R.id.details);
        deleteButton = (Button)findViewById(R.id.deleteButton);

    }

}
