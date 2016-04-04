package vn.tale.ub.util;

import rx.Observable;

/**
 * Created by Giang Nguyen on 4/4/16.
 */
public class ThreadSchedulerTransformer<T> implements Observable.Transformer<T, T> {

  private ThreadScheduler threadScheduler;

  public ThreadSchedulerTransformer(ThreadScheduler threadScheduler) {
    this.threadScheduler = threadScheduler;
  }

  @Override public Observable<T> call(Observable<T> sourceStream) {
    return sourceStream.subscribeOn(threadScheduler.subscribeOn())
        .observeOn(threadScheduler.observeOn());
  }
}
