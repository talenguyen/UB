package vn.tale.ub.ui.list;

import dagger.Subcomponent;
import vn.tale.ub.di.ActivityScope;
import vn.tale.ub.di.LceBindingModule;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
@ActivityScope
@Subcomponent(modules = { UserListModule.class, LceBindingModule.class })
public interface UserListComponent {
  void inject(ListUserActivity activity);
}
