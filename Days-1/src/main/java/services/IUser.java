package services;

import models.User;
import models.users.Users;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IUser {

    @POST("users/add")
    Call<User> userSave( @Body User user );

    @GET("users")
    Call<Users> users();



}
