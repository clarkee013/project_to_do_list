package example.codeclan.com.projecttodolist;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by user on 07/07/2017.
 */

public class TaskListAdapter extends ArrayAdapter<Task> {

    public TaskListAdapter(Context context, ArrayList<Task> task) {
        super(context, 0, task);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.taskitem, parent, false);
        }
        final Task currentTask = getItem(position);

        final CheckedTextView title = (CheckedTextView) listItemView.findViewById(R.id.taskitem);
        title.setText(currentTask.getTitle());
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (title.isChecked()) {
                    title.setChecked(false);
                } else
                    title.setChecked(true);
            }
        });
        listItemView.setTag(currentTask);
        return listItemView;
    }
}


