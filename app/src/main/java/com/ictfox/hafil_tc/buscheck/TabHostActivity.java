package com.ictfox.hafil_tc.buscheck;

import com.ictfox.hafil_tc.R;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabHostActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_host);
		TabHost tabHost = getTabHost();
		 //Intent i;
		 Intent i= TabHostActivity.this.getIntent().setClass(this, BusInofmationActivity.class);
		 i = new Intent().setClass(this, BusInofmationActivity.class);
		    TabSpec sp0 = tabHost.newTabSpec("Tab0");
		    sp0.setIndicator("المعلومات الاساسية");
		    sp0.setContent(i);
		    tabHost.addTab(sp0);
		 
		 
		    i = new Intent().setClass(this, Documents.class);
		    TabSpec sp = tabHost.newTabSpec("Tab1");
		    sp.setIndicator("المستندات");
		    sp.setContent(i);
		    tabHost.addTab(sp);
		    
		    i = new Intent().setClass(this, Security.class);
		    TabSpec sp2 = tabHost.newTabSpec("Tab2");
		    sp2.setIndicator("الامن والسلامة");
		    sp2.setContent(i);
		    tabHost.addTab(sp2);
		    
		    i = new Intent().setClass(this, InternalBus.class);
		    TabSpec sp3 = tabHost.newTabSpec("Tab3");
		    sp3.setIndicator("داخل الباص");
		    sp3.setContent(i);
		    tabHost.addTab(sp3);
		    
		    i = new Intent().setClass(this, ExternalBus.class);
		    TabSpec sp4 = tabHost.newTabSpec("Tab4");
		    sp4.setIndicator("خارج الباص");
		    sp4.setContent(i);
		    tabHost.addTab(sp4);
		    
		    i = new Intent().setClass(this, MotorActivity.class);
		    TabSpec sp5 = tabHost.newTabSpec("Tab5");
		    sp5.setIndicator("المحرك");
		    sp5.setContent(i);
		    tabHost.addTab(sp5);
		    
		    i = new Intent().setClass(this, OtherActivity.class);
		    TabSpec sp6 = tabHost.newTabSpec("Tab6");
		    sp6.setIndicator("اخرى");
		    sp6.setContent(i);
		    tabHost.addTab(sp6);


        i = new Intent().setClass(this, GeneralNotes.class);
        TabSpec sp7 = tabHost.newTabSpec("Tab7");
        sp7.setIndicator("الملاحظات");
        sp7.setContent(i);
        tabHost.addTab(sp7);



		
	}
	}
