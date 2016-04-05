package vn.tale.ub.di;

import dagger.Module;
import dagger.Provides;
import vn.tale.lcebinding.ErrorMessageProvider;
import vn.tale.lcebinding.LceBinding;
import vn.tale.lcebinding.LoadingContentError;

/**
 * Created by Giang Nguyen on 4/4/16.
 */
@Module
public class LceBindingModule {

  @Provides
  public LoadingContentError provideLoadingContentError(ErrorMessageProvider errorMessageProvider) {
    return new LoadingContentError(errorMessageProvider);
  }

  @Provides public LceBinding provideLceBinding() {
    return new LceBinding();
  }
}
