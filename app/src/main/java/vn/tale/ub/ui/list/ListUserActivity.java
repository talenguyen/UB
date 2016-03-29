package vn.tale.ub.ui.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import javax.inject.Inject;
import rx.Subscription;
import vn.tale.ub.App;
import vn.tale.ub.R;

public class ListUserActivity extends AppCompatActivity {
  private static final String TAG = "ListUserActivity";
  @Inject UserListAdapter adapter;
  @Inject UserListVM viewModel;
  private RecyclerView recyclerView;
  private View vLoading;
  private TextView tvError;
  private Subscription loadUserSubscription;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    App.get(this).getComponent().plus(new UserListModule()).inject(this);

    findViews();

    setupBinding();

    setupListView();
  }

  @Override protected void onResume() {
    super.onResume();
    loadUserSubscription = viewModel.load()
        .subscribe(adapter::setItems, throwable -> Log.e(TAG, "load user error", throwable));
  }

  @Override protected void onPause() {
    if (loadUserSubscription != null) {
      loadUserSubscription.unsubscribe();
    }
    super.onPause();
  }

  private void setupListView() {
    if (recyclerView != null) {
      recyclerView.setLayoutManager(
          new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
      recyclerView.setHasFixedSize(true);
      recyclerView.setAdapter(adapter);
    }
  }

  private void setupBinding() {
    viewModel.isLoading()
        .subscribe(loading -> {
          vLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
        });

    viewModel.isError()
        .subscribe(error -> {
          tvError.setVisibility(error ? View.VISIBLE : View.GONE);
        });

    viewModel.errorMessage().subscribe(tvError::setText);

    viewModel.lightError()
        .subscribe(msg -> Toast.makeText(ListUserActivity.this, msg, Toast.LENGTH_SHORT).show());

    viewModel.isShowContent()
        .subscribe(
            showContent -> recyclerView.setVisibility(showContent ? View.VISIBLE : View.GONE));
  }

  private void findViews() {
    recyclerView = (RecyclerView) findViewById(R.id.list);
    vLoading = findViewById(R.id.vProgress);
    tvError = (TextView) findViewById(R.id.tvError);
  }
}
