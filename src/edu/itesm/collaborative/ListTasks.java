package edu.itesm.collaborative;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
//import edu.itesm.db.TaskDAO;
=======
import edu.itesm.db.TaskDAO;
>>>>>>> master
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
<<<<<<< HEAD
	//TaskDAO dao;
	Project project;
=======
	TaskDAO dao;
>>>>>>> master
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listado_activity);
		
<<<<<<< HEAD
		project=Project.getInstance();
		Log.i("save: ", "ListTask onCreate: "+project.getTasks().size());
		//SE agrega el DAO
		/*dao= new TaskDAO(this.getApplicationContext());
		dao.open();
		List<Task> tasks=dao.getAllTasks();*/
		
		adapter= new TaskAdapter(getApplicationContext(), R.layout.row_tasks, project.getTasks());
=======
		
		//SE agrega el DAO
		dao= new TaskDAO(this.getApplicationContext());
		dao.open();
		List<Task> tasks=dao.getAllTasks();
		Log.i("List tasks","Size list "+tasks.size());
		
		adapter= new TaskAdapter(getApplicationContext(), R.layout.row_tasks, tasks);
>>>>>>> master
		this.setListAdapter(adapter);
		
		
	}
<<<<<<< HEAD
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}


=======
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater= getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}
	
>>>>>>> master
	public void back(View v){
		Intent i= new Intent(getApplicationContext(), TaskActivity.class);
		startActivity(i);
	}
<<<<<<< HEAD
=======

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.item1:
			Toast.makeText(this, " Opcion 1 "+ item.getTitle(), Toast.LENGTH_SHORT).show();		
			break;
		case R.id.item2:
			Toast.makeText(this, " Opcion 2 "+ item.getTitle(), Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
>>>>>>> master
}
