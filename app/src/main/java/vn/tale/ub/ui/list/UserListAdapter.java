package vn.tale.ub.ui.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import vn.tale.ub.R;
import vn.tale.ub.model.User;
import vn.tale.ub.ui.adapter.ListAdapter;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
public class UserListAdapter extends ListAdapter<User, UserListAdapter.UserVH> {

  @Override public UserVH onCreateViewHolder(ViewGroup parent, int viewType) {
    return null;
  }

  @Override public void onBindViewHolder(UserVH holder, int position) {

  }

  public static class UserVH extends RecyclerView.ViewHolder {

    private final TextView tvDisplayName;
    private final ImageView ivAvatar;

    public UserVH(View itemView) {
      super(itemView);
      tvDisplayName = (TextView) itemView.findViewById(R.id.tvDisplayName);
      ivAvatar = (ImageView) itemView.findViewById(R.id.ivAvatar);
    }

    public void bind(User user) {
      tvDisplayName.setText(user.displayName());

    }
  }
}
