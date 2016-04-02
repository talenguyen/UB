package vn.tale.ub.ui.list;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import vn.tale.lcebinding.ErrorMessageProvider;
import vn.tale.lcebinding.LceBinding;
import vn.tale.lcebinding.LoadingContentError;
import vn.tale.lcebinding.ThreadScheduler;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
@Module
public class UserListModule {

  @Provides public UserListAdapter provideUserListAdapter() {
    return new UserListAdapter();
  }

  @Provides public ThreadScheduler provideThreadScheduler() {
    return new ThreadScheduler() {
      @Override public Scheduler subscribeOn() {
        return Schedulers.computation();
      }

      @Override public Scheduler observeOn() {
        return AndroidSchedulers.mainThread();
      }
    };
  }

  @Provides public UserListVM provideUesrListVM(LceBinding lceBinding,
      ThreadScheduler threadScheduler, UserListApi apiClient) {
    return new UserListVM(lceBinding, apiClient, threadScheduler);
  }

  @Provides
  public LoadingContentError provideLoadingContentError(ErrorMessageProvider errorMessageProvider) {
    return new LoadingContentError(errorMessageProvider);
  }

  @Provides public LceBinding provideLceBinding(LoadingContentError loadingContentError) {
    return new LceBinding(loadingContentError);
  }

}
