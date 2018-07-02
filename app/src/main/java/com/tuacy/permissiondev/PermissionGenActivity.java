package com.tuacy.permissiondev;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tuacy.permissiondev.base.BaseAppActivity;

import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

public class PermissionGenActivity extends BaseAppActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, PermissionGenActivity.class));
	}

	private static final int CAMERA_PERMISSION = 100;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_permission_gen);
		//申请Manifest.permission.CAMERA权限
		PermissionGen.with(mActivity).addRequestCode(CAMERA_PERMISSION).permissions(Manifest.permission.CAMERA).request();
	}

	@PermissionSuccess(requestCode = CAMERA_PERMISSION)
	public void requestPhotoSuccess() {
		//申请权限成功
	}

	@PermissionFail(requestCode = CAMERA_PERMISSION)
	public void requestPhotoFail() {
		onBackPressed();
	}
}
