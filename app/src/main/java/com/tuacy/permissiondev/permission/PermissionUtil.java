package com.tuacy.permissiondev.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;

public class PermissionUtil {

	/**
	 * 判断是否有某个权限
	 */
	public static boolean hasPermission(Context context, String permission) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			return context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
		}
		return true;
	}

	/**
	 * 弹出对话框请求权限
	 */
	public static void requestPermissions(Activity activity, String[] permissions, int requestCode) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			ActivityCompat.requestPermissions(activity, permissions, requestCode);
		}
	}

	/**
	 * 返回缺失的权限
	 *
	 * @return 返回缺少的权限，null 意味着没有缺少权限
	 */
	public static String[] getDeniedPermissions(Context context, String[] permissions) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			ArrayList<String> deniedPermissionList = new ArrayList<>();
			for (String permission : permissions) {
				if (context.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
					deniedPermissionList.add(permission);
				}
			}
			int size = deniedPermissionList.size();
			if (size > 0) {
				return deniedPermissionList.toArray(new String[deniedPermissionList.size()]);
			}
		}
		return null;
	}

}
