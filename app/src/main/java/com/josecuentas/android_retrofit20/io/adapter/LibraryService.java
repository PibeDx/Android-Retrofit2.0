package com.josecuentas.android_retrofit20.io.adapter;

import com.josecuentas.android_retrofit20.io.model.LibraryRaw;
import com.josecuentas.android_retrofit20.io.model.LibraryResponse;
import com.josecuentas.android_retrofit20.util.Contants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

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

	@Headers({"Content-Type: application/json"})
	@POST("/v1/data/Library")
	Call<LibraryResponse.Data> addLibrary(@Body LibraryRaw libraryRaw);

	@DELETE("/v1/data/Library/{id}")
	Call<LibraryResponse> deleteLibrary(@Path("id") String idLibrary );

	@Headers({"Content-Type: application/json"})
	@PUT("/v1/data/Library/{id}")
	Call<LibraryResponse.Data> updateLibrary(@Path("id") String idLibrary, @Body LibraryRaw libraryRaw);






}
