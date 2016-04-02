package vn.tale.ub;

import android.util.Log;

/**
 * Author giangnguyen. Created on 4/2/16.
 */
public class Logger {
  private static final String TAG = "Logger";

  public static void e(Throwable tr, String format, Object... args) {
    if (!BuildConfig.DEBUG) {
      return;
    }
    final String msg = String.format(format, args);
    Log.e(TAG, msg, tr);
  }
}
