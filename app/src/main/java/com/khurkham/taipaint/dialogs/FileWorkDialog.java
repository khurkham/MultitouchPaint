package com.khurkham.taipaint.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khurkham.taipaint.App;
import com.khurkham.taipaint.R;

public class FileWorkDialog extends BaseDialog {
    public enum Callback {
        ON_NEW_FILE(R.id.file_work_dialog_new_file),
        ON_OPEN(R.id.file_work_dialog_open),
        ON_SAVE(R.id.file_work_dialog_save);

        private final int buttonResId;

        Callback(int buttonResId) {
            this.buttonResId = buttonResId;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.file_work_dialog, container, false);
        for (Callback callback : Callback.values())
            root.findViewById(callback.buttonResId).setOnClickListener(v -> {
                App.getBus().post(callback);
                dismiss();
            });
        return root;

    }


}
