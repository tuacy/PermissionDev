package com.tuacy.permissiondev;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		findViewById(R.id.button_permission_wrap).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				PermissionWrapActivity.startUp(mContext);
			}
		});

		findViewById(R.id.button_permission_gen).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				PermissionGenActivity.startUp(mContext);
			}
		});
	}


}
