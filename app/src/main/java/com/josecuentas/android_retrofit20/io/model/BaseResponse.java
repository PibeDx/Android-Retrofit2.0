package com.josecuentas.android_retrofit20.io.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by José Norberto Cuentas Turpo.
 * Email: <jcuentast@gmail.com> on 9/08/16.
 * GitHub: PibeDx
 */
public class BaseResponse<P> {

	@SerializedName("offset")
	@Expose
	public Integer offset;
	@SerializedName("data")
	@Expose
	public List<P> data = new ArrayList<P>();
	@SerializedName("nextPage")
	@Expose
	public Object nextPage;
	@SerializedName("totalObjects")
	@Expose
	public Integer totalObjects;

	//Delete
	@SerializedName("deletionTime")
	@Expose
	public float deletionTime;


	//Error
	@SerializedName("code")
	@Expose
	public int code;
	@SerializedName("message")
	@Expose
	public String message;

}
