// Copy right WeCook Inc.
package com.common.core.debug;

import android.util.Log;

/**
 * 日志打印辅助类
 *
 * @author kevin
 * @version v1.0
 * @since 2014-Sep 17, 2014
 */
public class Logger {

    /**
     * dump method name
     */
    public static void dumpMethod() {
        String methodName = "Dump[method]-";
        Throwable throwable = new Throwable();
        StackTraceElement[] stacks = throwable.getStackTrace();
        if (stacks != null && stacks.length != 0) {
            methodName += stacks[0].getMethodName();
        }
        i(methodName);
    }

    public static void v(String msg) {
        v(DebugCenter.makeTag(), msg, null);
    }

    public static void v(String tag, String msg) {
        v(tag, msg, null);
    }

    public static void v(Class<?> cls, String msg) {
        v(DebugCenter.makeTag(cls), msg, null);
    }

    public static void v(String msg, Throwable cause) {
        v(DebugCenter.makeTag(), msg, cause);
    }

    public static void v(String tag, String msg, Throwable cause) {
        if (DebugCenter.isDebugable() || DebugCenter.isLoggable(tag, Log.VERBOSE)) {
            Log.v(tag, msg, cause);
        }
    }

    public static void i(String msg) {
        i(DebugCenter.makeTag(), msg, null);
    }

    public static void i(String tag, String msg) {
        i(tag, msg, null);
    }

    public static void i(Class<?> cls, String msg) {
        i(DebugCenter.makeTag(cls), msg, null);
    }

    public static void i(String msg, Throwable cause) {
        i(DebugCenter.makeTag(), msg, cause);
    }

    public static void i(String tag, String msg, Throwable cause) {
        if (DebugCenter.isDebugable() || DebugCenter.isLoggable(tag, Log.INFO)) {
            Log.i(tag, msg, cause);
        }
    }

    public static void d(String msg) {
        d(DebugCenter.makeTag(), msg, null);
    }

    /**
     * 专用打印（李括）
     *
     * @param key
     * @param value
     */
    public static void dLK(String key, String value) {
        d("--likuo-------->", "key:" + key + "\r\nvalue:" + value, null);
    }


    public static void dLK(String key, boolean value) {
        d("--likuo-------->", "key:" + key + "\r\nvalue:" + value, null);
    }

    public static void dLK(String key, int value) {
        d("--likuo-------->", "key:" + key + "\r\nvalue:" + value, null);
    }

    public static void dLK(String key, Object value) {
        d("--likuo-------->", "key:" + key + "\r\nvalue:" + value.toString(), null);
    }

    public static void dLK(Object obj) {
        d("--likuo-------->", "value:" + obj.toString(), null);
    }

    public static void d(String tag, String msg) {
        d(tag, msg, null);
    }

    public static void d(Class<?> cls, String msg) {
        d(DebugCenter.makeTag(cls), msg, null);
    }

    public static void d(String msg, Throwable cause) {
        d(DebugCenter.makeTag(), msg, cause);
    }

    public static void d(String tag, String msg, Throwable cause) {
        if (DebugCenter.isDebugable() || DebugCenter.isLoggable(tag, Log.DEBUG)) {
            Log.d(tag, msg, cause);
        }
    }

    public static void w(String msg) {
        w(DebugCenter.makeTag(), msg, null);
    }

    public static void w(String tag, String msg) {
        w(tag, msg, null);
    }

    public static void w(Class<?> cls, String msg) {
        w(DebugCenter.makeTag(cls), msg, null);
    }

    public static void w(String msg, Throwable cause) {
        w(DebugCenter.makeTag(), msg, cause);
    }

    public static void w(String tag, String msg, Throwable cause) {
        if (DebugCenter.isDebugable() || DebugCenter.isLoggable(tag, Log.WARN)) {
            Log.w(tag, msg, cause);
        }
    }

    public static void e(String msg) {
        e(DebugCenter.makeTag(), msg, null);
    }

    public static void e(String tag, String msg) {
        e(tag, msg, null);
    }

    public static void e(Class<?> cls, String msg) {
        e(DebugCenter.makeTag(cls), msg, null);
    }

    public static void e(String msg, Throwable cause) {
        e(DebugCenter.makeTag(), msg, cause);
    }

    public static void e(String tag, String msg, Throwable cause) {
        if (DebugCenter.isDebugable() || DebugCenter.isLoggable(tag, Log.ERROR)) {
            Log.e(tag, msg, cause);
        }
    }

    public static void verbose(String tag, String msg, Object... params) {
        paramsLog(Log.VERBOSE, tag, msg, params);
    }

    public static void debug(String tag, String msg, Object... params) {
        paramsLog(Log.DEBUG, tag, msg, params);
    }

    public static void info(String tag, String msg, Object... params) {
        paramsLog(Log.INFO, tag, msg, params);
    }

    public static void warn(String tag, String msg, Object... params) {
        paramsLog(Log.WARN, tag, msg, params);
    }

    public static void error(String tag, String msg, Object... params) {
        paramsLog(Log.ERROR, tag, msg, params);
    }

    public static void paramsLog(int level, String tag, String msg, Object... params) {
        Throwable throwable = null;
        String paramsString = "{keys:[";
        if (params != null && params.length > 0) {
            int count = 0;
            for (Object p : params) {
                if (p instanceof Throwable) {
                    throwable = (Throwable) p;
                } else {
                    paramsString += "<p" + count + ":" + String.valueOf(p) + "> | ";
                }
                count++;
            }
        }

        paramsString += "]}";

        switch (level) {
            case Log.VERBOSE:
                v(tag, msg + paramsString, throwable);
                break;
            case Log.DEBUG:
                d(tag, msg + paramsString, throwable);
                break;
            case Log.INFO:
                i(tag, msg + paramsString, throwable);
                break;
            case Log.WARN:
                w(tag, msg + paramsString, throwable);
                break;
            case Log.ERROR:
                e(tag, msg + paramsString, throwable);
                break;
        }

    }
}
