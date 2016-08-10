package com.josecuentas.android_retrofit20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.josecuentas.android_retrofit20.io.adapter.AdapterFactory;
import com.josecuentas.android_retrofit20.io.adapter.LibraryAutoHeaderService;
import com.josecuentas.android_retrofit20.io.adapter.LibraryService;
import com.josecuentas.android_retrofit20.io.model.LibraryRaw;
import com.josecuentas.android_retrofit20.io.model.LibraryResponse;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


	@Bind(R.id.btn_listar) Button mBtnListar;
	@Bind(R.id.btn_agregar) Button mBtnAgregar;
	@Bind(R.id.txv_resultado) TextView mTxvResultado;
	@Bind(R.id.btn_eliminar) Button mBtnEliminar;
	@Bind(R.id.btn_actualizar) Button mBtnActualizar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		;
//		serviceAddLibrary();
		mBtnListar.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				serviceGetLibraryAutoHeader();
			}
		});
		mBtnAgregar.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				serviceAddLibrary();
			}
		});
		mBtnEliminar.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				serviceDeleteLibrary();
			}
		});
		mBtnActualizar.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				serviceUpdateLibrary();
			}
		});

	}

	private void serviceGetLibraryAutoHeader() {
		Call<LibraryResponse> library = AdapterFactory
				.retrofitServiceAutoHeader(LibraryAutoHeaderService.class)
				.getLibrary();

		library.enqueue(new Callback<LibraryResponse>() {
			@Override public void onResponse(Call<LibraryResponse> call, Response<LibraryResponse> response) {
				LibraryResponse body = response.body();
				String resultado = "";
				for (LibraryResponse.Data data : body.data) {
					resultado += data.name + "\n" + data.objectId + "\n";

				}
				System.out.println("resultado: " + resultado);
				mTxvResultado.setText(resultado);
			}

			@Override public void onFailure(Call<LibraryResponse> call, Throwable t) {
				System.out.println("onFailure");
				t.printStackTrace();
			}
		});
	}

	private void serviceGetLibrary() {
		Call<LibraryResponse> library = AdapterFactory
				.retrofitService(LibraryService.class)
				.getLibrary();

		library.enqueue(new Callback<LibraryResponse>() {
			@Override public void onResponse(Call<LibraryResponse> call, Response<LibraryResponse> response) {
				LibraryResponse body = response.body();
				String name = body.data.get(0).name;
				System.out.println("name: " + name);
			}

			@Override public void onFailure(Call<LibraryResponse> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}

	private void serviceAddLibrary() {
		LibraryRaw libraryRaw = new LibraryRaw();
		libraryRaw.documentation = "document";
		libraryRaw.name = "nombre";
		libraryRaw.url = "www.google.com";
		libraryRaw.version = "4.4";
		Call<LibraryResponse.Data> dataCall = AdapterFactory
				.retrofitServiceAutoHeader(LibraryService.class)
				.addLibrary(libraryRaw);

		dataCall.enqueue(new Callback<LibraryResponse.Data>() {
			@Override public void onResponse(Call<LibraryResponse.Data> call, Response<LibraryResponse.Data> response) {
				LibraryResponse.Data body = response.body();
				System.out.println("Data: " + body.toString());
			}

			@Override public void onFailure(Call<LibraryResponse.Data> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}

	private void serviceDeleteLibrary() {
		Call<LibraryResponse> libraryResponseCall = AdapterFactory
				.retrofitServiceAutoHeader(LibraryService.class)
				.deleteLibrary("8C7688FA-C0DF-5C9B-FFC0-BE9858B24E00");

		libraryResponseCall.enqueue(new Callback<LibraryResponse>() {
			@Override public void onResponse(Call<LibraryResponse> call, Response<LibraryResponse> response) {
				if (response.isSuccessful()) {
					LibraryResponse body = response.body();
					System.out.println("onResponse: " + body.deletionTime);
				} else {
					System.out.println("onError");
				}

			}

			@Override public void onFailure(Call<LibraryResponse> call, Throwable t) {
				System.out.println("onFailure");
			}
		});
	}

	private void serviceUpdateLibrary() {
		LibraryRaw libraryRaw = new LibraryRaw();
		libraryRaw.documentation = "document";
		libraryRaw.name = "nombre";
		libraryRaw.url = "www.google.com";
		libraryRaw.version = "4.4";
		libraryRaw.objectId = "2EF214D6-8FC2-B802-FF73-BE0341C3E100";
		Call<LibraryResponse.Data> libraryResponseCall = AdapterFactory
				.retrofitServiceAutoHeader(LibraryService.class)
				.updateLibrary(libraryRaw.objectId,libraryRaw);
		libraryResponseCall.enqueue(new Callback<LibraryResponse.Data>() {
			@Override public void onResponse(Call<LibraryResponse.Data> call, Response<LibraryResponse.Data> response) {
				response.toString();
			}

			@Override public void onFailure(Call<LibraryResponse.Data> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}


}
