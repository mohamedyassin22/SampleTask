package com.etisalat.sampletask.bases;

public interface BasePresenterListener {
    void showProgress();
    void hideProgress();
    void showSnackbar(String errMsg);
}
