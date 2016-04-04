package vn.tale.ub.ui.list;

import dagger.Subcomponent;
import vn.tale.ub.di.ActivityScope;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
@ActivityScope
@Subcomponent(modules = UserListModule.class)
public interface UserListComponent {
  void inject(ListUserActivity activity);
}
