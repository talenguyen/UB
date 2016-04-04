package vn.tale.ub;

import android.support.annotation.NonNull;
import vn.tale.ub.di.AppApiModule;
import vn.tale.ub.di.AppModule;
import vn.tale.ub.di.DaggerAppComponent;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
public class App extends BaseApp {

  @NonNull protected DaggerAppComponent.Builder prepareAppComponentBuilder() {
    return DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .appApiModule(new AppApiModule(this));
  }
}
