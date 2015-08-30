package net.cloud95.android.lession.dialog01;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Dialog01Activity extends Activity {

	private Button button02;
	private Button button03;
	private Button button04;
	private Button button05;
	private Button button06;

	private String[] items = { "Coffee", "Tea", "Water" };
	private boolean[] selection = { false, false, false };
	private int choice = -1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog01);

		processViews();
	}

	private void processViews() {
		button02 = (Button) findViewById(R.id.button02);
		button03 = (Button) findViewById(R.id.button03);
		button04 = (Button) findViewById(R.id.button04);
		button05 = (Button) findViewById(R.id.button05);
		button06 = (Button) findViewById(R.id.button06);
	}

	public void clickButton01(View view) {
		// 建立對話框物件並指定樣式
		AlertDialog.Builder d = new AlertDialog.Builder(Dialog01Activity.this,
				AlertDialog.THEME_HOLO_LIGHT);
		// 設定標題
		d.setTitle("Demo");
		// 設定訊息
		d.setMessage("Dialog01Activity");
		// 顯示對話框
		d.show();
	}

	public void clickButton02(View view) {
		// 建立對話框物件
		AlertDialog.Builder d = new AlertDialog.Builder(Dialog01Activity.this);
		// 設定標題、訊息與不可取消
		d.setTitle("Demo").setMessage("Are you hungry?").setCancelable(false);
		// 加入按鈕
		d.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				button02.setText("Yes");
			}
		});
		// 加入按鈕
		d.setNeutralButton("Maybe", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				button02.setText("Maybe");
			}
		});
		// 加入按鈕
		d.setNegativeButton("No", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				button02.setText("No");
			}
		});
		// 顯示對話框
		d.show();
	}

	public void clickButton03(View view) {
		// 建立對話框物件
		AlertDialog.Builder d = new AlertDialog.Builder(Dialog01Activity.this);
		// 設定標題與不可取消
		d.setTitle("Select.....").setCancelable(false);
		// 在內容顯示區設定選擇項目
		// 第一個參數為提供選項的字串陣列
		// 第二個參數為選擇選項後的事件控制
		d.setItems(items, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				button03.setText(items[which]);
			}
		});
		// 加入按鈕
		d.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				button02.setText("Yes");
			}
		});
		// 加入按鈕
		d.setNeutralButton("Maybe", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				button02.setText("Maybe");
			}
		});
		// 加入按鈕
		d.setNegativeButton("No", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				button02.setText("No");
			}
		});

		// 顯示對話框
		d.show();
	}

	public void clickButton04(View view) {
		// 建立對話框物件
		AlertDialog.Builder d = new AlertDialog.Builder(Dialog01Activity.this);
		// 設定標題
		d.setTitle("Select.....").setCancelable(false);
		// 設定單選項目
		// 第一個參數為提供選項的字串陣列
		// 第二個參數為對畫框出現時的預設選項，-1為沒有選擇
		// 第三個參數為選擇選項後的事件控制
		d.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {
			
			@Override
			//int值參數為操作的項目編號
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				choice= which;
			}
		});
		// 加入確認選擇的按鈕
		d.setPositiveButton("OK",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//choice就是使用者選擇項目的編號,還是-1的話表示沒有選擇
				if(choice != -1){
					button04.setText(items[choice]);
				}
			}
		});
		// 加入按鈕，事件指定為null值，表示不作任何事情，只會關閉對話框
		d.setNegativeButton("Cancel", null);
		// 顯示對話框
		d.show();
	}

	public void clickButton05(View view) {
		// 建立對話框物件
		AlertDialog.Builder d = new AlertDialog.Builder(Dialog01Activity.this);
		// 設定標題
		d.setTitle("Select.....");
		// 設定多選項目
		// 第一個參數為提供選項的字串陣列
		// 第二個參數為對畫框出現時的預設選項
		// 第三個參數為選擇選項後的事件控制
		d.setMultiChoiceItems(items, selection,new DialogInterface.OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				// TODO Auto-generated method stub
				//int值參數為操作的項目編號
				//boolean值參數為是否勾選
				selection[which] = isChecked;
			}
		});
		// 加入確認按鈕
		d.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				StringBuilder sb = new StringBuilder();
				
				for(int i=0; i<selection.length;i++){
					if(selection[i]){
						sb.append(items[i]+" ");
					}
				}
			}
		});
		// 顯示對話框
		d.show();
	}

	public void clickButton06(View view) {
		// 取得載入畫面配置資源用的物件
		LayoutInflater inflater = getLayoutInflater();
		// 載入對話框使用的畫面配置資源
		final View dialogView = inflater.inflate(R.layout.dialog_signin, null);
		// 建立對話框物件
		AlertDialog.Builder d = new AlertDialog.Builder(Dialog01Activity.this);
		// 設定對話框使用的畫面配置資源與標題
		d.setView(dialogView).setTitle("Sign in").setMessage("歡迎來到KUKA");
		// 加入登入按鈕
		d.setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//讀取帳號與密碼的元件
				EditText username = (EditText)dialogView.findViewById(R.id.username);
				EditText password = (EditText)dialogView.findViewById(R.id.password);
				button06.setText(username.getText()+":"+password.getText());
			}
		});
		// 加入取消按鈕
		d.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				button06.setText("Cancel");
			}
		});
		// 顯示對話框
		d.show();
	}

}
