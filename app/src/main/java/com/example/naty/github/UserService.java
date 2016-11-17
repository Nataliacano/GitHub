package com.example.naty.github;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Naty on 27/10/2016.
 */
public interface UserService {
    @GET("/users/{login}")
    void obtenerUsuario(@Path("login") String login, Callback<User> user);



    @GET("/users/{login}/repos/")
    void obtenerRespotorios(@Path("login")String login, Callback<List<Repository>> callback);



    //@GET("/users/{leodufer}")
   // public void obtenerUsuarioEstatico(@Path("login") String login);

}
