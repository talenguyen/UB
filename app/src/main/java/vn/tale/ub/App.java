package vn.tale.ub;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
public class App extends Application {
  private AppComponent component;

  public static App get(Context context) {
    return (App) context.getApplicationContext();
  }
  @Override public void onCreate() {
    super.onCreate();

    DaggerAppComponent.Builder builder = prepareAppComponentBuilder();
    component = builder.build();
  }

  public AppComponent getComponent() {
    return component;
  }

  @NonNull protected DaggerAppComponent.Builder prepareAppComponentBuilder() {
    return DaggerAppComponent.builder();
  }
}
