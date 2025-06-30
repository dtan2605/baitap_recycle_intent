package com.example.bai_2_c7.network;

import com.example.bai_2_c7.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("v2/list")
    Call<List<Photo>> getPhotos();
}
