package vn.tale.ub;

import android.app.Application;
import vn.tale.ub.ui.list.UserListApi;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
public interface ApiModule {

  UserListApi provideUserListApi(Application application);

}
