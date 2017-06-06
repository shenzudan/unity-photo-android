package com.stanwind.unity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.roc.actionsheet.ActionSheet;
import com.roc.actionsheet.ActionSheet.MenuItemClickListener;
import com.unity3d.player.UnityPlayerActivity;

/**
 * Created by StanWind on 2017/6/3.
 */

public class UnityTestActivity extends UnityPlayerActivity implements MenuItemClickListener {
    Context mContext = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    //Unity中会调用这个方法，用于区分打开摄像机 开始本地相册
    public void TakePhoto(String str) {
    	setTheme(R.style.ActionSheetStyleIOS7);
    	ActionSheet menuView = new ActionSheet(this);
    	menuView.setSheetTitle("选择照片");
		menuView.setCancelButtonTitle("取消");// before add items
		menuView.addItems("拍照", "从相册选择");
		menuView.setItemClickListener(this);
		menuView.setCancelableOnTouchMenuOutside(true);
		menuView.showMenu();
    }

	@Override
	public void onItemClick(int itemPosition) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(mContext,WebViewActivity.class);
      
      if(itemPosition == 2){
    	  //相册
    	  intent.putExtra("type", "stan");
      }else{
    	  //拍照
    	  intent.putExtra("type", "takePhoto");   
   	  
      }
      mContext.startActivity(intent);
  }  
}
