package vn.tale.ub.ui.list;

import dagger.Module;
import dagger.Provides;
import vn.tale.lcebinding.ErrorMessageProvider;
import vn.tale.lcebinding.LceBinding;
import vn.tale.lcebinding.LoadingContentError;
import vn.tale.ub.util.ComputationMainThreadScheduler;
import vn.tale.ub.util.ThreadScheduler;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
@Module
public class UserListModule {

  @Provides public UserListAdapter provideUserListAdapter() {
    return new UserListAdapter();
  }

  @Provides public ThreadScheduler provideThreadScheduler() {
    return new ComputationMainThreadScheduler();
  }

  @Provides public UserListVM provideUesrListVM(LoadingContentError loadingContentError,
      ThreadScheduler threadScheduler, UserListApi apiClient) {
    return new UserListVM(loadingContentError, apiClient, threadScheduler);
  }

  @Provides
  public LoadingContentError provideLoadingContentError(ErrorMessageProvider errorMessageProvider) {
    return new LoadingContentError(errorMessageProvider);
  }

  @Provides public LceBinding provideLceBinding(LoadingContentError loadingContentError) {
    return new LceBinding(loadingContentError);
  }

}
