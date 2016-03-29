package vn.tale.ub.ui.list;

import java.util.List;
import rx.Observable;
import vn.tale.lcebinding.BaseLceViewModel;
import vn.tale.lcebinding.ErrorMessageProvider;
import vn.tale.lcebinding.NoElementException;
import vn.tale.lcebinding.ThreadScheduler;
import vn.tale.ub.model.User;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
public class UserListVM extends BaseLceViewModel<List<User>> {

  private final UserListApi apiClient;

  public UserListVM(ErrorMessageProvider errorMessageProvider, ThreadScheduler threadScheduler,
      UserListApi apiClient) {
    super(errorMessageProvider, threadScheduler);
    this.apiClient = apiClient;
  }

  public Observable<List<User>> load() {
    final Observable<List<User>> getUsersObservable = apiClient.getUsers().flatMap(users -> {
      if (users.size() == 0) {
        return Observable.error(new NoElementException());
      } else {
        return Observable.just(users);
      }
    });

    return start(getUsersObservable);
  }
}
