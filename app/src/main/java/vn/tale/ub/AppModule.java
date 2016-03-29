package vn.tale.ub;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import vn.tale.lcebinding.ErrorMessageProvider;
import vn.tale.lcebinding.NoElementException;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
@Module public class AppModule {
  private final Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides @Singleton public ErrorMessageProvider provideErrorMessageProvider() {
    return new ErrorMessageProvider() {
      @Override public String getErrorMessage(Throwable throwable) {
        if (throwable instanceof NoElementException) {
          return application.getString(R.string.error_empty);
        }
        return application.getString(R.string.error_try_again);
      }

      @Override public String getLightErrorMessage(Throwable throwable) {
        return getErrorMessage(throwable);
      }
    };
  }

}
