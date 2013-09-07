package edu.itesm.collaborative;

import java.util.List;

import edu.itesm.pojo.Task;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TaskAdapter extends ArrayAdapter<Task> {
	private Context context;
	private List<Task> tasks;

	public TaskAdapter(Context context, int resource, List<Task> objects) {
		super(context, resource, objects);
		this.context= context;
		this.tasks=objects;
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//return super.getView(position, convertView, parent);
		
		View fila=convertView;
		if(fila==null){
			LayoutInflater inflate=(LayoutInflater)context.getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			fila=inflate.inflate(R.layout.row_tasks, parent, false);
		}
		
		Task task=tasks.get(position);
		
		TextView nombre =(TextView)fila.findViewById(R.id.textView1);
		nombre.setTextColor(Color.BLACK);
		nombre.setText(task.getTask());
		
		TextView end=(TextView)fila.findViewById(R.id.textView2);
		end.setTextColor(Color.BLACK);
		end.setText(task.getEndDate());
		
		TextView users=(TextView)fila.findViewById(R.id.users);
		users.setTextColor(Color.BLACK);
		users.setText(task.getCollaborators().size()+"");
		
		return fila;
	}

}
