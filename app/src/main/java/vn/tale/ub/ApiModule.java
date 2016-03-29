package vn.tale.ub;

import vn.tale.ub.api.GithubApi;
import vn.tale.ub.ui.list.UserListApi;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
public interface ApiModule {

  UserListApi provideUserListApi(GithubApi githubApi);

}
