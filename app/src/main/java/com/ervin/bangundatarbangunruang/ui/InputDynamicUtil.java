package com.ervin.bangundatarbangunruang.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class InputDynamicUtil {
    public static void dynamicInput(Context context, LinearLayout llInput, int nInput, String hint[], final SetCallback setCallback) {
        final ArrayList<EditText> listEt = new ArrayList();
        for (int i = 0; i < nInput; i++) {

            TextInputLayout textInputLayout = new TextInputLayout(context);
            LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 100f);

            final EditText etSisi = new EditText(context);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            listEt.add(etSisi);
            etSisi.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            etSisi.setHint(hint[i]);
            textInputLayout.addView(etSisi, lp);
            llInput.addView(textInputLayout, lp1);


            etSisi.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    setCallback.handlerInput(listEt);
                }
            });

        }
    }

    public interface SetCallback {
        void handlerInput(ArrayList<EditText> etList);
    }

}
