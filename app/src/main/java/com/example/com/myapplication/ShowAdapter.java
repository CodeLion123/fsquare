package com.example.com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
BY ABDUL KARIM
**/
public class ShowAdapter extends ArrayAdapter<Item> {
	Context context;
	int layoutResourceId;
	ArrayList<Item> data = new ArrayList<Item>();
	int position;

	public ShowAdapter(Context context, int layoutResourceId,
			ArrayList<Item> data,int position) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
		this.position=position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		RecordHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);

			holder = new RecordHolder();
//			holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
//			holder.address = (TextView) row.findViewById(R.id.item_text2);
//			holder.rating = (Button) row.findViewById(R.id.rate);
			holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
		//	holder.category=(TextView) row.findViewById(R.id.category);
			row.setTag(holder);
		} else {
			holder = (RecordHolder) row.getTag();
		}

		Item item = data.get(position);
	//	holder.txtTitle.setText(item.getTitle());
		holder.imageItem.setImageBitmap(item.getImage());
//		holder.address.setText(item.getAddress()+"\n"+item.getState()+" , "+item.getCountry());
//		holder.rating.setText(item.getId());
//		holder.category.setText(item.getCategory());
		return row;

	}

	static class RecordHolder {
		
		ImageView imageItem;
		

	}
}
