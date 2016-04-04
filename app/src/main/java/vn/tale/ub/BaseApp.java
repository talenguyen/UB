package vn.tale.ub;

import android.app.Application;
import android.content.Context;
import vn.tale.ub.di.AppComponent;
import vn.tale.ub.di.DaggerAppComponent;

/**
 * Author giangnguyen. Created on 4/1/16.
 */
public abstract class BaseApp extends Application {

  private AppComponent component;

  public static BaseApp get(Context context) {
    return (BaseApp) context.getApplicationContext();
  }
  @Override public void onCreate() {
    super.onCreate();

    DaggerAppComponent.Builder builder = prepareAppComponentBuilder();
    component = builder.build();
  }

  public AppComponent getComponent() {
    return component;
  }


  protected abstract DaggerAppComponent.Builder prepareAppComponentBuilder();
}
