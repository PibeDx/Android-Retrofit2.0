package com.josecuentas.android_retrofit20.io.adapter;

import com.josecuentas.android_retrofit20.io.model.LibraryResponse;
import com.josecuentas.android_retrofit20.util.Contants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by PibeDx on 8/08/16.
 */

public interface LibraryService {

	@Headers({
			"application-id: " + Contants.APPLICATION_KEY,
			"secret-key: " + Contants.REST_API_KEY,
			"Content-Type: application/json",
			"application-type: REST"
	})
	@GET("/v1/data/Library")
	Call<LibraryResponse> getLibrary();

}


