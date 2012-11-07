package com.photon.phresco.nativeapp.functional.test.core;

import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Field;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;

import com.photon.phresco.nativeapp.functional.R;

public class UserInfoConstants {
	private ReadXMLFile readXml;

	public String USERNAME = "userName";
	public String PASSWORD = "passWord";

	public String WRONG_EMAIL = "w_email";
	public String WRONG_PASSWORD = "w_passWord";

	public String FIRSTNAME = "firstName";
	public String LASTNAME = "lastName";
	public String EMAIL = "email";

	/*public String DELIVERY_FIRSTNAME="d_firstName"; 
	public String DELIVERY_ADDRESS1="d_address"; 
	public String DELIVERY_ZIPCODE="d_zipcode"; 
	public String DELIVERY_PHONENUMBER="d_phonenumber"; 
	public String DELIVERY_CITYNAME="d_cityname";
	
	public String BILL_FIRSTNAME="b_firstname"; 
	public String BILL_LASTNAME="b_lastname"; 
	public String BILL_COMPANY="b_company";
	public String BILL_ADDRESS1="b_address1"; 
	public String BILL_CITY="b_city"; 
	public String BILL_ZIP="b_zip";*/

	public UserInfoConstants() {

	}

	public void parser(Context context) {
		try {

			 Resources res = context.getResources(); 
			 InputStream instream = res.openRawResource(R.raw.userinfo);
			 
			readXml = new ReadXMLFile();
			readXml.loadUserInfoConstants(instream);
			Field[] arrayOfField1 = super.getClass().getFields();
			Field[] arrayOfField2 = arrayOfField1;
			int i = arrayOfField2.length;
			for (int j = 0; j < i; ++j) {
				Field localField = arrayOfField2[j];
				Object localObject = localField.get(this);
				if (localObject instanceof String)
					localField
							.set(this, readXml.getValue((String) localObject));

			}
		} catch (Exception localException) {
			throw new RuntimeException("Loading "
					+ super.getClass().getSimpleName() + " failed",
					localException);
		}
	}
}
