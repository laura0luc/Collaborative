package edu.itesm.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskHelper extends SQLiteOpenHelper {
	
	public static final String TASK_DATABASE = "task.db";
	public static final int TASK_VERSION_DATABASE = 1;
	
	public TaskHelper(Context context){
		super(context, TASK_DATABASE, null, TASK_VERSION_DATABASE);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		TaskTable.onCreate(db);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		TaskTable.onUpgrade(db, oldVersion, newVersion);

	}

}
