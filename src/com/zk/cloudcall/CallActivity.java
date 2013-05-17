package com.zk.cloudcall;

import com.android.internal.telephony.ITelephony;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CallActivity extends Activity{
	private TextView callnumber;
	private Button hangupcall;
	private Context context;
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call);
		
		Intent intentcallnumber=getIntent();
		String value = intentcallnumber.getStringExtra("callnumber");
		
		callnumber=(TextView)findViewById(R.id.call_number);
		callnumber.setText(value);
		hangupcall=(Button)findViewById(R.id.hangupcall);
		
		
//		Intent auto = new Intent();
//		auto.setClass(CallActivity.this, AutoAnswerCall.class);
//		CallActivity.this.startActivity(auto);
		
		hangupcall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent hangupintent = new Intent();
				hangupintent.setClass(CallActivity.this, MainActivity.class);
				CallActivity.this.startActivity(hangupintent);
				
				finish();
			}
		});
		
		
		
//			   case TelephonyManager.CALL_STATE_OFFHOOK:
//				   //据说该方法只能用于Android2.3及2.3以上的版本上，但在2.2上测试可以使用
//			        try  {
//			            Intent localIntent1 = new Intent(Intent.ACTION_HEADSET_PLUG);
//			            localIntent1.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//			            localIntent1.putExtra("state", 1);
//			            localIntent1.putExtra("microphone", 1);
//			            localIntent1.putExtra("name", "Headset");
//			            context.sendOrderedBroadcast(localIntent1, "android.permission.CALL_PRIVILEGED");
//			            Intent localIntent2 = new Intent(Intent.ACTION_MEDIA_BUTTON);
//			            KeyEvent localKeyEvent1 = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_HEADSETHOOK);
//			            localIntent2.putExtra("android.intent.extra.KEY_EVENT", localKeyEvent1);
//			            context.sendOrderedBroadcast(localIntent2, "android.permission.CALL_PRIVILEGED");
//			            Intent localIntent3 = new Intent(Intent.ACTION_MEDIA_BUTTON);
//			            KeyEvent localKeyEvent2 = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK);
//			            localIntent3.putExtra("android.intent.extra.KEY_EVENT", localKeyEvent2);
//			            context.sendOrderedBroadcast(localIntent3, "android.permission.CALL_PRIVILEGED");
//			            Intent localIntent4 = new Intent(Intent.ACTION_HEADSET_PLUG);
//			            localIntent4.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//			            localIntent4.putExtra("state", 0);
//			            localIntent4.putExtra("microphone", 1);
//			            localIntent4.putExtra("name", "Headset");
//			            context.sendOrderedBroadcast(localIntent4, "android.permission.CALL_PRIVILEGED");
//			      }  catch (Exception e)   {
//			            e.printStackTrace();
//			      }
//		new Thread(){  
//	        public void run(){  
//	            //sleep(5000);
//	            //refreshSthHere();
//	        }  
//	    }.start();  
//		
//				   Intent localIntent1 = new Intent(Intent.ACTION_HEADSET_PLUG);
////				   localIntent1.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
////				   localIntent1.putExtra("state", 1);
////				   localIntent1.putExtra("microphone", 1);
////				   localIntent1.putExtra("name", "Headset");
////				   CallActivity.this.sendOrderedBroadcast(localIntent1,"android.permission.CALL_PRIVILEGED");
////
////				   Intent localIntent2 = new Intent(Intent.ACTION_MEDIA_BUTTON);
////				   KeyEvent localKeyEvent1 = new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_HEADSETHOOK);
////				   localIntent2.putExtra("android.intent.extra.KEY_EVENT",localKeyEvent1);
////				   CallActivity.this.sendOrderedBroadcast(localIntent2,"android.permission.CALL_PRIVILEGED");
////
////				   Intent localIntent3 = new Intent(Intent.ACTION_MEDIA_BUTTON);
////				   KeyEvent localKeyEvent2 = new KeyEvent(KeyEvent.ACTION_UP,KeyEvent.KEYCODE_HEADSETHOOK);
////				   localIntent3.putExtra("android.intent.extra.KEY_EVENT",localKeyEvent2);
////				   CallActivity.this.sendOrderedBroadcast(localIntent3,"android.permission.CALL_PRIVILEGED");
////
////				   Intent localIntent4 = new Intent(Intent.ACTION_HEADSET_PLUG);
////				   localIntent4.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
////				   localIntent4.putExtra("state", 0);
////				   localIntent4.putExtra("microphone", 1);
////				   localIntent4.putExtra("name", "Headset");
////				   CallActivity.this.sendOrderedBroadcast(localIntent4,"android.permission.CALL_PRIVILEGED");
}
	
//	public void autoAnswerPhone() {   
//	    try {  
//	        ITelephony itelephony = getITelephony();  
//	        itelephony.silenceRinger();   
//	        itelephony.answerRingingCall();   
//	    } catch (Exception e) {//2.3以上执行以下代码实现自动接听  
//	        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");  
//	        KeyEvent keyEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_HEADSETHOOK);  
//	        intent.putExtra("android.intent.extra.KEY_EVENT",keyEvent);  
//	        context.sendOrderedBroadcast(intent,"android.permission.CALL_PRIVILEGED");  
//	        intent = new Intent("android.intent.action.MEDIA_BUTTON");  
//	        keyEvent = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK);  
//	        intent.putExtra("android.intent.extra.KEY_EVENT",keyEvent);  
//	        context.sendOrderedBroadcast(intent,"android.permission.CALL_PRIVILEGED");  
//	    }  
//	}

	private ITelephony getITelephony() {
		// TODO Auto-generated method stub
		return null;
	}
}
