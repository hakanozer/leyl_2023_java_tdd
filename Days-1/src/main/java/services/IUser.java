package services;

import models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IUser {

    @POST("users/add")
    Call<User> userSave( @Body User user );

}
