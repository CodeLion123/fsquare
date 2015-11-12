package com.example.com.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
BY ABDUL KARIM
**/
public class SingleViewActivity extends AppCompatActivity {
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.single_view);
      
      // Get intent data
 
      Intent i = getIntent();
    //  ArrayList<Item> myList = (ArrayList<Item>) getIntent().getSerializableExtra("grid");
      // Selected image id
      Bitmap bitmap = (Bitmap) i.getParcelableExtra("image");
      int position = i.getExtras().getInt("id");
     //  ShowAdapter Sadapter= new ShowAdapter(this,R.layout.single_view,myList,position);
     //  Item item = myList.get(position);
      ImageView imageView = (ImageView) findViewById(R.id.SingleView);
      TextView t1 = (TextView) findViewById(R.id.text1);
      TextView t2 = (TextView) findViewById(R.id.text2);
      TextView t3 = (TextView) findViewById(R.id.text3);
      TextView t4 = (TextView) findViewById(R.id.text4);
      TextView t5 = (TextView) findViewById(R.id.text5);
      TextView t6 = (TextView) findViewById(R.id.text6);
      TextView t7 = (TextView) findViewById(R.id.text7);
      TextView t8 = (TextView) findViewById(R.id.text8);
      TextView t9 = (TextView) findViewById(R.id.text9);
      TextView t10 = (TextView) findViewById(R.id.text10);
      //rating,address,country,category,checkin,userCoun,tipCoun,purl,Cmessage,currency,Hstat
      t1.setText("RATING   : "+i.getExtras().getString("rating"));
      t2.setText("CATEGORY : "+i.getExtras().getString("category"));
      t3.setText("ADDRESS  : "+i.getExtras().getString("address"));
      t4.setText("No.OF CHECHIns : "+i.getExtras().getString("checkin"));
      t5.setText("USER_COUNT : "+i.getExtras().getString("userCoun"));
      t6.setText("TIP_COUNT (if any) : "+i.getExtras().getString("tipCoun"));
      t7.setText("URL : ( if any ) : "+i.getExtras().getString("purl"));
      t8.setText("PRICE : "+i.getExtras().getString("Cmessage"));
      t9.setText("        "+i.getExtras().getString("currency"));
      t10.setText("WORKING HOUR : "+i.getExtras().getString("Hstat"));
      
      imageView.setImageBitmap(bitmap);
   }
}
