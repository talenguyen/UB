package vn.tale.ub.ui.list;

import com.jakewharton.rxrelay.BehaviorRelay;
import com.jakewharton.rxrelay.SerializedRelay;
import java.util.List;
import java.util.NoSuchElementException;
import rx.Observable;
import rx.Subscription;
import vn.tale.ub.Logger;
import vn.tale.ub.model.User;
import vn.tale.lcebinding.LceBinding;
import vn.tale.lcebinding.ThreadScheduler;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
public class UserListVM {

  private final UserListApi apiClient;
  private final LceBinding lceBinding;
  private final ThreadScheduler threadScheduler;
  private final SerializedRelay<List<User>, List<User>> usersStream = BehaviorRelay.<List<User>>create()
      .toSerialized();
  private Subscription loadUsersSubscription;

  public UserListVM(LceBinding lceBinding, UserListApi apiClient, ThreadScheduler threadScheduler) {
    this.lceBinding = lceBinding;
    this.apiClient = apiClient;
    this.threadScheduler = threadScheduler;
  }

  public LceBinding binding() {
    return lceBinding;
  }

  public SerializedRelay<List<User>, List<User>> getUsersStream() {
    return usersStream;
  }

  public void load() {
    final Observable<List<User>> usersOrNoSuchElementErrorStream =
        apiClient.getUsers()
            .switchIfEmpty(Observable.error(new NoSuchElementException()))
            .flatMap(users -> {
              if (users.size() == 0) {
                return Observable.error(new NoSuchElementException());
              } else {
                return Observable.just(users);
              }
            });

    loadUsersSubscription =
        lceBinding.createLceStream(usersOrNoSuchElementErrorStream, threadScheduler)
            .subscribe(usersStream::call, throwable -> Logger.e(throwable, "load users error"));
  }

  public void unsubscribe() {
    lceBinding.unbind();
    if (loadUsersSubscription != null) {
      loadUsersSubscription.unsubscribe();
    }
  }
}
