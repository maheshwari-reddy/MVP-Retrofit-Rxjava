package com.developer.maheshwari.networkcallusingretrofitandrxjava.model;

import android.util.Log;

import com.developer.maheshwari.networkcallusingretrofitandrxjava.networking.DataService;
import com.developer.maheshwari.networkcallusingretrofitandrxjava.networking.ServiceGenerator;
import com.developer.maheshwari.networkcallusingretrofitandrxjava.pojo.Data;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by maheshwarireddy on 04/02/18.
 */

class GetDataInteracter implements iGetDataInteractor {

    private String TAG = getClass().getSimpleName();

    @Override
    public void fetchData(final iGetDataResponseListener listener) {
        DataService endpoint = ServiceGenerator.getClient().create(DataService.class);
        endpoint.fetchComments()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Data>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Data> datas) {
                        Log.w(TAG, "onNext " + datas.size());
                        listener.onSuccess(datas);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        listener.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
