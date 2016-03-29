package vn.tale.ub;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.tale.ub.api.GithubApi;
import vn.tale.ub.ui.list.UserListApi;

/**
 * Author giangnguyen. Created on 3/30/16.
 */
@Module public class AppApiModule implements ApiModule {

  @Provides @Singleton public GithubApi provideGithubApi() {
    final Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com")
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    return retrofit.create(GithubApi.class);
  }

  @Provides @Singleton @Override public UserListApi provideUserListApi(GithubApi githubApi) {
    return () -> githubApi.getUsers();
  }
}
