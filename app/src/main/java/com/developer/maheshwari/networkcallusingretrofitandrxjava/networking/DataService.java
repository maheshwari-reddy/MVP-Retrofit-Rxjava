package com.developer.maheshwari.networkcallusingretrofitandrxjava.networking;



import com.developer.maheshwari.networkcallusingretrofitandrxjava.pojo.Data;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * Created by maheshwarireddy on 04/02/18.
 */

public interface DataService {

    @GET("comments")
    Observable<List<Data>> fetchComments();

}
