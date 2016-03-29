package vn.tale.ub;

import dagger.Provides;
import javax.inject.Singleton;
import vn.tale.ub.api.GithubApi;
import vn.tale.ub.ui.list.UserListApi;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
public interface ApiModule {

  @Provides @Singleton UserListApi provideUserListApi(GithubApi githubApi);

}
