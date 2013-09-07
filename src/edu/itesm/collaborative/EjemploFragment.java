package edu.itesm.collaborative;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;


@SuppressLint("NewApi")
public class EjemploFragment extends DialogFragment {
	
	public static EjemploFragment newInstance(String title){
		EjemploFragment frag= new EjemploFragment();
		Bundle args=new Bundle();
		args.putString("title", title);
		frag.setArguments(args);
		return frag;
	}
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		String title= getArguments().getString("title");
		
		return new AlertDialog.Builder(getActivity())
		.setIcon(R.drawable.ic_launcher)
		.setTitle(title)
		.setPositiveButton("Dialog - OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				((TaskActivity)getActivity()).doPositiveClick();
				// TODO Auto-generated method stub
				
			}
		}).setNegativeButton("Dialog - Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				((TaskActivity)getActivity()).doNegativeClick();
				// TODO Auto-generated method stub
				
			}
		}).create();
	}
}
