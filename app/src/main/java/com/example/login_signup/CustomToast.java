package com.example.login_signup;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToast extends Toast {

    public static int SUCCESS = 1;
    public static int ERROR = 2;

    private static final long SHORT = 4000;
    private static final long LONG = 7000;

    public CustomToast(Context context) {
        super(context);
    }

    public static Toast makeText(Context context, String message, int duration, int type, boolean androidicon) {
        Toast toast = new Toast(context);
        toast.setDuration(duration);
        View layout = LayoutInflater.from(context).inflate(R.layout.customtoast_layout, null, false);
        TextView l1 = (TextView) layout.findViewById(R.id.toast_text);
        LinearLayout linearLayout = (LinearLayout) layout.findViewById(R.id.toast_type);
        l1.setText(message);
        if (type == 1) {
            linearLayout.setBackgroundResource(R.drawable.success_shape);
        } else if (type == 2) {
            linearLayout.setBackgroundResource(R.drawable.error_shape);
        }
        toast.setView(layout);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 100);
        return toast;
    }


}

