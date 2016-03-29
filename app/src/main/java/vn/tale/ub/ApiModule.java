package vn.tale.ub;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import vn.tale.ub.ui.list.UserListApi;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
@Module
public class ApiModule {

  @Provides @Singleton public UserListApi provideUserListApi() {
    return null;
  }
}
