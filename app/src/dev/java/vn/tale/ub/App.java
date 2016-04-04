package vn.tale.ub;

import android.support.annotation.NonNull;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
public class App extends BaseApp {

  @NonNull protected DaggerAppComponent.Builder prepareAppComponentBuilder() {
    return DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .appApiModule(new AppApiModule());
  }
}
