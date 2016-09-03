package com.example.user.asynctask;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by user on 9/3/2016.
 */
public class L {

    public static void m(String message)
    {
        Log.d("Swathi ",message);
    }

    public static void  s(Context context, String message)
    {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
