package vn.tale.ub.ui.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import javax.inject.Inject;
import vn.tale.lcebinding.ErrorView;
import vn.tale.lcebinding.LceBinding;
import vn.tale.lcebinding.ShowHideView;
import vn.tale.ub.App;
import vn.tale.ub.R;
import vn.tale.ub.ui.binding.ErrorTextView;
import vn.tale.ub.ui.binding.ToggleVisibleGone;

public class ListUserActivity extends AppCompatActivity {
  @Inject UserListAdapter adapter;
  @Inject UserListVM viewModel;
  @Inject LceBinding lceBinding;

  @Bind(R.id.list) RecyclerView recyclerView;
  @Bind(R.id.vProgress) View vLoading;
  @Bind(R.id.tvError) TextView tvError;

  private ShowHideView loadingView;
  private ErrorView errorView;
  private ShowHideView contentView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);

    setupDependencies();

    setupListView();
  }

  private void setupDependencies() {
    App.get(this).getComponent().plus(new UserListModule()).inject(this);
    loadingView = new ToggleVisibleGone(vLoading);
    errorView = new ErrorTextView(tvError);
    contentView = new ToggleVisibleGone(recyclerView);
  }

  @Override protected void onResume() {
    super.onResume();
    lceBinding.bind(viewModel.getLce(), loadingView, contentView, errorView);
    loadData();
  }

  @OnClick(R.id.tvError)
  public void loadData() {
    viewModel.load();
  }

  @Override protected void onPause() {
    viewModel.unsubscribe();
    lceBinding.unbind();
    super.onPause();
  }

  private void setupListView() {
    if (recyclerView != null) {
      recyclerView.setLayoutManager(
          new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
      recyclerView.setHasFixedSize(true);
      recyclerView.setAdapter(adapter);
    }
    viewModel.getUsersStream().subscribe(adapter::setItems);
  }
}
