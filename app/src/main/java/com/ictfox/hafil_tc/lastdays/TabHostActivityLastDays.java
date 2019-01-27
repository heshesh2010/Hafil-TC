package com.ictfox.hafil_tc.lastdays;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import com.ictfox.hafil_tc.R;

public class TabHostActivityLastDays extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_host_activity_last_days);
		TabHost tabHost = getTabHost();
		 Intent i;
        //Intent i;
         i= TabHostActivityLastDays.this.getIntent().setClass(this, BusInofmationActivityLastDays.class);
        i = new Intent().setClass(this, BusInofmationActivityLastDays.class);
        TabHost.TabSpec sp0 = tabHost.newTabSpec("Tab0");
        sp0.setIndicator("��������� ��������");
        sp0.setContent(i);
        tabHost.addTab(sp0);


        i = new Intent().setClass(this, DocumentsActivityLastDays.class);
        TabHost.TabSpec sp = tabHost.newTabSpec("Tab1");
        sp.setIndicator("المستندات");
        sp.setContent(i);
        tabHost.addTab(sp);

        i = new Intent().setClass(this, SecurityActivityLastDays.class);
        TabSpec sp2 = tabHost.newTabSpec("Tab2");
        sp2.setIndicator("الامن والسلامة");
        sp2.setContent(i);
        tabHost.addTab(sp2);

        i = new Intent().setClass(this, InternalBusActivityLastDays.class);
        TabSpec sp3 = tabHost.newTabSpec("Tab3");
        sp3.setIndicator("داخل الباص");
        sp3.setContent(i);
        tabHost.addTab(sp3);

        i = new Intent().setClass(this, ExternalBusActivityLastDays.class);
        TabSpec sp4 = tabHost.newTabSpec("Tab4");
        sp4.setIndicator("خارج الباص");
        sp4.setContent(i);
        tabHost.addTab(sp4);

        i = new Intent().setClass(this, MotorActivityActivityLastDays.class);
        TabSpec sp5 = tabHost.newTabSpec("Tab5");
        sp5.setIndicator("المحرك");
        sp5.setContent(i);
        tabHost.addTab(sp5);

        i = new Intent().setClass(this, OtherActivityActivityLastDays.class);
        TabSpec sp6 = tabHost.newTabSpec("Tab6");
        sp6.setIndicator("اخرى");
        sp6.setContent(i);
        tabHost.addTab(sp6);


        i = new Intent().setClass(this, GeneralNotesActivityLastDays.class);
        TabSpec sp7 = tabHost.newTabSpec("Tab7");
        sp7.setIndicator("الملاحظات");
        sp7.setContent(i);
        tabHost.addTab(sp7);


    }

}
