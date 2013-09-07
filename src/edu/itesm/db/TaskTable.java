package edu.itesm.db;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TaskTable {
	public static final String TABLA_TASKS = "tasks";
	public static final String ID_COLUMN = "_id";
	public static final String NAME_COLUMN = "name";
	public static final String COLAB_COLUMN = "collaborators";
	public static final String START_COLUMN = "start";
	public static final String END_COLUMN="end";

	
	private static final String CREATE_DB = "create table " 
			+ TABLA_TASKS
			+ "(" 
			+ ID_COLUMN + " integer primary key autoincrement, " 
			+ NAME_COLUMN + " text not null, "
			+ COLAB_COLUMN + " text not null, "
			+ START_COLUMN + " text not null, " 
			+ END_COLUMN + " text not null"
			+ ");";

	public static void onCreate(SQLiteDatabase database) {
		Log.i("onCreate","query del create: "+CREATE_DB);
		database.execSQL(CREATE_DB);
		
	}

	public static void onUpgrade(
			SQLiteDatabase database, 
			int oldVersion,
			int newVersion) {
		database.execSQL("DROP TABLE IF EXISTS"+TABLA_TASKS);
		onCreate(database);
		

	}

}
