package com.example.calculator;

import java.util.Stack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    String []arrs=new String[80];
    String []crrs=new String[80];
    String brrs="";
    String []trrs=new String[80];
    Stack<String> stack=new Stack<String>();
    int i=0,temporary=0,watchpoint=0,watchtext=0;  //watchpoint观察"."的输入watchpoint=0是打开锁可以按动".",watchTest观察的变换
	
    public void onCreate(Bundle savedInstanceState) {
		for(int i=0;i<80;i++){
			arrs[i]="t";
			crrs[i]="t";
			trrs[i]="t";
		}
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		DisplayMetrics  dm = new DisplayMetrics();   
		getWindowManager().getDefaultDisplay().getMetrics(dm); 
		double screenheight = dm.heightPixels; 
		final TextView viewout=(TextView)findViewById(R.id.view);
      	viewout.setHeight((int) (screenheight*0.43*0.5));
		final TextView viewout1=(TextView)findViewById(R.id.view1);
		viewout.setHeight((int) (screenheight*0.43*0.5));
		
		Button bn0=(Button)findViewById(R.id.zero);
		bn0.setHeight((int) (screenheight*0.6*0.15));
		
		Button bn1=(Button)findViewById(R.id.one);
		bn1.setHeight((int) (screenheight*0.6*0.15));
		
		Button bn2=(Button)findViewById(R.id.two);
		bn2.setHeight((int) (screenheight*0.6*0.15));
		
		Button bn3=(Button)findViewById(R.id.three);
		bn3.setHeight((int) (screenheight*0.6*0.15));
		
		Button bn4=(Button)findViewById(R.id.four);
		bn4.setHeight((int) (screenheight*0.6*0.15));
		
		Button bn5=(Button)findViewById(R.id.five);
		bn5.setHeight((int) (screenheight*0.6*0.15));
		
		Button bn6=(Button)findViewById(R.id.six);
		bn6.setHeight((int) (screenheight*0.6*0.15));
		
		Button bn7=(Button)findViewById(R.id.seven);
		bn7.setHeight((int) (screenheight*0.6*0.15));
		
		Button bn8=(Button)findViewById(R.id.eight);
		bn8.setHeight((int) (screenheight*0.6*0.15));
		
		Button bn9=(Button)findViewById(R.id.nine);
		bn9.setHeight((int) (screenheight*0.6*0.15));
		
		Button bnleftbracket=(Button)findViewById(R.id.leftbracket);
		bnleftbracket.setHeight((int) (screenheight*0.6*0.15));
		
		Button bnrightbracket=(Button)findViewById(R.id.rightbracket);
		bnrightbracket.setHeight((int) (screenheight*0.6*0.15));
		
		Button bnplus=(Button)findViewById(R.id.plus);
		bnplus.setHeight((int) (screenheight*0.6*0.15));
		
		Button bnminus=(Button)findViewById(R.id.minus);
		bnminus.setHeight((int) (screenheight*0.6*0.15));
		
		Button bntimes=(Button)findViewById(R.id.times);
		bntimes.setHeight((int) (screenheight*0.6*0.15));
		
		Button bnpower=(Button)findViewById(R.id.power);
		bnpower.setHeight((int) (screenheight*0.6*0.15));
		
		Button bndivided=(Button)findViewById(R.id.divided);
		bndivided.setHeight((int) (screenheight*0.6*0.15));
		
		Button bnClear=(Button)findViewById(R.id.C);
		bnClear.setHeight((int) (screenheight*0.6*0.15));
		
		Button bndelete=(Button)findViewById(R.id.delete);
		bndelete.setHeight((int) (screenheight*0.6*0.15));
		
		Button bnequals=(Button)findViewById(R.id.equal);
	    bnequals.setHeight((int) (screenheight*0.6*0.15));
		
	    Button bnpoint=(Button)findViewById(R.id.point);
	    bnpoint.setHeight((int) (screenheight*0.6*0.15));
		
	    Button bnsin=(Button)findViewById(R.id.sin);
	    bnsin.setHeight((int) (screenheight*0.6*0.15));
	   
	    Button bncos=(Button)findViewById(R.id.cos);
	    bncos.setHeight((int) (screenheight*0.6*0.15));
	    
	    Button bntan=(Button)findViewById(R.id.tan);
	    bntan.setHeight((int) (screenheight*0.6*0.15));
	    
	    Button bnlog=(Button)findViewById(R.id.log);
	    bnlog.setHeight((int) (screenheight*0.6*0.15));
	    
	    Button bnlg=(Button)findViewById(R.id.lg);
	    bnlg.setHeight((int) (screenheight*0.6*0.15));
	    
	    Button bnln=(Button)findViewById(R.id.ln);
	    bnln.setHeight((int) (screenheight*0.6*0.15));
	   
	    Button bnpi=(Button)findViewById(R.id.Pi);
	    bnpi.setHeight((int) (screenheight*0.6*0.15));
	   
	    bnpower.setOnClickListener(new MyButton());
		
	    bnsin.setOnClickListener(new MyButton());
		bncos.setOnClickListener(new MyButton());
		bntan.setOnClickListener(new MyButton());
		bn0.setOnClickListener(new MyButton());
		bn1.setOnClickListener(new MyButton());
		bn2.setOnClickListener(new MyButton());
		bn3.setOnClickListener(new MyButton());
		bn4.setOnClickListener(new MyButton());
		bn5.setOnClickListener(new MyButton());
		bn6.setOnClickListener(new MyButton());
		bn7.setOnClickListener(new MyButton());
		bn8.setOnClickListener(new MyButton());
		bn9.setOnClickListener(new MyButton());
        bnplus.setOnClickListener(new MyButton());
        bnminus.setOnClickListener(new MyButton());
        bntimes.setOnClickListener(new MyButton());
        bndivided.setOnClickListener(new MyButton());
        bnrightbracket.setOnClickListener(new MyButton());
        bnleftbracket.setOnClickListener(new MyButton());
        bnlg.setOnClickListener(new MyButton());
        bnln.setOnClickListener(new MyButton());
        bnpi.setOnClickListener(new MyButton());
        bnlog.setOnClickListener(new OnClickListener(){
        	public void onClick(View source){
        		Intent intent=new Intent(MainActivity.this,count.class);
				startActivityForResult(intent,0);
        	}
        });
        
        bnpoint.setOnClickListener(new OnClickListener()
		{
			public void onClick(View source)
			{
	    	    if(watchtext==1)
	    	    	viewout1.setText(getStringByArray(crrs));
	    	        
	    	    else{
	    	    	viewout1.setText("");
	    	    }
	    	    if(temporary==1)
	    	    {
	    			for(int m=0;m<arrs.length;m++) 
	    			{
				        arrs[m]="t";
				        trrs[m]="t";
				    }
	    			i=0;
	    			temporary=0;
	    			arrs[i]=String.valueOf(brrs);
	    			i=i+1;
	    		}
	    		
	    		if((watchpoint==1)&&(temporary==0)){
	    			 viewout.setText(getStringByArray(arrs));
	    		}
	    		
	    		else if(temporary==2)
	    		{
					for(int m=0;m<arrs.length;m++) 
					{
				        arrs[m]="t";
				    }
					i=0;
					temporary=0;
					arrs[i]="0";
					watchpoint=0;
					viewout.setText(getStringByArray(arrs));
				}
	    		
	    		else if(i==0)
	    		{
	    			arrs[i]="0";
	    			i=i+1;
	    			arrs[i]=".";
	    			i=i+1;
	    			watchpoint=1;
	    			viewout.setText(getStringByArray(arrs));
	    		}
	    		else
	    		{    
	    		    arrs[i]=".";
	    		    watchpoint=1;
		    		viewout.setText(getStringByArray(arrs));
		    		i++;
    		    }
    	   }
		});
		bnequals.setOnClickListener(new OnClickListener(){
			public void onClick(View source){
				//打印上个等式
				watchtext=1;
				for(i=0;i<80;i++){
					crrs[i]=arrs[i];
				}
				viewout1.setText(getStringByArray(crrs));
				
				int n=0,n0=0;
				while(!arrs[n].equals("t"))
				   {
					   if(arrs[n].equals("pi"))
					   {
						   if(n==0)
						   {
							   //看pi后面的数
							   if((arrs[n+1].compareTo("0")>=0&&arrs[n+1].compareTo("9")<=0)||(arrs[n+1].equals(".")))
							   {
								   trrs[n0]=arrs[n];
								   trrs[n0+1]="*";
								   n++;
								   n0=n0+2;
							   }
							   else
							   {
								   trrs[n0]=arrs[n];
					   			   n++;
					   			   n0++;
							   }
						   }
						   else
						   {
							   //讨论pi在最后一个，后面是"t"
							   if(arrs[n+1].equals("t"))
							   {
								   if((arrs[n-1].compareTo("0")>=0&&arrs[n-1].compareTo("9")<=0)||(arrs[n-1].equals("."))||(arrs[n-1].equals("pi")))
								   {
									   trrs[n0]="*";
									   trrs[n0+1]=arrs[n];
									   n++;
									   n0++;
								   }
								   else
								   {
									   trrs[n0]=arrs[n];
						   			   n++;
						   			   n0++;
								   }
							   }
							   //讨论pi不在最后一个的情况
							   else
							   {
								   if((arrs[n-1].compareTo("0")>=0&&arrs[n-1].compareTo("9")<=0)||(arrs[n-1].equals("."))||(arrs[n-1].equals("pi")))
								   {
									   trrs[n0]="*";
									   trrs[n0+1]=arrs[n];
									   n0=n0+2;
									   n++;
								   }
								   else
								   {
									   trrs[n]=arrs[n];
									   n0++;
									   n++;
								   }
								   //看pi后面的数
								   if((arrs[n].compareTo("0")>=0&&arrs[n].compareTo("9")<=0)||(arrs[n].equals("."))||(arrs[n].equals("pi")))
								   {
									   trrs[n0]="*";
									   trrs[n0+1]=arrs[n];
									   n0=n0+2;
									   n++;
								   }
								   else
								   {
									   trrs[n0]=arrs[n];
						   			   n0++;
						   			   n++;
								   } 
								   
							   }
						   }
					   }
					   else
					   {
						   trrs[n0]=arrs[n];
						   n++;
						   n0++;
					   }
				   }
				
				for(int j,t,k=0,i=0;i<80;)
				  {
					 
					  //添加sin(,cos(,tan(
					  if((trrs[i].equals("sin("))||(trrs[i].equals("cos("))||(trrs[i].equals("tan("))||(trrs[i].equals("lg("))||(trrs[i].equals("ln(")))
					  {
						  trrs[k]=trrs[i];
					      i++;
			 		      k++;
			 		      continue;
					  } 
					
					  //添加^
					  if(trrs[i].equals("^"))
					  {
						  trrs[k]=trrs[i];
					      i++;
			 		      k++;
			 		      continue;
					  }
					  
					  if(trrs[i].equals("pi"))
					  {
						  trrs[k]=trrs[i];
					      i++;
			 		      k++;
			 		      continue;
					  }
					//处理第一个字符串是+，-，*，/ 
					  if(((i==0)&&(trrs[i].equals("+")))||((i==0)&&(trrs[i].equals("-")))||((i==0)&&(trrs[i].equals("*")))||((i==0)&&(trrs[i].equals("^")))||((i==0)&&(trrs[i].equals("/")))){
						  String temp="";
						  String temp1="";
						  String temp2="";
						  for(i=0;i<79;i++){
							  if(i==0){
								  temp=trrs[i];
								  trrs[i]="0";
								  temp1=trrs[i+1];
								  trrs[i+1]=temp;
							  }
							  else{
								  temp2=trrs[i+1];
								  trrs[i+1]=temp1;
								  temp1=temp2;
							  }
						  }
					      
						  i=0;
					     continue;
					  }
					//将多个数字字符串合并成一个字符串    
					  if((trrs[i].compareTo("0")>=0)&&(trrs[i].compareTo("9")<=0))
					  {
						  double temp=0;
						  for(j=0,t=i;t<80;t++,j++)
						  { 
							  if(((trrs[t].compareTo("0")<0)&&(trrs[t].compareTo(".")!=0))||(trrs[t].equals("sin("))||(trrs[t].equals("cos("))||(trrs[t].equals("tan("))||(trrs[t].equals("^"))||(trrs[t].equals("lg("))||(trrs[t].equals("ln(")))        //添加sin,cos需要再这里修改
						      {
						    	  break;
						      }
						      else if(trrs[t].compareTo(".")==0)
						      {
						    	  double tmd=0;
						    	  t++;
						    	  int jb=0;
						    	  for(;t<80;t++,jb++)
						    	  {
						    		  if((trrs[t].compareTo("0")<0)||(trrs[t].equals("sin("))||(trrs[t].equals("cos("))||(trrs[t].equals("tan("))||(trrs[t].equals("^"))||(trrs[t].equals("lg("))||(trrs[t].equals("ln(")))   //添加sin,cos,tan,需要修改
						    			  break;
						    		  else if(trrs[t].equals("t"))
						    			  break;
						    		  else
						    			  tmd=tmd*10+Double.valueOf(trrs[t]);
						    	  }
						          temp=temp+tmd*(Math.pow(10,-jb));
						          j=j+jb+1;
						          break;
						      }
						      else if(trrs[t].equals("t"))
						    	  break;
						      else 
						    	  temp=temp*10+ Double.valueOf(trrs[t]);	  
						    }
					     trrs[k]=String.valueOf(temp);  
					     i=i+j;
					     k++;
					  }
					  //处理前一个符号是右括号，后一个符号是+，-
					  if(((trrs[i].equals("+"))&&(trrs[i-1].equals("(")))||((trrs[i].equals("-"))&&(trrs[i-1].equals("(")))||((trrs[i].equals("-"))&&(trrs[i-1].equals("sin(")))||((trrs[i].equals("+"))&&(trrs[i-1].equals("sin(")))||((trrs[i].equals("+"))&&(trrs[i-1].equals("cos(")))||((trrs[i].equals("-"))&&(trrs[i-1].equals("cos(")))||((trrs[i].equals("+"))&&(trrs[i-1].equals("tan(")))||((trrs[i].equals("+"))&&(trrs[i-1].equals("lg(")))||((trrs[i].equals("-"))&&(trrs[i-1].equals("lg(")))||((trrs[i].equals("+"))&&(trrs[i-1].equals("ln(")))||((trrs[i].equals("-"))&&(trrs[i-1].equals("ln(")))||((trrs[i].equals("-"))&&(trrs[i-1].equals("tan("))))    //需要添加其他符号的这里需要修改
				  	  {
						  String temp="";
						  String temp1="";
						  String temp2="";
						  int change0=i;  //寄存变量i的值
						  int change=0;  //监视变量，观察+，-号前符号是否是(
						  for(;i<79;i++){
							  if(change==0){
								  temp=trrs[i];
								  trrs[i]="0";
								  temp1=trrs[i+1];
								  trrs[i+1]=temp;
							      change=1;
							  }
							  else{
								  temp2=trrs[i+1];
								  trrs[i+1]=temp1;
								  temp1=temp2;
							  }
						  }
					     i=change0;
					     continue;  
					  }
					 //处理。 
					  if(trrs[i].compareTo(".")==0){
						  double tmd=0;
				    	  i++;
				    	  int jb=0;
				    	  for(;i<80;i++,jb++){
				    		  if((trrs[i].compareTo("0")<0)||(trrs[i].equals("sin("))||(trrs[i].equals("cos("))||(trrs[i].equals("tan("))||(trrs[i].equals("^"))||(trrs[i].equals("lg("))||(trrs[i].equals("ln(")))   //添加sin,cos,tan,需要修改
				    			  break;
				    		  else if(trrs[i].equals("t"))
				    			  break;
				    		  else
				    			  tmd=tmd*10+Double.valueOf(trrs[i]);
				    	  }
				          tmd=tmd*(Math.pow(10,-jb));
				          trrs[k]=String.valueOf(tmd); 
				          k++;
				      }
					  //添加()
					  else
					  {
						  trrs[k]=trrs[i];
					      i++;
					      k++;
					  }
				  }
				viewout.setText(getAnswer(trrs));
			}
           
			private String getAnswer(String[] arrs) 
			{
				int m=0;
				
				for(int i=0;i<arrs.length;i++)
				{
					if(i!=0)
					{
						if(((arrs[i].equals("("))&&(arrs[i-1].compareTo("0")>=0)&&(!arrs[i-1].equals("sin("))&&(!arrs[i-1].equals("cos("))&&(!arrs[i-1].equals("^"))&&(!arrs[i-1].equals(")"))&&(!arrs[i-1].equals("lg("))&&(!arrs[i-1].equals("ln("))&&(!arrs[i-1].equals("tan(")))||((arrs[i].equals("("))&&(arrs[i+1].equals(")"))))  //(前面不能是数字，后面不能紧跟)
							{
							 temporary=2;
							 return brrs="error";
							}
						if(((arrs[i].equals("sin("))&&(arrs[i-1].compareTo("0")>=0)&&(!arrs[i-1].equals("sin("))&&(!arrs[i-1].equals("cos("))&&(!arrs[i-1].equals("^"))&&(!arrs[i-1].equals(")"))&&(!arrs[i-1].equals("lg("))&&(!arrs[i-1].equals("ln("))&&(!arrs[i-1].equals("tan(")))||((arrs[i].equals("sin("))&&(arrs[i+1].equals(")"))))    //sin前面不能是数字，后面不能紧跟)
							{
							 temporary=2;
							 return brrs="error";
							}
						if(((arrs[i].equals("cos("))&&(arrs[i-1].compareTo("0")>=0)&&(!arrs[i-1].equals("sin("))&&(!arrs[i-1].equals("cos("))&&(!arrs[i-1].equals("^"))&&(!arrs[i-1].equals(")"))&&(!arrs[i-1].equals("lg("))&&(!arrs[i-1].equals("ln("))&&(!arrs[i-1].equals("tan(")))||((arrs[i].equals("cos("))&&(arrs[i+1].equals(")"))))     //sin前面不能是数字，后面不能紧跟)
							{
							 temporary=2;
							 return brrs="error";
							}
						if(((arrs[i].equals("tan("))&&(arrs[i-1].compareTo("0")>=0)&&(!arrs[i-1].equals("sin("))&&(!arrs[i-1].equals("cos("))&&(!arrs[i-1].equals("^"))&&(!arrs[i-1].equals(")"))&&(!arrs[i-1].equals("lg("))&&(!arrs[i-1].equals("ln("))&&(!arrs[i-1].equals("tan(")))||((arrs[i].equals("tan("))&&(arrs[i+1].equals(")"))))     //sin前面不能是数字，后面不能紧跟)
							{
							 temporary=2;
							 return brrs="error";
							}
						if(((arrs[i].equals("lg("))&&(arrs[i-1].compareTo("0")>=0)&&(!arrs[i-1].equals("sin("))&&(!arrs[i-1].equals("cos("))&&(!arrs[i-1].equals("^"))&&(!arrs[i-1].equals(")"))&&(!arrs[i-1].equals("tan("))&&(!arrs[i-1].equals("ln("))&&(!arrs[i-1].equals("lg(")))||((arrs[i].equals("lg("))&&(arrs[i+1].equals(")"))))     //sin前面不能是数字，后面不能紧跟)
						{
						 temporary=2;
						 return brrs="error";
						}
						if(((arrs[i].equals("ln("))&&(arrs[i-1].compareTo("0")>=0)&&(!arrs[i-1].equals("sin("))&&(!arrs[i-1].equals("cos("))&&(!arrs[i-1].equals("^"))&&(!arrs[i-1].equals(")"))&&(!arrs[i-1].equals("tan("))&&(!arrs[i-1].equals("lg("))&&(!arrs[i-1].equals("ln(")))||((arrs[i].equals("ln("))&&(arrs[i+1].equals(")"))))     //sin前面不能是数字，后面不能紧跟)
						{
						 temporary=2;
						 return brrs="error";
						}
					}
					if((arrs[i].equals(")"))&&(arrs[i+1].compareTo("0")>=0)&&(!arrs[i+1].equals("t"))&&(!arrs[i+1].equals("^")))   //)后面得是运算符
						{
						 temporary=2;
						 return brrs="error";
						}
				}
				
				String[] suffixexpression=new String[80];
				for(int i=0,t=0;i<arrs.length;i++)
				{
					if((arrs[i].equals("t"))&&(stack.empty()))
						break;
					else if((arrs[i]=="t")&&(stack.empty()==false))
					{
						while(!stack.empty())
						{
							if((stack.peek().equals(")"))||(stack.peek().equals("(")))
								stack.pop();
							else
							{
								suffixexpression[t]=stack.pop();
								t++;
							}
						}
					break;
					}
					else if((arrs[i].equals("("))||(arrs[i].equals(")"))||(arrs[i].equals("+"))||(arrs[i].equals("-"))||(arrs[i].equals("*"))||(arrs[i].equals("/"))||(arrs[i].equals("sin("))||(arrs[i].equals("cos("))||(arrs[i].equals("tan("))||(arrs[i].equals("^"))||(arrs[i].equals("lg("))||(arrs[i].equals("ln(")))
					{
						if((stack.empty())||(compare(arrs[i],stack.peek() )))
							stack.push(arrs[i]);
						else if((!stack.empty())&&(!compare(arrs[i],stack.peek() )))
						{
							while(!compare(arrs[i],stack.peek()))
							{
								if((arrs[i].equals(")"))&&(stack.peek().equals("(")))
								{
									stack.pop();
									break;
								}
							    suffixexpression[t]=stack.pop();
							    t++;
							    if(stack.empty())
							    	break;
							}
						 if(arrs[i].equals(")"))
							 continue;
						 stack.push(arrs[i]);
						}
					}
					else 
					{
						suffixexpression[t]=arrs[i];
						t++;
					}
				}
			    //错误检查
				int num,num0;
				for( i=0,num=0,num0=0;i<80;i++){
				   	 if(suffixexpression[i]!=null)
				   	 {
				   	 		if((suffixexpression[i].equals("+"))||(suffixexpression[i].equals("-"))||(suffixexpression[i].equals("*"))||(suffixexpression[i].equals("/"))||(suffixexpression[i].equals("^")))
				   	 		{
				   			 num0=num0+1;
				   	 		}
				   	 		else if((suffixexpression[i].compareTo("0")>=0)&&(!suffixexpression[i].equals("sin("))&&(!suffixexpression[i].equals("cos("))&&(!suffixexpression[i].equals("tan("))&&(!suffixexpression[i].equals("^"))&&(!suffixexpression[i].equals("lg("))&&(!suffixexpression[i].equals("ln(")))
				   	 			num++;
				   	 		continue;
				   	 }
				   	 else 
				   	 	{
				   		 m=i;
				   		 break;
				   	 	}
				    }
				 if((num-num0)!=1)
				 {
					 temporary=2;
					 return brrs="error";
				 }
				 
			     for(int t=0;t<m;t++)
			     {
			    	 if(suffixexpression[t].equals("^"))
					    {
							String x=stack.pop(), y="";
							if(stack.empty())
								 return "error";
							else
							{
								 y=stack.pop();
							}
							
							
							double temp=0;
							if((x.equals("pi"))&&(!y.equals("pi")))
							{
								temp=Math.pow(Double.valueOf(y),Double.valueOf(Math.PI));
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((!x.equals("pi"))&&(y.equals("pi")))
							{
								temp=Math.pow(Double.valueOf(Math.PI),Double.valueOf(x));
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((x.equals("pi"))&&(y.equals("pi")))
							{
								temp=Math.pow(Double.valueOf(Math.PI),Double.valueOf(Math.PI));
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((!x.equals("pi"))&&(!y.equals("pi")))
							{
								temp=Math.pow(Double.valueOf(y),Double.valueOf(x));
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							
						}
			    	 
			    	 	if(suffixexpression[t].equals("lg("))
						{
							String x="";
							if(stack.empty())
							{
								 temporary=2;
								 return brrs="error";
							}
							else
								x=stack.pop();
							double temp=0;
							if(x.equals("pi"))
							{
								temp=(Math.log(Double.valueOf(Math.PI)))/(Math.log(10));
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							else
							{
								temp=(Math.log(Double.valueOf(x)))/(Math.log(10));
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
						}
			    	 	
			    	 	if(suffixexpression[t].equals("ln("))
						{
							String x="";
							if(stack.empty())
							{
								 temporary=2;
								 return brrs="error";
							}
							else
								x=stack.pop();
							double temp=0;
							if(x.equals("pi"))
							{
								temp=Math.log(Double.valueOf(Math.PI));
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							else
							{
								temp=Math.log(Double.valueOf(x));
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
						}
			    	 
			    	 	if(suffixexpression[t].equals("sin("))
						{
							String x="";
							if(stack.empty())
							{
								 temporary=2;
								 return brrs="error";
							}
							else
								x=stack.pop();
							double temp=0;
							if(x.equals("pi"))
							{
								temp=Math.sin(Math.PI);
								if(temp<0.00000001)
									temp=0;
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							else
							{
								temp=Math.sin(Double.valueOf(x));
								if(temp<0.00000001)
									temp=0;
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
						}
						
						if(suffixexpression[t].equals("cos("))
						{
							String x="";
							if(stack.empty())
							{
								 temporary=2;
								 return brrs="error";
							}
							else
								x=stack.pop();
							double temp=0;
							if(x.equals("pi"))
							{
								temp=Math.cos(Math.PI);
								if(temp<0.00000001)
									temp=0;
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							else
							{
								temp=Math.cos(Double.valueOf(x));
								if(temp<0.00000001)
									temp=0;
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
						}
						
						if(suffixexpression[t].equals("tan("))
						{
							String x="";
							if(stack.empty())
							{
								 temporary=2;
								 return brrs="error";
							}
							else
								x=stack.pop();
							double temp=0;
							if(x.equals("pi"))
							{
								temp=Math.tan(Math.PI);
								if(temp<0.00000001)
									temp=0;
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							else
							{
								temp=Math.tan(Double.valueOf(x));
								if(temp<0.00000001)
									temp=0;
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
						}	
			    	 
			    	 if(suffixexpression[t].equals("+")){
			 	     		String x=stack.pop(), y="";
							if(stack.empty())
							{
								 temporary=2;
								 return brrs="error";
							}
							else
							{
								 y=stack.pop();
							}
				 			double temp=0;
				 			if((x.equals("pi"))&&(!y.equals("pi")))
							{
								temp=Double.valueOf(y)+Double.valueOf(Math.PI);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((!x.equals("pi"))&&(y.equals("pi")))
							{
								temp=Double.valueOf(Math.PI)+Double.valueOf(x);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((x.equals("pi"))&&(y.equals("pi")))
							{
								temp=Double.valueOf(Math.PI)+Double.valueOf(Math.PI);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((!x.equals("pi"))&&(!y.equals("pi")))
							{
								temp=Double.valueOf(y)+Double.valueOf(x);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
			 			}
			 			if(suffixexpression[t].equals("-")){
			 	     		String x=stack.pop(), y="";
							if(stack.empty())
							{
								 temporary=2;
								 return brrs="error";
							}
							else
							{
								 y=stack.pop();
							}
							
				 			double temp=0;
				 			if((x.equals("pi"))&&(!y.equals("pi")))
							{
								temp=Double.valueOf(y)-Double.valueOf(Math.PI);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((!x.equals("pi"))&&(y.equals("pi")))
							{
								temp=Double.valueOf(Math.PI)-Double.valueOf(x);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((x.equals("pi"))&&(y.equals("pi")))
							{
								temp=Double.valueOf(Math.PI)-Double.valueOf(Math.PI);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((!x.equals("pi"))&&(!y.equals("pi")))
							{
								temp=Double.valueOf(y)-Double.valueOf(x);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
			 			}
			 			if(suffixexpression[t].equals("*")){
			 	     		String x=stack.pop(), y="";
							if(stack.empty())
							{
								 temporary=2;
								 return brrs="error";
							}
							else
							{
								 y=stack.pop();
							}
						
				 			double temp=0;
				 			if((x.equals("pi"))&&(!y.equals("pi")))
							{
								temp=Double.valueOf(y)*Double.valueOf(Math.PI);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((!x.equals("pi"))&&(y.equals("pi")))
							{
								temp=Double.valueOf(Math.PI)*Double.valueOf(x);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((x.equals("pi"))&&(y.equals("pi")))
							{
								temp=Double.valueOf(Math.PI)*Double.valueOf(Math.PI);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((!x.equals("pi"))&&(!y.equals("pi")))
							{
								temp=Double.valueOf(y)*Double.valueOf(x);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
			 			}
			 			if(suffixexpression[t].equals("/")){
			 	     		String x=stack.pop(), y="";
							if(stack.empty())
							{
								 temporary=2;
								 return brrs="error";
							}
							else
							{
								 y=stack.pop();
							}
						
				 			double temp=0;
				 			if((x.equals("pi"))&&(!y.equals("pi")))
							{
								temp=Double.valueOf(y)/Double.valueOf(Math.PI);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((!x.equals("pi"))&&(y.equals("pi")))
							{
								temp=Double.valueOf(Math.PI)/Double.valueOf(x);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((x.equals("pi"))&&(y.equals("pi")))
							{
								temp=Double.valueOf(Math.PI)/Double.valueOf(Math.PI);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
							if((!x.equals("pi"))&&(!y.equals("pi")))
							{
								temp=Double.valueOf(y)/Double.valueOf(x);
								temp=((double)Math.round(temp*100000000)/100000000);
								stack.push(String.valueOf(temp));
								continue;
							}
			 			}
			 		
			 	     else
			 	    	stack.push(suffixexpression[t]);
			     }
				 temporary=1;
				 watchpoint=1;
				 brrs=stack.pop();
				 while(!stack.empty())
						stack.pop();
				 return  brrs;
			}
		
			private  boolean compare(String x, String y) 
			{
				if((x.equals("+"))&&(y.equals("+")))
					 return false;
				 else if((x.equals("+"))&&(y.equals("-")))
					 return false;
				 else if((x.equals("+"))&&(y.equals("*")))
					 return false;
				 else if((x.equals("+"))&&(y.equals("/")))
					 return false;
				 else if((x.equals("+"))&&(y.equals("^")))
					 return false;
				 else if((x.equals("+"))&&(y.equals("(")))
					 return true;
				 else if((x.equals("+"))&&(y.equals("sin(")))
					 return true;
				 else if((x.equals("+"))&&(y.equals("cos(")))
					 return true;
				 else if((x.equals("+"))&&(y.equals("tan(")))
					 return true;
				 else if((x.equals("+"))&&(y.equals("lg(")))
					 return true;
				 else if((x.equals("+"))&&(y.equals("ln(")))
					 return true;
				 
				 if((x.equals("-"))&&(y.equals("+")))
					 return false;
				 else if((x.equals("-"))&&(y.equals("-")))
					 return false;
				 else if((x.equals("-"))&&(y.equals("*")))
					 return false;
				 else if((x.equals("-"))&&(y.equals("/")))
					 return false;
				 else if((x.equals("-"))&&(y.equals("^")))
					 return false;
				 else if((x.equals("-"))&&(y.equals("(")))
					 return true;
				 else if((x.equals("-"))&&(y.equals("sin(")))
					 return true;
				 else if((x.equals("-"))&&(y.equals("cos(")))
					 return true;
				 else if((x.equals("-"))&&(y.equals("tan(")))
					 return true;
				 else if((x.equals("-"))&&(y.equals("lg(")))
					 return true;
				 else if((x.equals("-"))&&(y.equals("ln(")))
					 return true;


				 
				 if((x.equals("*"))&&(y.equals("+")))
					 return true;
				 else if((x.equals("*"))&&(y.equals("-")))
					 return true;
				 else if((x.equals("*"))&&(y.equals("*")))
					 return false;
				 else if((x.equals("*"))&&(y.equals("/")))
					 return false;
				 else if((x.equals("*"))&&(y.equals("^")))
					 return false;
				 else if((x.equals("*"))&&(y.equals("(")))
					 return true;
				 else if((x.equals("*"))&&(y.equals("sin(")))
					 return true;
				 else if((x.equals("*"))&&(y.equals("cos(")))
					 return true;
				 else if((x.equals("*"))&&(y.equals("tan(")))
					 return true;
				 else if((x.equals("*"))&&(y.equals("lg(")))
					 return true;
				 else if((x.equals("*"))&&(y.equals("ln(")))
					 return true;


				 
				 if((x.equals("/"))&&(y.equals("+")))
					 return true;
				 else if((x.equals("/"))&&(y.equals("-")))
					 return true;
				 else if((x.equals("/"))&&(y.equals("*")))
					 return false;
				 else if((x.equals("/"))&&(y.equals("/")))
					 return false;
				 else if((x.equals("/"))&&(y.equals("^")))
					 return false;
				 else if((x.equals("/"))&&(y.equals("(")))
					 return true;
				 else if((x.equals("/"))&&(y.equals("sin(")))
					 return true;
				 else if((x.equals("/"))&&(y.equals("cos(")))
					 return true;
				 else if((x.equals("/"))&&(y.equals("tan(")))
					 return true;
				 else if((x.equals("/"))&&(y.equals("lg(")))
					 return true;
				 else if((x.equals("/"))&&(y.equals("ln(")))
					 return true;


				 if((x.equals("("))&&(y.equals("+")))
					 return true;
				 else if((x.equals("("))&&(y.equals("-")))
					 return true;
				 else if((x.equals("("))&&(y.equals("*")))
					 return true;
				 else if((x.equals("("))&&(y.equals("/")))
					 return true;
				 else if((x.equals("("))&&(y.equals("^")))
					 return true;
				 else if((x.equals("("))&&(y.equals("(")))
					 return true;
				 else if((x.equals("("))&&(y.equals("sin(")))
					 return true;
				 else if((x.equals("("))&&(y.equals("cos(")))
					 return true;
				 else if((x.equals("("))&&(y.equals("tan(")))
					 return true;
				 else if((x.equals("("))&&(y.equals("lg(")))
					 return true;
				 else if((x.equals("("))&&(y.equals("ln(")))
					 return true;

				 if((x.equals(")"))&&(y.equals("+")))
					 return false;
				 else if((x.equals(")"))&&(y.equals("-")))
					 return false;
				 else if((x.equals(")"))&&(y.equals("*")))
					 return false;
				 else if((x.equals(")"))&&(y.equals("/")))
					 return false;
				 else if((x.equals(")"))&&(y.equals("^")))
					 return false;
				 else if((x.equals(")"))&&(y.equals("(")))
					 return false;
				 else if((x.equals(")"))&&(y.equals("sin(")))
					 return false;
				 else if((x.equals(")"))&&(y.equals("cos(")))
					 return false;
				 else if((x.equals(")"))&&(y.equals("tan(")))
					 return false;
				 else if((x.equals(")"))&&(y.equals("lg(")))
					 return false;
				 else if((x.equals(")"))&&(y.equals("ln(")))
					 return false;
				 
				 if((x.equals("sin("))&&(y.equals("+")))
					 return true;
				 else if((x.equals("sin("))&&(y.equals("-")))
					 return true;
				 else if((x.equals("sin("))&&(y.equals("*")))
					 return true;
				 else if((x.equals("sin("))&&(y.equals("/")))
					 return true;
				 else if((x.equals("sin("))&&(y.equals("^")))
					 return true;
				 else if((x.equals("sin("))&&(y.equals("(")))
					 return true;
				 else if((x.equals("sin("))&&(y.equals("sin(")))
					 return true;
				 else if((x.equals("sin("))&&(y.equals("cos(")))
					 return true;
				 else if((x.equals("sin("))&&(y.equals("tan(")))
					 return true;
				 else if((x.equals("sin("))&&(y.equals("lg(")))
					 return true;
				 else if((x.equals("sin("))&&(y.equals("ln(")))
					 return true;
				 
				 if((x.equals("cos("))&&(y.equals("+")))
					 return true;
				 else if((x.equals("cos("))&&(y.equals("-")))
					 return true;
				 else if((x.equals("cos("))&&(y.equals("*")))
					 return true;
				 else if((x.equals("cos("))&&(y.equals("/")))
					 return true;
				 else if((x.equals("cos("))&&(y.equals("^")))
					 return true;
				 else if((x.equals("cos("))&&(y.equals("(")))
					 return true;
				 else if((x.equals("cos("))&&(y.equals("sin(")))
					 return true;
				 else if((x.equals("cos("))&&(y.equals("cos(")))
					 return true;
				 else if((x.equals("cos("))&&(y.equals("tan(")))
					 return true;
				 else if((x.equals("cos("))&&(y.equals("lg(")))
					 return true;
				 else if((x.equals("cos("))&&(y.equals("ln(")))
					 return true;
				 
				 if((x.equals("tan("))&&(y.equals("+")))
					 return true;
				 else if((x.equals("tan("))&&(y.equals("-")))
					 return true;
				 else if((x.equals("tan("))&&(y.equals("*")))
					 return true;
				 else if((x.equals("tan("))&&(y.equals("/")))
					 return true;
				 else if((x.equals("tan("))&&(y.equals("^")))
					 return true;
				 else if((x.equals("tan("))&&(y.equals("(")))
					 return true;
				 else if((x.equals("tan("))&&(y.equals("sin(")))
					 return true;
				 else if((x.equals("tan("))&&(y.equals("cos(")))
					 return true;
				 else if((x.equals("tan("))&&(y.equals("tan(")))
					 return true;
				 else if((x.equals("tan("))&&(y.equals("lg(")))
					 return true;
				 else if((x.equals("tan("))&&(y.equals("ln(")))
					 return true;
				 
				 if((x.equals("^"))&&(y.equals("+")))
					 return true;
				 else if((x.equals("^"))&&(y.equals("-")))
					 return true;
				 else if((x.equals("^"))&&(y.equals("*")))
					 return false;
				 else if((x.equals("^"))&&(y.equals("/")))
					 return false;
				 else if((x.equals("^"))&&(y.equals("^")))
					 return false;
				 else if((x.equals("^"))&&(y.equals("(")))
					 return true;
				 else if((x.equals("^"))&&(y.equals("sin(")))
					 return true;
				 else if((x.equals("^"))&&(y.equals("cos(")))
					 return true;
				 else if((x.equals("^"))&&(y.equals("tan(")))
					 return true;
				 else if((x.equals("^"))&&(y.equals("lg(")))
					 return true;
				 else if((x.equals("^"))&&(y.equals("ln(")))
					 return true;
				 
				 if((x.equals("lg("))&&(y.equals("+")))
					 return true;
				 else if((x.equals("lg("))&&(y.equals("-")))
					 return true;
				 else if((x.equals("lg("))&&(y.equals("*")))
					 return true;
				 else if((x.equals("lg("))&&(y.equals("/")))
					 return true;
				 else if((x.equals("lg("))&&(y.equals("^")))
					 return true;
				 else if((x.equals("lg("))&&(y.equals("(")))
					 return true;
				 else if((x.equals("lg("))&&(y.equals("sin(")))
					 return true;
				 else if((x.equals("lg("))&&(y.equals("cos(")))
					 return true;
				 else if((x.equals("lg("))&&(y.equals("tan(")))
					 return true;
				 else if((x.equals("lg("))&&(y.equals("lg(")))
					 return true;
				 else if((x.equals("lg("))&&(y.equals("ln(")))
					 return true;				 
				
				 if((x.equals("ln("))&&(y.equals("+")))
					 return true;
				 else if((x.equals("ln("))&&(y.equals("-")))
					 return true;
				 else if((x.equals("ln("))&&(y.equals("*")))
					 return true;
				 else if((x.equals("ln("))&&(y.equals("/")))
					 return true;
				 else if((x.equals("ln("))&&(y.equals("^")))
					 return true;
				 else if((x.equals("ln("))&&(y.equals("(")))
					 return true;
				 else if((x.equals("ln("))&&(y.equals("sin(")))
					 return true;
				 else if((x.equals("ln("))&&(y.equals("cos(")))
					 return true;
				 else if((x.equals("ln("))&&(y.equals("tan(")))
					 return true;
				 else if((x.equals("ln("))&&(y.equals("lg(")))
					 return true;
				 else if((x.equals("ln("))&&(y.equals("ln(")))
					 return true;
				 
				 return true;
				 } 
		});
		bnClear.setOnClickListener(new OnClickListener()
		{
			public void onClick(View source)
			{
				for(int m=0;m<arrs.length;m++) 
				{
			        arrs[m]="t";
			        trrs[m]="t";
			    }
				    viewout1.setText("");
				    viewout.setText("0");
		    		i=0;
		    		temporary=0;
		    		watchpoint=0; //判定是否连续计算的标志
		    		watchtext=0;
    		       
			}
		});
	 bndelete.setOnClickListener(new  OnClickListener()
	  {
			public void onClick(View source)
			{
		    		//结果是error或者是数字直接按delete
					if((temporary==1)||(temporary==2))
		    		{
						for(int m=0;m<arrs.length;m++) 
						{
					        arrs[m]="t";
					        trrs[m]="t";
					    }
						    viewout1.setText("");
						    viewout.setText("0");
				    		i=0;
				    		temporary=0; 
				    		watchpoint=0;
				    		watchtext=0;
		    			}
		    		else
		    			{
		    				i--;
		    				if((watchpoint==1)&&(arrs[i].compareTo("/")>0))
		    					watchpoint=1;
		    				else
		    					watchpoint=0;	
		    				if(i<=0)
		    				{
		    					i=0;
		    					viewout1.setText("");
		    					viewout.setText("0");
		    				}
		    				else
		    				{ 
		    					if(watchtext==1)
		    					{
		    						arrs[i]="t";
		    						viewout1.setText(getStringByArray(crrs));
		    						viewout.setText(getStringByArray(arrs));
		    					}
		    					else
		    					{
		    						arrs[i]="t"; 
		    						viewout1.setText("");
		    						viewout.setText(getStringByArray(arrs));
		    					}
		    				}
		    			}
    			}
		});
	}
	//显示Log计算的结果
    public void onActivityResult(int requestCode,int resultCode,Intent intent)
    {
    	if(requestCode==0&&resultCode==0)
    	{
    		final TextView text=(TextView)findViewById(R.id.view);
    		final TextView v1=(TextView)findViewById(R.id.view1);
    		Bundle data=intent.getExtras();
    		String finalanswer=data.getString("finalanswer");
  		    if(watchtext==1)
			  v1.setText(getStringByArray(crrs));
  		    else
  		    {  			
			  v1.setText("");
  		    }
  		    if((temporary==1)||(temporary==2))
  		    {
  			  for(int m=0;m<arrs.length;m++) 
  			{
  		        arrs[m]="t";
  		        trrs[m]="t";
  		    }
  			  i=0;
  			  temporary=0;
  		    }
  		    if((finalanswer.equals("error"))||(finalanswer.equals("-Infinity"))||(finalanswer.equals("Infinity"))||(finalanswer.equals("NaN")))
    		{
    			text.setText(finalanswer);
    			temporary=2;
    		}
    		else
    		{
    			if(i==0)
    			{
    				arrs[i]=finalanswer;
    				text.setText(getStringByArray(arrs));
    				i++;
    			}
    			else
    			{	
    				if((arrs[i-1].equals("/"))||(arrs[i-1].equals("*"))||(arrs[i-1].equals("+"))||(arrs[i-1].equals("-"))||(arrs[i-1].equals("sin("))||(arrs[i-1].equals("cos("))||(arrs[i-1].equals("tan("))||(arrs[i-1].equals("(")))
					{
    					arrs[i]=finalanswer;
    					text.setText(getStringByArray(arrs));
    					i++;
					}
    				else
    				{
    					temporary=2;
    					text.setText("log前缺少运算符号");
    				}
    			}
    		}
    	}
    }
  //显示数字
    public void showbracker(TextView v1,TextView v,String bracker)
    {
    	if(watchtext==1)
	    	v1.setText(getStringByArray(crrs));
    	else
		{
			  v1.setText("");
		}
    	if((temporary==2)||(temporary==1))
    	{
    		for(int m=0;m<arrs.length;m++) 
    		{
    			arrs[m]="t";
    			trrs[m]="t";
    		}
    		i=0;
    		temporary=0;
    		arrs[i]=bracker;
    		watchpoint=0;
    		i++;
    		v.setText(getStringByArray(arrs));
    	}
    	else
		{
    		arrs[i]=bracker;
    		v.setText(getStringByArray(arrs));
    		i++;
    		watchpoint=0;
		}
    }
    
    public void showoperator(TextView v1,TextView v,String operator)
    {
    	if(watchtext==1)
	    	v1.setText(getStringByArray(crrs));
		else
		{
			  v1.setText("");
		}
	  	//解决连续计算的问题
	  	if(temporary==1)
	  	{
	  		for(int m=0;m<arrs.length;m++)
	  		{
	  			arrs[m]="t";
	  			trrs[m]="t";
	  		}
	  		i=0;
	  		temporary=0;
	  		arrs[i]=String.valueOf(brrs);
	  		i=i+1;
	  		arrs[i]=operator;
	  		i=i+1;
	  		watchpoint=0;
	  		v.setText(getStringByArray(arrs));
	  	}
	  	//解决结果出现error
	  	else if(temporary==2)
	  	{
	  		for(int m=0;m<arrs.length;m++)
	  		{
	  			arrs[m]="t";
	  			trrs[m]="t";
	  		}
	  		i=0;
	  		temporary=0;
	  		arrs[i]="0";
	  		watchpoint=0;
	  		v.setText(getStringByArray(arrs));
	  	}
	  	//解决开始如果不按数字，默认值是0的问题
	  	else if(i==0)
	  	{
	  		arrs[i]="0";
	  		i=i+1;
	  		arrs[i]=operator;
	  		i=i+1;
	  		watchpoint=0;
	  		v.setText(getStringByArray(arrs));
	  	}
	  	//解决连续按运算符的问题
	  	else if((arrs[i-1].equals("+"))||(arrs[i-1].equals("-"))||(arrs[i-1].equals("*"))||(arrs[i-1].equals("/"))||(arrs[i-1].equals("^")))
	  	{
	  		v.setText(getStringByArray(arrs));
	  	}
		
	  	else
		{    
			arrs[i]=operator;
			v.setText(getStringByArray(arrs));
			i++;
			watchpoint=0;
		}
    }
    public void shownumber(TextView v1,TextView v,String number)
    {
		  if(watchtext==1)
			  v1.setText(getStringByArray(crrs));
		  else
		  {  			
			  v1.setText("");
		  }
		  if((temporary==1)||(temporary==2))
		  {
			  for(int m=0;m<arrs.length;m++) 
			{
		        arrs[m]="t";
		        trrs[m]="t";
		    }
			  i=0;
			  temporary=0;
		  }
    	  arrs[i]=number;
    	  v.setText(getStringByArray(arrs));
		  i++;
	}
    //显示字符串内容
    public String getStringByArray(String[] arrs) 
	{
	    String str = "";
	    for(int j=0;j<arrs.length;j++) {
	        if((arrs[j]==null)||(arrs[j]=="t"))
	        	break;
	    	str += arrs[j];
	    }
	    return str;
	}
   	class MyButton implements View.OnClickListener
	{
		public void onClick(View source)
		{
			final TextView viewout=(TextView)findViewById(R.id.view);
			final TextView viewout1=(TextView)findViewById(R.id.view1);
			switch(source.getId())
			{
				case R.id.zero:
					shownumber(viewout1,viewout,"0");
					break;
		  		case R.id.one:
		  			shownumber(viewout1,viewout,"1");
		  			break;
				case R.id.two:
					shownumber(viewout1,viewout,"2");
					break;
				case R.id.three:
					shownumber(viewout1,viewout,"3");
					break;
				case R.id.four:
					shownumber(viewout1,viewout,"4");
					break;
				case R.id.five:
					shownumber(viewout1,viewout,"5");
					break;
			 	case R.id.six:
			 		shownumber(viewout1,viewout,"6");  
			 		break;
			 	case R.id.seven:
			 		shownumber(viewout1,viewout,"7");
			 		break;
			 	case R.id.eight:
			 		shownumber(viewout1,viewout,"8");
			 		break;
			 	case R.id.nine:
			 		shownumber(viewout1,viewout,"9");
			 		break;
			 	case R.id.plus:
			 		showoperator(viewout1,viewout,"+");
			 		break;
			 	case R.id.minus:
			 		showoperator(viewout1,viewout,"-");
			 		break;
			 	case R.id.times:
			 		showoperator(viewout1,viewout,"*");
			 		break;
			 	case R.id.divided:
			 		showoperator(viewout1,viewout,"/");
			 		break;
			 	case R.id.rightbracket:
			 		showbracker(viewout1,viewout,")");
			 		break;
			 	case R.id.leftbracket:
			 		showbracker(viewout1,viewout,"(");
			 		break;
			 	case R.id.sin:
			 		showbracker(viewout1,viewout,"sin(");
			 		break;
			 	case R.id.cos:
			 		showbracker(viewout1,viewout,"cos(");
			 		break;
			 	case R.id.tan:
			 		showbracker(viewout1,viewout,"tan(");
			 		break;
			 	case R.id.power:
			 		showoperator(viewout1,viewout,"^");
			 		break;
			 	case R.id.lg:
			 		showbracker(viewout1,viewout,"lg(");
			 		break;
			 	case R.id.ln:
			 		showbracker(viewout1,viewout,"ln(");
			 		break;
			 	case R.id.Pi:
			 		shownumber(viewout1,viewout,"pi");
			}
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}