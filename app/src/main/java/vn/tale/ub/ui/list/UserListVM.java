package vn.tale.ub.ui.list;

import com.jakewharton.rxrelay.BehaviorRelay;
import com.jakewharton.rxrelay.SerializedRelay;
import java.util.List;
import rx.Subscription;
import vn.tale.androiddataloading.NotEmptyTransformer;
import vn.tale.lcebinding.LceBindingTransformer;
import vn.tale.lcebinding.LoadingContentError;
import vn.tale.ub.Logger;
import vn.tale.ub.model.User;
import vn.tale.ub.util.ThreadScheduler;
import vn.tale.ub.util.ThreadSchedulerTransformer;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
public class UserListVM {

  private final UserListApi apiClient;
  private final LoadingContentError loadingContentError;
  private final ThreadScheduler threadScheduler;
  private final SerializedRelay<List<User>, List<User>> usersStream =
      BehaviorRelay.<List<User>>create().toSerialized();
  private Subscription loadUsersSubscription;

  public UserListVM(LoadingContentError loadingContentError, UserListApi apiClient,
      ThreadScheduler threadScheduler) {
    this.loadingContentError = loadingContentError;
    this.apiClient = apiClient;
    this.threadScheduler = threadScheduler;
  }

  public LoadingContentError getLce() {
    return loadingContentError;
  }

  public SerializedRelay<List<User>, List<User>> getUsersStream() {
    return usersStream;
  }

  public void load() {
    loadUsersSubscription = apiClient.getUsers()
        .compose(new ThreadSchedulerTransformer<>(threadScheduler))
        .compose(new NotEmptyTransformer<>())
        .compose(new LceBindingTransformer<>(loadingContentError))
        .subscribe(usersStream::call, throwable -> Logger.e(throwable, "load users error"));
  }

  public void unsubscribe() {
    if (loadUsersSubscription != null) {
      loadUsersSubscription.unsubscribe();
    }
  }
}
