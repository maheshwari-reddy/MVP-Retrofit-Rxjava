package com.developer.maheshwari.networkcallusingretrofitandrxjava.model;

import com.developer.maheshwari.networkcallusingretrofitandrxjava.pojo.Data;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by maheshwarireddy on 04/02/18.
 */

public class GetDataPresenter implements iGetDataPresenter, iGetDataResponseListener {

    private GetDataInteracter interacter;
    private iGetDataView view;

    public GetDataPresenter(iGetDataView view) {
        this.view = view;
        interacter = new GetDataInteracter();
    }

    @Override
    public void fetchData() {
        interacter.fetchData(this);
    }

    @Override
    public void onSuccess(List<Data> data) {
        view.onSuccess(data);
    }

    @Override
    public void onError(String errorMessage) {
        view.onError(errorMessage);
    }
}
