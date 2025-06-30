package com.example.b3_c7.network;

import com.example.b3_c7.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {
    @GET("users")
    Call<List<User>> getUsers();
}
