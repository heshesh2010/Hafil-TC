package com.ictfox.hafil_tc;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LastDaysAdapter extends ArrayAdapter<LastDaysHelper>{

	
	private final Activity activity;
	 List<LastDaysHelper> FleetNumbers = new ArrayList<LastDaysHelper>();
	 List<LastDaysHelper> Dates = new ArrayList<LastDaysHelper>();
	 List<LastDaysHelper> plateNumber = new ArrayList<LastDaysHelper>();
List<LastDaysHelper> status = new ArrayList<LastDaysHelper>();

	Context context;
	
	public LastDaysAdapter(Activity activity,List<LastDaysHelper> dates, Context context2, List<LastDaysHelper> list, List<LastDaysHelper> plateNumber     , List<LastDaysHelper>  Status){
		super(activity, R.layout.activity_last_days,list );
		this.activity=activity;
		this.FleetNumbers=list;
		this.Dates=dates;
		this.context=context2;
		this.plateNumber=plateNumber;
        this.status=Status;
	}
	

        
	class ViewHolder {
		protected TextView FleetNumber;
		protected TextView plateNumber;
		protected TextView LastDate;
		protected TableRow row;
        protected TextView StatusField;
		
		;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		View view = null;
		
		if (convertView == null) {

			LayoutInflater inflator = activity.getLayoutInflater();
			view = inflator.inflate(R.layout.rep, null);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.FleetNumber = (TextView) view
					.findViewById(R.id.TextView1);
			viewHolder.LastDate = (TextView) view
					.findViewById(R.id.textView2);	

			viewHolder.plateNumber = (TextView) view
					.findViewById(R.id.textView3);

            viewHolder.StatusField = (TextView) view.findViewById(R.id.textView4);

		//	viewHolder.row = (TableRow) view.findViewById(R.id.TableRow05);
			view.setTag(viewHolder);
			//viewHolder.row.setTag(busIDs.get(position));



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


        holder.FleetNumber.setText(FleetNumbers.get(position).getDate());
		holder.plateNumber.setText(plateNumber.get(position).getDate());
       // String h = new StringBuilder(Dates.get(position).getDate()).insert(Dates.get(position).getDate().length()-8, "_").toString();

        String h = Dates.get(position).getDate().substring(0, 10)+" "+Dates.get(position).getDate().substring(Dates.get(position).getDate().length()-8, Dates.get(position).getDate().length());

		holder.LastDate.setText(h);

        if(Integer.parseInt(status.get(position).getDate())==0){

            holder.StatusField.setText("غير متزامن");
        }
        else{
            holder.StatusField.setText("متزامن");

        }

        return view;
}
}