package com.josecuentas.android_retrofit20.io.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by José Norberto Cuentas Turpo.
 * Email: <jcuentast@gmail.com> on 9/08/16.
 * GitHub: PibeDx
 */
public class BaseDataResponse {
	@SerializedName("created")
	@Expose
	public float created;

	@SerializedName("___class")
	@Expose
	public String _class;

	@SerializedName("ownerId")
	@Expose
	public Object ownerId;

	@SerializedName("updated")
	@Expose
	public Object updated;

	@SerializedName("objectId")
	@Expose
	public String objectId;

	@SerializedName("__meta")
	@Expose
	public String meta;



}
