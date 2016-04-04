package vn.tale.ub.util;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Giang Nguyen on 4/4/16.
 */
public class ComputationMainThreadScheduler implements ThreadScheduler {

  @Override public Scheduler subscribeOn() {
    return Schedulers.computation();
  }

  @Override public Scheduler observeOn() {
    return AndroidSchedulers.mainThread();
  }
}
