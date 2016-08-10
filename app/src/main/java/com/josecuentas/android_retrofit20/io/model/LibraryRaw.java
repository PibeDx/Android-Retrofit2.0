package com.josecuentas.android_retrofit20.io.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by José Norberto Cuentas Turpo.
 * Email: <jcuentast@gmail.com> on 9/08/16.
 * GitHub: PibeDx
 */
public class LibraryRaw {
	@SerializedName("name")
	@Expose
	public String name;

	@SerializedName("version")
	@Expose
	public String version;

	@SerializedName("documentation")
	@Expose
	public String documentation;

	@SerializedName("url")
	@Expose
	public String url;

	//PUT
	@SerializedName("objectId")
	@Expose
	public String objectId;
}
