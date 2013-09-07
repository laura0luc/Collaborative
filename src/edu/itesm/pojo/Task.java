package edu.itesm.pojo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {
	private List<String> collaborators;
	private String task;
	private Date start;
	private Date end;
	private String status;
	private SimpleDateFormat simple=new SimpleDateFormat("dd-MM-yyyy");
	
	public Task(){
		collaborators= new ArrayList<String>();
	}
	
	public void addCollaborator(String name){
		collaborators.add(name);
	}
	
	public List<String> getCollaborators() {
		return collaborators;
	}
	public void setCollaborators(List<String> collaborators) {
		this.collaborators = collaborators;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
	public String getEndDate(){
		return simple.format(end);
	}
	public String getStartDate(){
		return simple.format(start);
	}
	public void setStartDate(String start){
		try{
			this.start=simple.parse(start);
		}catch(Exception e){
			
		}
	}
	public void setEndDate(String end){
		try{
			this.end=simple.parse(end);
		}catch(Exception e){
			
		}
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
