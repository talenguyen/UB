package vn.tale.ub.util;

import rx.Scheduler;

/**
 * Created by Giang Nguyen on 4/4/16.
 */
public interface ThreadScheduler {

  Scheduler subscribeOn();

  Scheduler observeOn();
}
