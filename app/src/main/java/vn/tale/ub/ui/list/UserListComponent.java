package vn.tale.ub.ui.list;

import dagger.Subcomponent;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
@Subcomponent(modules = UserListModule.class)
public interface UserListComponent {
  void inject(ListUserActivity activity);
}
