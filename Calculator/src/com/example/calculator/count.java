package com.example.calculator;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

	public class count extends Activity{
		String answer="";
		int a=1;
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.login);
			TextView viewx=(TextView)findViewById(R.id.x);
			TextView viewY=(TextView)findViewById(R.id.Y);
			viewx.setText("x");
			viewY.setText("Y");
			final EditText EditText1=(EditText)findViewById(R.id.lownumber);
		    final EditText EditText2=(EditText)findViewById(R.id.upnumber);
		    final TextView textview=(TextView)findViewById(R.id.result);
		   
		    Button bncount=(Button)findViewById(R.id.count);
		    Button bnok=(Button)findViewById(R.id.ok);
		    Button bncancel=(Button)findViewById(R.id.cancel);
		    
		    bncount.setOnClickListener(new OnClickListener(){
		    	public void onClick(View source){
		    		String putlownumber=EditText1.getText().toString();
		    		String putupnumber=EditText2.getText().toString();
		    		//String whole=layout.getContext().toString();
		    		a=1;
		    		char [] stringArr = putlownumber.toCharArray();
		    		char [] stringArr1 = putupnumber.toCharArray();
		    		for(int i=0;i<stringArr.length;i++)
		    		{
		    			if(stringArr[i]=='.')
		    			{
		    				if(i==stringArr.length-1)
		    				{
			    				a=0;
			    				answer="error";
			    				textview.setText(answer);
			    				break;
		    				}
		    				if(i==0)
		    				{
			    				a=0;
			    				answer="error";
			    				textview.setText(answer);
			    				break;
		    				}
		    				else
		    				{
		    					if(stringArr[i+1]>'9'||stringArr[i+1]<'0')
		    					{
		    						a=0;
				    				answer="error";
				    				textview.setText(answer);
				    				break;
			    				}
		    				}
		    				continue;
		    			}
		    			if((stringArr[i]>'9')||((stringArr[i]<'0')&&(stringArr[i]!='.')))
		    			{
		    				a=0;
		    				answer="error";
		    				textview.setText(answer);
		    				break;
		    			}
		    		}
		    		
		    		for(int i=0;i<stringArr1.length;i++)
		    		{
		    			if(stringArr1[i]=='.')
		    			{
		    				if(i==stringArr1.length-1)
		    				{
		    					a=0;
			    				answer="error";
			    				textview.setText(answer);
			    				break;
		    				}
		    				if(i==0)
		    				{
			    				a=0;
			    				answer="error";
			    				textview.setText(answer);
			    				break;
		    				}
		    				else
		    				{
		    					if(stringArr1[i+1]>'9'||stringArr1[i+1]<'0')
		    					{
		    						a=0;
				    				answer="error";
				    				textview.setText(answer);
				    				break;
			    				}
		    				}
		    				continue;
		    			}
		    			if((stringArr1[i]>'9')||((stringArr1[i]<'0')&&(stringArr[i]!='.')))
		    			{
		    				a=0;
		    				answer="error";
		    				textview.setText(answer);
		    				break;
		    			}
		    		}
		    		
		    		if(a==1)
		    		{
		    			TextView viewx=(TextView)findViewById(R.id.x);
		    			TextView viewY=(TextView)findViewById(R.id.Y);
		    			TextView viewlog=(TextView)findViewById(R.id.log);
		    			viewx.setText(putlownumber);
		    			viewY.setText(putupnumber);
		    			double temp=0;
		    			temp=(Math.log(Double.valueOf(putupnumber)))/(Math.log(Double.valueOf(putlownumber)));
		    			temp=((double)Math.round(temp*100000000)/100000000);
		    			answer=String.valueOf(temp);
		    			textview.setText(String.valueOf(answer));
		    		}
		    	}
		    });
		    bncancel.setOnClickListener(new OnClickListener(){
		    	public void onClick(View source){
		    		TextView viewx=(TextView)findViewById(R.id.x);
	    			TextView viewY=(TextView)findViewById(R.id.Y);
	    			viewx.setText("x");
	    			viewY.setText("Y");
		    		EditText1.setText("");
		    		EditText2.setText("");
		    		textview.setText("");
		    	}
		    });
		    bnok.setOnClickListener(new OnClickListener(){
		    	public void onClick(View source){
		    		Intent intent=getIntent();
		    		Bundle data=new Bundle();
	    		    data.putString("finalanswer", String.valueOf(answer));
	    			intent.putExtras(data);
		    		count.this.setResult(0,intent);
		    		count.this.finish();
		    	}
		    });
		}
	    public boolean onKeyDown(int keyCode, KeyEvent event)  
	    {  
	        if(keyCode == KeyEvent.KEYCODE_BACK){  
	            Intent myIntent = new Intent();  
	            myIntent = new Intent(count.this, MainActivity.class);  
	            startActivity(myIntent);  
	            this.finish();  
	        }  
	        return super.onKeyDown(keyCode, event);  
	    } 
	}

