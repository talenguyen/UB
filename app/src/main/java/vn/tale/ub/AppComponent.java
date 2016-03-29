package vn.tale.ub;

import dagger.Component;
import vn.tale.ub.ui.list.UserListComponent;
import vn.tale.ub.ui.list.UserListModule;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
@Component(modules = { AppModule.class, ApiModule.class })
public interface AppComponent {
  UserListComponent plus(UserListModule module);
}
