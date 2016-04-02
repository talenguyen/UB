package vn.tale.ub.ui.binding;

import android.view.View;
import android.widget.TextView;
import vn.tale.lcebinding.ErrorView;

/**
 * Author giangnguyen. Created on 4/2/16.
 */
public class ErrorTextView implements ErrorView {
  private final TextView textView;

  public ErrorTextView(TextView textView) {
    this.textView = textView;
  }

  @Override public void setError(String s) {
    textView.setText(s);
  }

  @Override public void show() {
    textView.setVisibility(View.VISIBLE);
  }

  @Override public void hide() {
    textView.setVisibility(View.GONE);
  }
}
