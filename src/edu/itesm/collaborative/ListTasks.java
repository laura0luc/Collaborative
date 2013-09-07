package edu.itesm.collaborative;

import java.util.ArrayList;
import java.util.List;

//import edu.itesm.db.TaskDAO;
import edu.itesm.pojo.Project;
import edu.itesm.pojo.Task;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ListTasks extends ListActivity {
	TaskAdapter adapter;
	//TaskDAO dao;
	Project project;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listado_activity);
		
		project=Project.getInstance();
		Log.i("save: ", "ListTask onCreate: "+project.getTasks().size());
		//SE agrega el DAO
		/*dao= new TaskDAO(this.getApplicationContext());
		dao.open();
		List<Task> tasks=dao.getAllTasks();*/
		
		adapter= new TaskAdapter(getApplicationContext(), R.layout.row_tasks, project.getTasks());
		this.setListAdapter(adapter);
		
		
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}


	public void back(View v){
		Intent i= new Intent(getApplicationContext(), TaskActivity.class);
		startActivity(i);
	}
}
