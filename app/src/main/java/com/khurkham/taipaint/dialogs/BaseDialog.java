package com.khurkham.taipaint.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khurkham.taipaint.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

abstract class BaseDialog extends DialogFragment {
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.BaseDialog);
    }

    protected View butterKnifeInflate(LayoutInflater inflater, int layoutResId, ViewGroup parent) {
        View root = inflater.inflate(layoutResId, parent, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onDestroyView() {
        if (unbinder != null)
            unbinder.unbind();
        super.onDestroyView();
    }
}
