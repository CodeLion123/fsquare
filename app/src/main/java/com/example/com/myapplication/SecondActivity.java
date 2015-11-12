package com.example.com.myapplication;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
BY ABDUL KARIM
**/
public class SecondActivity extends AppCompatActivity {
	ProgressDialog mProgressDialog;
	final String TAG = "AsyncTaskParseJson.java";
	GridView gridView;
	EditText search,area;
	ImageView searchBar;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	 LinkedHashMap<Integer, String> id = new LinkedHashMap<Integer, String>();
	  LinkedHashMap<Integer, Bitmap> Bitm = new LinkedHashMap<Integer, Bitmap>();
	 CustomGridViewAdapter customGridAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
      
        search = (EditText) findViewById(R.id.search);
        area = (EditText) findViewById(R.id.area);
        searchBar = (ImageView) findViewById(R.id.searchbar);
        gridView = (GridView) findViewById(R.id.gridView);
        searchBar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					  id.clear();
						Bitm.clear();
						gridArray.clear();
	                new FetchWebsiteData().execute();
	            	}
	                catch(Exception e){
	                	System.out.println("wowwww"+e);
	                }
	            }
			
		});
        
  
        
    }

    private class FetchWebsiteData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(SecondActivity.this);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
                    
        }

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			final String TAG = "AsyncTaskParseJson.java";
			String Venue = search.getText().toString(); 
			
			
			try{
			JsonParse(Venue);
		
			}catch(Exception e){
				 Log.e(TAG,"abdul"+ e.toString());
				
			}
			return null;
		}
		 @Override
	        protected void onPostExecute(Void result) {
			 super.onPostExecute(result);
			 try{
			  
		        customGridAdapter = new CustomGridViewAdapter(SecondActivity.this, R.layout.row_grid, gridArray);
				gridView.setAdapter(customGridAdapter);
				//gridView.setOnItemClickListener(new OnItemClickListener() {
					
			 }catch(Exception e){Log.e(TAG,"abdul"+ e.toString());}
				Toast.makeText(getApplicationContext(), 
						"Done", 
						Toast.LENGTH_LONG).show();
				gridView.setOnItemClickListener(new OnItemClickListener() {

		            @Override
		            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
		            	Intent i = new Intent(SecondActivity.this,SingleViewActivity.class);
		            	
		            	i.putExtra("image", gridArray.get(position).getImage());
		            	//i.putExtra("id", position);
//rating,address,country,category,checkin,userCoun,tipCoun,purl,Cmessage,currency,Hstat
		            	i.putExtra("rating", gridArray.get(position).getId());
		            	i.putExtra("address", gridArray.get(position).getAddress()+"\n                      "+gridArray.get(position).getCity()+" , "+gridArray.get(position).getState()+"\n                      "+gridArray.get(position).getCountry() );
		            	i.putExtra("category", gridArray.get(position).getCategory());
		            	i.putExtra("checkin", gridArray.get(position).getCheckin());
		            	i.putExtra("userCoun", gridArray.get(position).getuserCoun());
		            	i.putExtra("tipCoun", gridArray.get(position).gettipCoun());
		            	i.putExtra("purl", gridArray.get(position).getPurl());
		            	//i.putExtra("catogory", gridArray.get(position).getCategory());
		            	i.putExtra("Cmessage", gridArray.get(position).getCmessage());
		            	i.putExtra("currency", gridArray.get(position).getCurrency());
		            	i.putExtra("Hstat", gridArray.get(position).getHstat());
		            	startActivity(i);
		              //  ListItem newsData = (ListItem) listView.getItemAtPosition(position);
		              //  Toast.makeText(SecondActivity.this, "Selected :", Toast.LENGTH_LONG).show();
		                //System.out.print("click");
		            }
		        });
		            mProgressDialog.dismiss();
		           
		 }
 
}
    public String JsonParse(String URL1){
	
    	Bitmap bmp=null;
    	String name,phoneNo = " ",locate="near=delhi,INDIA",address=" ",Hstat=" ",purl=" ",Cmessage=" ",currency="N.A",checkin="N.A",userCoun=" ",tipCoun=" ",city=" ",state=" ",country=" ",rating="N.A",catagory=" ",stat=" ";
    	String logoLink=null;
    	

		try {
		
            // instantiate our json parser
			String xy= area.getText().toString();
			if(!xy.matches(""))
				locate="near="+xy;
			else {
                locate="near=delhi,INDIA";

//                GPSTracker gpsTracker = new GPSTracker(SecondActivity.this);
//                if (gpsTracker.getIsGPSTrackingEnabled()) {
//                    locate = "ll=" + String.valueOf(gpsTracker.latitude) + "," + String.valueOf(gpsTracker.longitude);
//                } else {
//                    gpsTracker.showSettingsAlert();
//                }
            }
            JsonParser jParser = new JsonParser();
            // set your json string url here
            String yourJsonStringUrl = "https://api.foursquare.com/v2/venues/explore?venuePhotos=1&"+locate+"&query="+URL1+"&limit=20&client_id=DHX3UUIAUXBXFAMB2E0T2ZRAIOQFFP4Y24QCXN3GFYXQTX0K&client_secret=KLVPAWGTMWT5EXSF5Y4NGGOR3KUXWYDKJH0FJD4WIH4VLFNG&v=20150806";
            
            // contacts JSONArray
            JSONArray dataJsonArr = null;
          //  String url = "http://www.google.com/uds/GnewsSearch?q=Obama&v=1.0";
            // get json string from url
            
            JSONObject json = jParser.getJSONFromUrl(yourJsonStringUrl);
          
            // get the array of users
            JSONObject responseData = json.getJSONObject("response");
            System.out.print(responseData.toString());
            dataJsonArr = responseData.getJSONArray("groups").getJSONObject(0).getJSONArray("items");
            //}catch(Exception e){System.out.print("abdul"+e);}
            System.out.print(dataJsonArr.toString());
            // loop through all users
            int x=dataJsonArr.length();
            for (int i = 0; i < x; i++) {

                JSONObject c = dataJsonArr.getJSONObject(i);
                JSONObject venue= c.getJSONObject("venue");
                
                id.put(i,venue.getString("id"));
                name=venue.getString("name");
                if(venue.has("contact"))
                {
                if(venue.getJSONObject("contact").has("phone"))
                phoneNo=venue.getJSONObject("contact").getString("phone");
                }
                if(venue.has("location"))
                {
                if(venue.getJSONObject("location").has("address"))
                address=venue.getJSONObject("location").getString("address");
                if(venue.getJSONObject("location").has("city"))
                city=venue.getJSONObject("location").getString("city");
                if(venue.getJSONObject("location").has("state"))
                state=venue.getJSONObject("location").getString("state");
                if(venue.getJSONObject("location").has("country"))
                country=venue.getJSONObject("location").getString("country");
                }
                if(venue.has("categories"))
                {
                if(venue.getJSONArray("categories").getJSONObject(0).has("name"))
                catagory=venue.getJSONArray("categories").getJSONObject(0).getString("name");
                }
                if(venue.has("stats"))
                {
                if(venue.getJSONObject("stats").has("checkinsCount"))
                	checkin=venue.getJSONObject("stats").getString("checkinsCount");
                if(venue.getJSONObject("stats").has("usersCount"))
                	userCoun=venue.getJSONObject("stats").getString("usersCount");
                if(venue.getJSONObject("stats").has("tipCount"))
                	tipCoun=venue.getJSONObject("stats").getString("tipCount");
                }
                if(venue.has("tipCount"))
                	purl=venue.getString("tipCount");
                if(venue.has("price"))
                {
                if(venue.getJSONObject("price").has("message"))
                	Cmessage=venue.getJSONObject("price").getString("message");
                
                	if(venue.getJSONObject("price").has("currency"))
                	currency=venue.getJSONObject("price").getString("currency");
                }
                if(venue.has("hours"))
                {	
                	if(venue.getJSONObject("hours").has("status"))
                      	Hstat=venue.getJSONObject("hours").getString("status");
                }
                if(venue.has("rating"))
                	rating=venue.getString("rating");
                
                JSONObject img = venue.getJSONObject("photos").getJSONArray("groups").getJSONObject(0).getJSONArray("items").getJSONObject(0);
               
               String prefix=img.getString("prefix");
               String suffix=img.getString("suffix");
               
              System.out.println(name);
              
             String ImageLink=prefix+"240x120"+suffix;
             if(prefix!=null)
             {
            	 try{
             URL url = new URL(ImageLink);
         	//	Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.home);
                 bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
               //  Bitm.put(k, bmp);
            	 }catch(Exception e){ System.out.print("abdul"+e);}
             }
             else
             {
            	 bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.home);
             }
             gridArray.add(new Item(rating,bmp,name,phoneNo,address,city,state,country,catagory,checkin,userCoun,tipCoun,purl,Cmessage,currency,Hstat));
            }
          /*
            String imageParsing;
            
            String ImageLink=null,prefix=null,suffix=null;
          
            for(int k=0;k<x;k++)
            {  
            	            	 //  System.out.println("\n"+id.get(k)+k+"abdul\n");  
			            	imageParsing = "https://api.foursquare.com/v2/venues/"+id.get(k)+"/photos?client_id=DHX3UUIAUXBXFAMB2E0T2ZRAIOQFFP4Y24QCXN3GFYXQTX0K&client_secret=KLVPAWGTMWT5EXSF5Y4NGGOR3KUXWYDKJH0FJD4WIH4VLFNG&v=20130815&limit=10";
			            	 JSONObject json2=jParser.getJSONFromUrl(imageParsing);
			            	JSONObject responseData2 = json2.getJSONObject("response");
			                JSONObject dataJsonArr2 = responseData2.getJSONObject("photos");
			                int count = dataJsonArr2.getInt("count") ; 
			                JSONArray item= dataJsonArr2.getJSONArray("items");
			              //  System.out.print(dataJsonArr2.toString());
//			               int
			                int y=item.length();
			                for(int l=0;l<y;l++)
			                {
			                if(l>=2)break;	
//			                
			                if(count!=0)
			                {
			                	System.out.print(count+"abdul");
			                //	try{
			                	JSONObject c = item.getJSONObject(l);
			                	prefix=c.getString("prefix");
			                	suffix=c.getString("suffix");
			                	ImageLink=prefix+"120x120"+suffix;
			                	System.out.print(ImageLink);
			                	//if(!=null)
			                //	{
			                		URL url = new URL(ImageLink);
			                	//	Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.home);
			                        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
			                        Bitm.put(k, bmp);
			                      //  break;
			                	//}
			                	//}catch(Exception e){System.out.print("abdul"+e);}
			                } 		
			                else
			                {
			                	Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.home);
			                	Bitm.put(k, bmp);
			                
			                }
			                
//			       
			                	
			                }
			                
			            //	Bitmap bmp = BitmapFactory.decodeResource(SecondActivity.this.getResources(), R.drawable.home);
			              //    Bitm.put(k, bmp);
			                gridArray.add(new Item("k",Bitm.get(k),id.get(k).toString()));
			                
            }
          
           */
            
            
      
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return logoLink;
	}
	 
}
