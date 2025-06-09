package com.example.analyticslibrary;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import okhttp3.*;


public class Analytics {
    public enum Gender {male, female}



    public interface CallBack {
        void onResult(List<String> names);

    }

    public static void getNamesFromServer(CallBack cb, Gender gender) {
        Log.d("getNamesFromServer", ""+gender);
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://127.0.0.1:5000/getNames")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e("Analytics", "Failed to get names from server", e);

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response.message());
                }
                cb.onResult(Arrays.asList(response.body().string().split(" ")));
            }
        });

    }
}


//    public static void getRandomNamesByGender(Gender gender, int limit, CallBack cb){
//
//    }
//
//    public static void getRandomNames(int limit, CallBack cb){
//
//    }
