package com.josecuentas.android_retrofit20.io.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PibeDx on 8/08/16.
 */
public class LibraryResponse extends BaseResponse <LibraryResponse.Data>{

	public class Data extends BaseDataResponse{
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

		@Override public String toString() {
			return "Data{" +
					"name='" + name + '\'' +
					", version='" + version + '\'' +
					", documentation='" + documentation + '\'' +
					", url='" + url + '\'' +
					'}';
		}
	}

}
