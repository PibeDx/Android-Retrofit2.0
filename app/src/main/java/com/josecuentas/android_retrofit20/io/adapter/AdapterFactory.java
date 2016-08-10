package com.josecuentas.android_retrofit20.io.adapter;

import com.josecuentas.android_retrofit20.BuildConfig;
import com.josecuentas.android_retrofit20.util.Contants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PibeDx on 8/08/16.
 */
public class AdapterFactory {

  public static <T> T retrofitService(final Class<T> tClass) {

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BuildConfig.HOST)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    return retrofit.create(tClass);
  }

  public static <T> T retrofitServiceAutoHeader(final Class<T> tClass) {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BuildConfig.HOST)
        .addConverterFactory(GsonConverterFactory.create())
        .client(clientCustom())
        .build();
    return retrofit.create(tClass);
  }


  //custom clientCustom
  private static OkHttpClient clientCustom(){
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    //Logging custom
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);

    httpClient.addInterceptor(new HeaderInterceptor());
    httpClient.interceptors().add(logging);// <-- this is the important line!
    //httpClient.addInterceptor(logging);// Me dio error :(
    OkHttpClient client = httpClient.build();
    return client;
  }

  // header custom
  static class HeaderInterceptor implements Interceptor{
    @Override public Response intercept(Chain chain) throws IOException {
      Request original = chain.request();

      Request request = original.newBuilder()
          .header("application-id" , Contants.APPLICATION_KEY)
          .header("secret-key" , Contants.REST_API_KEY)
          //.header("Content-Type" , "application/json")
          .header("application-type" , "REST")
          .method(original.method(), original.body())
          .build();
      return chain.proceed(request);
    }
  }


}
