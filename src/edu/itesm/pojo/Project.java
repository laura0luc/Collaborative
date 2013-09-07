package edu.itesm.pojo;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private List<Task> addedTasks;
	private static Project project;
	
	protected Project(){
		addedTasks= new ArrayList<Task>();
	}
	
	public static Project getInstance(){
		if(project==null){
			project= new Project();
		}
		return project;
	}
	
	public void addTask(Task t){
		addedTasks.add(t);
	}
	
	public List<Task> getTasks(){
		return addedTasks;
	}
}
