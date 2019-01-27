package com.ictfox.hafil_tc;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LastTaskeenAdapter extends ArrayAdapter<LastTaskeenHelper>{


	private final Activity activity;
	 List<LastTaskeenHelper> nat = new ArrayList<LastTaskeenHelper>();
	 List<LastTaskeenHelper> mainstrayNumber = new ArrayList<LastTaskeenHelper>();
List<LastTaskeenHelper> fleetNumber = new ArrayList<LastTaskeenHelper>();
List<LastTaskeenHelper> status = new ArrayList<LastTaskeenHelper>();
List<LastTaskeenHelper> types = new ArrayList<LastTaskeenHelper>();
public LastTaskeenAdapter(Activity activity, List<LastTaskeenHelper> list, List<LastTaskeenHelper> mainstrayNumber, List<LastTaskeenHelper> fleetNumber,List<LastTaskeenHelper> Status , List<LastTaskeenHelper> Types){
		super(activity, R.layout.activity_last_taskeen,list );
		this.activity=activity;
		this.nat=list;
		this.mainstrayNumber=mainstrayNumber;
this.fleetNumber=fleetNumber;
    this.status=Status;
    this.types=Types;
	}
	

        
	class ViewHolder {
		protected TextView NAT;
		protected TextView Minstaryfield;
        protected TextView Fleetfield;
        protected TextView StatusField;
        protected TextView TypeField;
		protected TableRow row;
		
		;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		View view = null;
		
		if (convertView == null) {

			LayoutInflater inflator = activity.getLayoutInflater();
			view = inflator.inflate(R.layout.rep, null);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.NAT = (TextView) view.findViewById(R.id.TextView1);
			viewHolder.Minstaryfield = (TextView) view.findViewById(R.id.textView2);
            viewHolder.Fleetfield = (TextView) view.findViewById(R.id.textView3);
            viewHolder.StatusField = (TextView) view.findViewById(R.id.textView4);
            viewHolder.TypeField = (TextView) view.findViewById(R.id.textView5);
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


        holder.NAT.setText(nat.get(position).getDate());
		holder.Minstaryfield.setText(mainstrayNumber.get(position).getDate());
        holder.Fleetfield.setText(fleetNumber.get(position).getDate());
        if(Integer.parseInt(status.get(position).getDate())==0){

            holder.StatusField.setText("غير متزامن");
        }
        else{
            holder.StatusField.setText("متزامن");

        }

        if(Integer.parseInt(types.get(position).getDate())==0){

            holder.TypeField.setText("حافلة عاملة");
        }
        else if (Integer.parseInt(types.get(position).getDate())==1){
            holder.TypeField.setText("احتياطي بالسائق");

        }

        else if (Integer.parseInt(types.get(position).getDate())==2){
            holder.TypeField.setText("احتياطي بدون سائق");

        }
        else if (Integer.parseInt(types.get(position).getDate())==3){
            holder.TypeField.setText("تنزيل");

        }

		return view;
}
}