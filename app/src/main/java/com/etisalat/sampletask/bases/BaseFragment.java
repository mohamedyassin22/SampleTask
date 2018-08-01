package com.etisalat.sampletask.bases;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import android.support.design.widget.Snackbar;

import com.etisalat.sampletask.R;

public abstract class BaseFragment<T extends BasePresenter> extends
        Fragment implements BasePresenterListener {
    private ProgressDialog progressDialog;
    protected T presenter;
    public View layout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = setupPresenter();
    }

    protected abstract T setupPresenter();

    @Override
    public void showProgress() {
        if (progressDialog == null) {
            if (getActivity() == null) return;
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage(getResources().getString(
                    R.string.pleasewait));
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

                @Override
                public void onCancel(DialogInterface dialog) {
                    if (getActivity() != null)
                        getActivity().finish();
                }
            });
        }
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        if (getActivity() != null && !getActivity().isFinishing() && progressDialog != null
                && progressDialog.isShowing())
            progressDialog.dismiss();
    }
     public void showSnackbar(String message) {
        if (layout!=null && isAdded()) {
            Snackbar snackbar = Snackbar.make(layout, message, Snackbar.LENGTH_LONG);
            View view = snackbar.getView();
            TextView tv = view.findViewById(android.support.design.R.id.snackbar_text);
            tv.setTextColor(android.graphics.Color.WHITE);
            snackbar.show();
        }
    }

}
