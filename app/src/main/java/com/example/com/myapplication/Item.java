package com.example.com.myapplication;

import android.graphics.Bitmap;

/**
BY ABDUL KARIM
**/

public class Item {
	Bitmap image;
	String title;
	String id;
	String phoneNo,address,city,state,country,category,checkin,userCoun,tipCoun,purl,Cmessage,currency,Hstat;
	public Item(String id,Bitmap image, String title,String phoneNo,String address,String city,String state,String country,String category,String checkin,String userCoun,String tipCoun,String purl,String Cmessage,String currency,String Hstat) {
		super();
		this.image = image;
		this.title = title;
		this.id=id;
		this.phoneNo=phoneNo;
		this.address=address;
		this.city=city;
		this.state=state;
		this.country=country;
		this.category=category;
		this.checkin=checkin;
		this.userCoun=userCoun;
		this.tipCoun=tipCoun;
		this.purl=purl;
		this.Cmessage=Cmessage;
		this.currency=currency;
		this.Hstat=Hstat;
	}
	public Bitmap getImage() {
		return image;
	}
	public void setImage(Bitmap image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phoneNo;
	}
	public void setPhone(String phoneNo) {
		this.phoneNo =phoneNo ;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCategory() {
		return category;
	}
	//checkin,userCoun,tipCoun,purl,Cmessage,currency,Hstat
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getuserCoun() {
		return userCoun;
	}
	public String gettipCoun() {
		return tipCoun;
	}
	public String getPurl() {
		return purl;
	}
	public String getCmessage() {
		return Cmessage;
	}
	public String getCurrency() {
		return currency;
	}
	public String getHstat() {
		return Hstat;
	}
	
	
	
	
	
}
