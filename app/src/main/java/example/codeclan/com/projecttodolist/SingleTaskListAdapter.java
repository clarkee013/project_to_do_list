package example.codeclan.com.projecttodolist;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by user on 07/07/2017.
 */

public class SingleTaskListAdapter extends ArrayAdapter<Task> {

    public SingleTaskListAdapter(Context context, ArrayList<Task> tasks){
        super(context, 0, tasks);
    }

    public View getSingleTaskView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_single_task_view, parent, false);
        }
        final Task currentTask = getItem(position);

        final TextView title = (TextView) listItemView.findViewById(R.id.title);
        title.setText(currentTask.getTitle());
        final TextView details = (TextView) listItemView.findViewById(R.id.details);
        details.setText(currentTask.getDetails());
        listItemView.setTag(currentTask);
        return listItemView;
    }



}