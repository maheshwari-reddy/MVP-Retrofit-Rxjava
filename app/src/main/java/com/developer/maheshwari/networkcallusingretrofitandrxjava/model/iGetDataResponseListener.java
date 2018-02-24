package com.developer.maheshwari.networkcallusingretrofitandrxjava.model;

import com.developer.maheshwari.networkcallusingretrofitandrxjava.pojo.Data;

import java.util.List;

/**
 * Created by maheshwarireddy on 04/02/18.
 */

public interface iGetDataResponseListener {

    void onSuccess(List<Data> data);

    void onError(String errorMessage);
}
