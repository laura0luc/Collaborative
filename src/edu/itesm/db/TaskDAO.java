package edu.itesm.db;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import edu.itesm.pojo.Task;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TaskDAO {
	private SQLiteDatabase database;
	private TaskHelper helper;
	private String[] columnas = {TaskTable.ID_COLUMN, TaskTable.NAME_COLUMN,TaskTable.COLAB_COLUMN, TaskTable.START_COLUMN, TaskTable.END_COLUMN};
	
	public TaskDAO(Context context){
		helper= new TaskHelper(context);
	}
	public void open() throws SQLException {
		database=helper.getWritableDatabase();
		
	}
	
	public void close() {
		helper.close();
		
	}
	
	public Task addTask(Task task){
		
		ContentValues values= new ContentValues();
		values.put(TaskTable.NAME_COLUMN, task.getTask());
		String colabs=task.getCollaborators().toString();
		values.put(TaskTable.COLAB_COLUMN, colabs);
		values.put(TaskTable.START_COLUMN, task.getStartDate());
		values.put(TaskTable.END_COLUMN, task.getEndDate());
		long insertId=database.insert(TaskTable.TABLA_TASKS, null, values);
		Cursor cursor=database.query(TaskTable.TABLA_TASKS, columnas, TaskTable.ID_COLUMN+ "=?", new String[] {insertId+""}, null, null, null);
		cursor.moveToFirst();
		Task t= new Task();
		t.setTask(cursor.getString(1));
		Log.i("DAO", "ADD DAO - Date: "+cursor.getString(3));
		String colab[]=cursor.getString(2).split(",");
		for(int i=0; i<colab.length; i++){
			t.addCollaborator(colab[i]);
		}
		Log.i("addTask", cursor.getString(1));
		return task;
	}
	
	public List<Task> getAllTasks(){
		List<Task> tasks= new LinkedList<Task>();
		Cursor cr= database.query(TaskTable.TABLA_TASKS,columnas, null, null, null, null, null);
		cr.moveToFirst();
		while(!cr.isAfterLast()){
			Task t= new Task();
			Log.i("DAO", "DAO text "+cr.getString(1));
			t.setTask(cr.getString(1));
			String colab[]=cr.getString(2).split(",");
			for(int i=0; i<colab.length; i++){
				t.addCollaborator(colab[i]);
			}
			t.setStartDate(cr.getString(2));
			t.setEndDate(cr.getString(3));
			tasks.add(t);
			cr.moveToNext();
		}
		return tasks;
	}

}
