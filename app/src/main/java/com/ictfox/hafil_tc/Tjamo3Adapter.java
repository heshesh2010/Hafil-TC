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

import com.ictfox.hafil_tc.tjamo3firstGirdViewAdapter.ViewHolder;

public class Tjamo3Adapter extends ArrayAdapter<Tjmo3Helper>{

	
	private final Activity activity;
	List<Tjmo3Helper> fleetNumber = new ArrayList<Tjmo3Helper>();
	List<Tjmo3Helper> palateNumber = new ArrayList<Tjmo3Helper>();
	List<Tjmo3Helper> Dates = new ArrayList<Tjmo3Helper>();
	List<Tjmo3Helper> path = new ArrayList<Tjmo3Helper>();
	
	Context context;
	
	public Tjamo3Adapter(Activity activity,List<Tjmo3Helper> fleetNumber, Context context2, List<Tjmo3Helper> palateNumber, List<Tjmo3Helper> Dates, List<Tjmo3Helper> path){
		super(activity, R.layout.activity_tjamo3_points,fleetNumber);
		this.activity=activity;
		this.fleetNumber=fleetNumber;
		this.palateNumber=palateNumber;
		this.context=context2;
		this.Dates=Dates;
		this.path=path;
	}
	

        
	class ViewHolder {
		protected TextView path;
		protected TextView fleetNumber;
		protected TextView LastDate;
		protected TextView palateNumber;
		protected TableRow row;
		
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		View view = null;
		
		if (convertView == null) {

			LayoutInflater inflator = activity.getLayoutInflater();
			view = inflator.inflate(R.layout.reptjamo3, null);
			ViewHolder viewHolder = new ViewHolder();
			
			
			viewHolder.fleetNumber = (TextView) view
					.findViewById(R.id.TextView1);
			
			viewHolder.palateNumber = (TextView) view
					.findViewById(R.id.textView3);
			
			viewHolder.LastDate = (TextView) view
					.findViewById(R.id.textView2);
			
			viewHolder.path = (TextView) view
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
		holder.palateNumber.setText(palateNumber.get(position).getDate());
		holder.LastDate.setText(Dates.get(position).getDate());
		holder.path.setText(path.get(position).getDate());
		return view;
}

}


