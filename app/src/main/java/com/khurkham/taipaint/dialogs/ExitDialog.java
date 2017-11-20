package com.khurkham.taipaint.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khurkham.taipaint.App;
import com.khurkham.taipaint.R;

import butterknife.OnClick;

public class ExitDialog extends BaseDialog {
    public class Callback {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return butterKnifeInflate(inflater, R.layout.exit_dialog, container);
    }

    @OnClick({R.id.done, R.id.cancel})
    public void onButtonsClick(View v) {
        if (v.getId() == R.id.done)
            App.getBus().post(new Callback());
        dismiss();
    }
}
