package com.lazooz.lbm;

import com.lazooz.lbm.preference.MySharedPreferences;
import com.lazooz.lbm.utils.BBUncaughtExceptionHandler;
import com.lazooz.lbm.utils.Utils;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;

public class InfoActivity extends MyActionBarActivity {

	private Button nextBtn;
	private TextView mBuildNameTV;
	private TextView mBuildNumTV;
	private TextView mServerBuildNumTV;
	private TextView ver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Thread.setDefaultUncaughtExceptionHandler( new BBUncaughtExceptionHandler(this));
		String locale = InfoActivity.this.getResources().getConfiguration().locale.getLanguage();
	
		if  (locale.equalsIgnoreCase("he")||locale.equalsIgnoreCase("iw"))
			setContentView(R.layout.activity_info_rtf2);
		else
		    setContentView(R.layout.activity_info);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		Utils.setTitleColor(this, getResources().getColor(R.color.white));
		
		
		
		mBuildNameTV = (TextView)findViewById(R.id.build_name_tv);
		mBuildNumTV = (TextView)findViewById(R.id.build_num_tv);
		mServerBuildNumTV = (TextView)findViewById(R.id.server_build_num_tv);
		
		mBuildNameTV.setText(Utils.getVersionName(this));
		mBuildNumTV.setText(Utils.getVersionCode(this)+"");
		mServerBuildNumTV.setText(MySharedPreferences.getInstance().getServerVersion(this));
	}
	


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}

}
