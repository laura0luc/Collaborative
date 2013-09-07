package edu.itesm.collaborative;



import java.text.SimpleDateFormat;
import java.util.Date;

<<<<<<< HEAD
//import edu.itesm.db.TaskDAO;
=======
import edu.itesm.db.TaskDAO;
>>>>>>> master
import edu.itesm.pojo.Project;
import edu.itesm.pojo.Task;
import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;



public class TaskActivity extends ListActivity {
	private Spinner spinner;
	Task task;
<<<<<<< HEAD
	//TaskDAO dao;
=======
	TaskDAO dao;
>>>>>>> master
	ArrayAdapter<CharSequence> adaptador;
	ArrayAdapter<String> adaptadorList;
	Project project;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_task);
<<<<<<< HEAD
		project=Project.getInstance();
		//dao= new TaskDAO(this.getApplicationContext());
		//dao.open();
=======
		dao= new TaskDAO(this.getApplicationContext());
		dao.open();
>>>>>>> master
		task= new Task();
		//Adaptador para el spinner
		spinner=(Spinner) this.findViewById(R.id.spinner1);
		adaptador= ArrayAdapter.createFromResource(getApplicationContext(), 
				R.array.collaborators, 
				android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adaptador);
		
		//Adaptador para la lista
		adaptadorList= new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, 
				task.getCollaborators());
		this.setListAdapter(adaptadorList);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.task, menu);
		return true;
	}
	
	public void addCollab(View v){
		String nombre= spinner.getSelectedItem().toString();
		Toast.makeText(getApplicationContext(), "nombre: "+nombre, Toast.LENGTH_SHORT).show();
		task.addCollaborator(nombre);
		adaptadorList.notifyDataSetChanged();
		
	}
<<<<<<< HEAD
	public void save(View v){
=======
	//Agregado 4» sesion
	public void doPositiveClick(){
		Toast.makeText(this, "Click positivo", Toast.LENGTH_LONG).show();
		save();
	}
	//Agregado 4» sesion
	public void doNegativeClick(){
		
		Toast.makeText(this, "Click negativo", Toast.LENGTH_LONG).show();
		
	}
	//Agregado 4» sesion
	public void showDialog(View v){
		EjemploFragment ejemplo=EjemploFragment.newInstance("Muy seguro");
		ejemplo.show(getFragmentManager(), "Dialog");
	}
	//public void save(View v){
	public void save(){
>>>>>>> master
		String taskName= ((EditText)this.findViewById(R.id.taskName)).getText().toString();
		String startSt=((EditText)this.findViewById(R.id.start)).getText().toString();
		String endSt=((EditText)this.findViewById(R.id.end)).getText().toString();
		Date start,end;
		task.setTask(taskName);
		task.setStatus("iniciado");
		try{
			SimpleDateFormat simple=new SimpleDateFormat("dd-MM-yyyy");
			start=simple.parse(startSt);
			end=simple.parse(endSt);
			task.setStart(start);
			task.setEnd(end);
		}catch(Exception e){
			Log.e("save", e.getMessage());			
		}
<<<<<<< HEAD
		project.addTask(task);
/*		dao.addTask(task);
		dao.close();*/
=======
		//project=Project.getInstance();
		//Toast.makeText(getApplicationContext(), project.getTasks().get(0).getTask(), Toast.LENGTH_LONG).show();
		//project.addTask(task);
		dao.addTask(task);
		dao.close();
>>>>>>> master
		Intent i= new Intent(getApplicationContext(), ListTasks.class);
		startActivity(i);
				
	}
	

	
}
