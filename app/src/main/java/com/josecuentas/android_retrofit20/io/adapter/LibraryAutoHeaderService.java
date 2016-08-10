package com.josecuentas.android_retrofit20.io.adapter;

import com.josecuentas.android_retrofit20.io.model.LibraryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by José Norberto Cuentas Turpo.
 * Email: <jcuentast@gmail.com> on 9/08/16.
 * GitHub: PibeDx
 */
public interface LibraryAutoHeaderService {
	@GET("/v1/data/Library") Call<LibraryResponse> getLibrary();
}
