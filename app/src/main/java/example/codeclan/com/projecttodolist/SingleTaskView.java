package example.codeclan.com.projecttodolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        deleteButton.getId();
    }

//    public void onDeleteButtonClick(View view) {
//        View parent = (View) view.getParent();
//        String tag = parent.getTag().toString();
//        for (Task task : allTasks) {
//            if (task.getTitle().equals(tag)) {
//                allTasks.remove(task);
//                break;
//            }
//        }
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("task", gson.toJson(allTasks));
//        editor.apply();
//        finish();
////        Intent intent = new Intent(this, MainActivity.class);
////        startActivity(intent);
//        startActivity(getIntent());
//    }



}
