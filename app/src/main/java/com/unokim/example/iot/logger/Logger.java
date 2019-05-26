package com.unokim.example.iot.logger;

import android.util.Log;

public final class Logger {

    private static final String TAG = "uno@";

    public static void d(String tag, String message) {
        Log.d(TAG + tag, "[" + Thread.currentThread().getName() + "] " + message);
    }

    public static void i(String tag, String message) {
        Log.i(TAG + tag, message);
    }

    public static void e(String tag, String message) {
        Log.e(TAG + tag, message);
    }
}