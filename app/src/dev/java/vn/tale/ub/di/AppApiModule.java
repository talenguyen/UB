package vn.tale.ub.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.tale.ub.api.GithubApi;
import vn.tale.ub.model.GsonAdaptersUser;
import vn.tale.ub.ui.list.UserListApi;

/**
 * Author giangnguyen. Created on 3/30/16.
 */
@Module public class AppApiModule implements ApiModule {

  @Provides @Singleton public Gson provideGson() {
    final GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapterFactory(new GsonAdaptersUser());
    return builder.create();
  }

  @Provides @Singleton public GithubApi provideGithubApi(Gson gson) {
    final Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com")
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();

    return retrofit.create(GithubApi.class);
  }

  @Provides @Singleton @Override public UserListApi provideUserListApi() {
    return () -> provideGithubApi(provideGson()).getUsers();
  }
}
