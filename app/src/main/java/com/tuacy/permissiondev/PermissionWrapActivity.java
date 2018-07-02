package com.tuacy.permissiondev;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.tuacy.permissiondev.permission.PermissionHelper;
import com.tuacy.permissiondev.permission.PermissionInterface;

public class PermissionWrapActivity extends AppCompatActivity implements PermissionInterface {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, PermissionWrapActivity.class));
	}

	private PermissionHelper mPermissionHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_permission_wrap);
		mPermissionHelper = new PermissionHelper(this, this);
		mPermissionHelper.requestPermissions();
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		if (mPermissionHelper.requestPermissionsResult(requestCode, permissions, grantResults)) {
			//权限请求结果，并已经处理了该回调
			return;
		}
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}

	@Override
	public int getPermissionsRequestCode() {
		//设置权限请求requestCode，只有不跟onRequestPermissionsResult方法中的其他请求码冲突即可。
		return 10000;
	}

	@Override
	public String[] getPermissions() {
		//设置该界面所需的全部权限
		return new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
							Manifest.permission.READ_PHONE_STATE};
	}

	@Override
	public void requestPermissionsSuccess() {
		//权限请求用户已经全部允许
		initViews();
	}

	@Override
	public void requestPermissionsFail() {
		//权限请求不被用户允许。可以提示并退出或者提示权限的用途并重新发起权限申请。
		onBackPressed();
	}

	private void initViews() {
		//已经拥有所需权限，可以放心操作任何东西了

	}
}
