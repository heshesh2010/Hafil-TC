package com.ictfox.hafil_tc;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TableRow;
import android.widget.TextView;

import com.ictfox.hafil_tc.LastDaysAdapter.ViewHolder;

public class tjamo3firstGirdViewAdapter extends ArrayAdapter<tjamo3firstGirdViewHelper>{

	
	private final Activity activity;
	List<tjamo3firstGirdViewHelper> PointsID = new ArrayList<tjamo3firstGirdViewHelper>();
	List<tjamo3firstGirdViewHelper> fleetNumber = new ArrayList<tjamo3firstGirdViewHelper>();
	List<tjamo3firstGirdViewHelper> StudentsNumber = new ArrayList<tjamo3firstGirdViewHelper>();
	List<tjamo3firstGirdViewHelper> Dates = new ArrayList<tjamo3firstGirdViewHelper>();
	
	Context context;
	
	public tjamo3firstGirdViewAdapter(Activity activity,List<tjamo3firstGirdViewHelper> PointsID, Context context2, List<tjamo3firstGirdViewHelper> fleetNumber, List<tjamo3firstGirdViewHelper> StudentsNumber, List<tjamo3firstGirdViewHelper> Dates){
		super(activity, R.layout.activity_sto_points,PointsID );
		this.activity=activity;
		this.PointsID=PointsID;
		this.fleetNumber=fleetNumber;
		this.context=context2;
		this.StudentsNumber=StudentsNumber;
		this.Dates=Dates;
	}
	

        
	class ViewHolder {
		protected TextView PointID;
		protected TextView fleetNumber;
		protected TextView LastDate;
		protected TextView Students;
		protected TableRow row;
		
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		View view = null;
		
		if (convertView == null) {

			LayoutInflater inflator = activity.getLayoutInflater();
			view = inflator.inflate(R.layout.reptjamo3first, null);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.PointID = (TextView) view
					.findViewById(R.id.TextView1);
			
			viewHolder.Students = (TextView) view
					.findViewById(R.id.textView2);	

			
			viewHolder.fleetNumber = (TextView) view
					.findViewById(R.id.textView3);
			
			viewHolder.LastDate = (TextView) view
					.findViewById(R.id.textView4);

			view.setTag(viewHolder);




		} else{
			view = convertView;


			
			//((ViewHolder) view.getTag()).row.setTag(busIDs
				//	.get(position));

		}
	
		
		final ViewHolder holder = (ViewHolder) view.getTag();
		/*
		holder.row.setOnClickListener(new OnClickListener() {
			
		       @Override
		        public void onClick(View v) {
		            // TODO: do your logic here

		        }   
		});*/


		 
		holder.fleetNumber.setText(fleetNumber.get(position).getDate());
		holder.PointID.setText(PointsID.get(position).getDate());
		holder.LastDate.setText(Dates.get(position).getDate());
		holder.Students.setText(StudentsNumber.get(position).getDate());
		return view;
}

}
