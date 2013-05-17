package com.zk.cloudcall;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	
	public static final int PICK_CONTACT = 1;
	private EditText callnumber;
	private EditText myphonenumber;
	private Button maincall;
	private RadioButton tongdao1=null;
	private RadioButton tongdao2=null;
	private RadioGroup tongdao=null;
	private String chuanshutongdao="1007";
	private String wy;
	private Button button0;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button dialx;
	private Button dialj;
	private Button maindelete;
	private Button contacts;
	
	protected void onCreate(Bundle savedInstanceState) {
			//去除title    
	       	//requestWindowFeature(Window.FEATURE_NO_TITLE);    
	        //全屏
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);  
        
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		contacts = (Button)findViewById(R.id.contacts);
		callnumber = (EditText)findViewById(R.id.callnumber);
		myphonenumber = (EditText)findViewById(R.id.mynumber);
		button0 = (Button)findViewById(R.id.dialNum0);
		button1 = (Button)findViewById(R.id.dialNum1);
		button2 = (Button)findViewById(R.id.dialNum2);
		button3 = (Button)findViewById(R.id.dialNum3);
		button4 = (Button)findViewById(R.id.dialNum4);
		button5 = (Button)findViewById(R.id.dialNum5);
		button6 = (Button)findViewById(R.id.dialNum6);
		button7 = (Button)findViewById(R.id.dialNum7);
		button8 = (Button)findViewById(R.id.dialNum8);
		button9 = (Button)findViewById(R.id.dialNum9);
		dialx = (Button)findViewById(R.id.dialx);
		dialj = (Button)findViewById(R.id.dialj);
		maincall = (Button)findViewById(R.id.mainCall);
		maindelete = (Button)findViewById(R.id.delete);
		
		//myphonenumber.setText(tm.getLine1Number());
	
		tongdao1=(RadioButton) super.findViewById(R.id.tongdao1);
		tongdao2=(RadioButton) super.findViewById(R.id.tongdao2);;
		tongdao = (RadioGroup) super.findViewById(R.id.tongdao);
		
		callnumber.addTextChangedListener(mTextWatcher);  
		myphonenumber.addTextChangedListener(mPhoneWatcher);
		
		
		contacts.setOnClickListener(new Button.OnClickListener(){ 
			 
		    @Override 
		    public void onClick(View v) { 
		        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI); 
		 
		        MainActivity.this.startActivityForResult(intent, 1); 
		    } 
		     
		}); 
		
		tongdao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(tongdao1.getId()==checkedId){
					chuanshutongdao ="1007";
				}else if(tongdao2.getId()==checkedId){
					chuanshutongdao ="1002";
				}
			}
		});
		
		callnumber.setOnTouchListener(new OnTouchListener() {  
            
            public boolean onTouch(View v, MotionEvent event) { 
            	//4.0版本不允许在主线程中进行网络通讯
                int inType = callnumber.getInputType();
                callnumber.setInputType(InputType.TYPE_NULL);
                callnumber.onTouchEvent(event);
                callnumber.setInputType(inType);
                callnumber.setSelection(callnumber.getText().length());
        		button0.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				callnumber.getText().insert(callnumber.getSelectionEnd(), "0");
        			}
        		});
        		button1.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				callnumber.getText().insert(callnumber.getSelectionEnd(), "1");
        			}
        		});
        		button2.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				callnumber.getText().insert(callnumber.getSelectionEnd(), "2");
        			}
        		});
        		button3.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				callnumber.getText().insert(callnumber.getSelectionEnd(), "3");
        			}
        		});
        		button4.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				callnumber.getText().insert(callnumber.getSelectionEnd(), "4");
        			}
        		});
        		button5.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				callnumber.getText().insert(callnumber.getSelectionEnd(), "5");
        			}
        		});
        		button6.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				callnumber.getText().insert(callnumber.getSelectionEnd(), "6");
        			}
        		});
        		button7.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				callnumber.getText().insert(callnumber.getSelectionEnd(), "7");
        			}
        		});
        		button8.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				callnumber.getText().insert(callnumber.getSelectionEnd(), "8");
        			}
        		});
        		button9.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				callnumber.getText().insert(callnumber.getSelectionEnd(), "9");
        			}
        		});
        		dialx.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				callnumber.getText().insert(callnumber.getSelectionEnd(), "*");
        			}
        		});
        		dialj.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				callnumber.getText().insert(callnumber.getSelectionEnd(), "#");
        			}
        		});
        		maindelete.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				int length=callnumber.length();
                        if(length>0){
                        	callnumber.getText().delete(length-1, length);
                        }
        			}
        		});
                return true;  
            }  
        }); 
		
		myphonenumber.setOnTouchListener(new OnTouchListener() {  
            
            public boolean onTouch(View v, MotionEvent event) {  
                int inType = myphonenumber.getInputType();
                myphonenumber.setInputType(InputType.TYPE_NULL);
                myphonenumber.onTouchEvent(event);
                myphonenumber.setInputType(inType);
                myphonenumber.setSelection(myphonenumber.getText().length());
        		button0.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				myphonenumber.getText().insert(myphonenumber.getSelectionEnd(), "0");
        			}
        		});
        		button1.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				myphonenumber.getText().insert(myphonenumber.getSelectionEnd(), "1");
        			}
        		});
        		button2.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				myphonenumber.getText().insert(myphonenumber.getSelectionEnd(), "2");
        			}
        		});
        		button3.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				myphonenumber.getText().insert(myphonenumber.getSelectionEnd(), "3");
        			}
        		});
        		button4.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				myphonenumber.getText().insert(myphonenumber.getSelectionEnd(), "4");
        			}
        		});
        		button5.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				myphonenumber.getText().insert(myphonenumber.getSelectionEnd(), "5");
        			}
        		});
        		button6.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				myphonenumber.getText().insert(myphonenumber.getSelectionEnd(), "6");
        			}
        		});
        		button7.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				myphonenumber.getText().insert(myphonenumber.getSelectionEnd(), "7");
        			}
        		});
        		button8.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				myphonenumber.getText().insert(myphonenumber.getSelectionEnd(), "8");
        			}
        		});
        		button9.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				myphonenumber.getText().insert(myphonenumber.getSelectionEnd(), "9");
        			}
        		});
        		dialx.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				myphonenumber.getText().insert(myphonenumber.getSelectionEnd(), "*");
        			}
        		});
        		dialj.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				myphonenumber.getText().insert(myphonenumber.getSelectionEnd(), "#");
        			}
        		});
        		maindelete.setOnClickListener(new OnClickListener() {
        			public void onClick(View v) {
        				int length=myphonenumber.length();
                        if(length>0){
                        	//从编辑框的末尾逐个删除
                        	myphonenumber.getText().delete(length-1, length);
                        }
        			}
        		});
                return true;  
            }});
		
		//tcp通信过程
				maincall.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					
				//4.0版本不允许在主线程中进行网络通讯
					StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()  
			        .detectDiskReads()  
			        .detectDiskWrites()  
			        .detectNetwork()  
			        .penaltyLog()  
			        .build());  
					StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()  
			        .detectLeakedSqlLiteObjects()  
			        .detectLeakedClosableObjects()  
			        .penaltyLog()  
			        .penaltyDeath()  
			        .build());  
				try {
					
				Socket s = new Socket("111.10.24.178",7171 );//创建一个socket对象，绑定要通信的服务器端Ip和端口
				OutputStream out = s.getOutputStream();//将要传递的数据进行字节数组处理，然后以输出流的形式发送出去
				wy ="0"+","+chuanshutongdao+","+"100"+","+myphonenumber.getText().toString()+","+callnumber.getText().toString()+"##";
				out.write(wy.getBytes());
				Toast.makeText(MainActivity.this, "正在连接中，请稍后···", Toast.LENGTH_SHORT).show();
				out.flush();
				
				Intent intentcallnumber = new Intent();
				intentcallnumber.putExtra("callnumber", callnumber.getText().toString());
				intentcallnumber.setClass(MainActivity.this, CallActivity.class);
				MainActivity.this.startActivity(intentcallnumber);
				finish();
				}
				catch (UnknownHostException e) {
				e.printStackTrace();
				} catch (IOException e) {
				e.printStackTrace();
				}
				}
		});
	}
	
	@Override 
	protected void onActivityResult(int requestCode, int resultCode, Intent data) { 
	    super.onActivityResult(requestCode, resultCode, data); 
	    switch(requestCode) 
	    { 
	        case (1) : 
	        { 
	        if (resultCode == Activity.RESULT_OK) 
	        { 
	        Uri contactData = data.getData(); 
	 
	        Cursor c = managedQuery(contactData, null, null, null, null); 
	 
	        c.moveToFirst(); 
	 
	        String phoneNum=this.getContactPhone(c); 
	        callnumber.setText(phoneNum); 
	        callnumber.setSelection(phoneNum.length());
	        } 
	        
	        break; 
	        } 
	    } 
	}
	
	private String getContactPhone(Cursor cursor) 
	{ 
	 
	    int phoneColumn = cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);   
	    int phoneNum = cursor.getInt(phoneColumn);  
	    String phoneResult=""; 
	    //System.out.print(phoneNum); 
	    if (phoneNum > 0) 
	    { 
	    // 获得联系人的ID号 
	        int idColumn = cursor.getColumnIndex(ContactsContract.Contacts._ID); 
	        String contactId = cursor.getString(idColumn); 
	        
	            // 获得联系人的电话号码的cursor; 
	            Cursor phones = getContentResolver().query( 
	            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
	            null, 
	            ContactsContract.CommonDataKinds.Phone.CONTACT_ID+ " = " + contactId,  
	            null, null); 
	            
//	            int phoneCount = phones.getCount(); 
//	            allPhoneNum = new ArrayList<String>(phoneCount); 
	            if (phones.moveToFirst()) 
	            { 
	                    // 遍历所有的电话号码 
	                    for (;!phones.isAfterLast();phones.moveToNext()) 
	                    {                                             
	                        int index = phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER); 
	                        int typeindex = phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE); 
	                        int phone_type = phones.getInt(typeindex); 
	                        String phoneNumber = phones.getString(index); 
	                        switch(phone_type) 
	                        { 
	                            case 2: 
	                                phoneResult=phoneNumber; 
	                            break; 
	                        } 
	                           //allPhoneNum.add(phoneNumber); 
	                    } 
	                    if (!phones.isClosed()) 
	                    { 
	                           phones.close(); 
	                    } 
	            } 
	    } 
	    return phoneResult; 
	}
	
	
	//对myphonenumber和callnumber两个编辑框进行监控，改变默认字体
	TextWatcher mTextWatcher = new TextWatcher() {  
        private CharSequence temp;  
        @Override  
        public void onTextChanged(CharSequence s, int start, int before, int count) {  
             temp = s;  
        }  
        @Override  
        public void beforeTextChanged(CharSequence s, int start, int count,  
                int after) {  
        }  
        @Override  
        public void afterTextChanged(Editable s) {  
            if (temp.length()==0) {  
                callnumber.setTextSize(20);
            }else{
            	callnumber.setTextSize(40);
            } 
        }  
    }; 
    TextWatcher mPhoneWatcher = new TextWatcher() {  
        private CharSequence temp;  
        @Override  
        public void onTextChanged(CharSequence s, int start, int before, int count) {  
             temp = s;  
        }  
          
        @Override  
        public void beforeTextChanged(CharSequence s, int start, int count,  
                int after) {  
        }  
        @Override  
        public void afterTextChanged(Editable s) {  
            if (temp.length()==0) {  
                myphonenumber.setTextSize(20);
            }else{
            	myphonenumber.setTextSize(40);
            } 
        }  
    };
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
