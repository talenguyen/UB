package vn.tale.ub.ui.binding;

import android.view.View;
import vn.tale.lcebinding.ShowHideView;

/**
 * Author giangnguyen. Created on 4/2/16.
 */
public class ToggleVisibleGone implements ShowHideView {

  private View view;

  public ToggleVisibleGone(View view) {
    this.view = view;
  }

  @Override public void show() {
    view.setVisibility(View.VISIBLE);
  }

  @Override public void hide() {
    view.setVisibility(View.GONE);
  }
}
