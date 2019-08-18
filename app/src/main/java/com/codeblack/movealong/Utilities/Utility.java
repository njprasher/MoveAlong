package com.codeblack.movealong.Utilities;

import android.content.Context;
import android.widget.Toast;


public class Utility {

    public static void utility_Toast(Context context , String message) {

        Toast.makeText(context, message ,Toast.LENGTH_SHORT).show();

    }
}
