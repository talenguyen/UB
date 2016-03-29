package vn.tale.ub.ui.adapter;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

  private final List<T> items = new ArrayList<>();

  public void setItems(List<T> items) {
    this.items.clear();
    this.items.addAll(items);
    notifyDataSetChanged();
  }

  public T getItem(int position) {
    if (position < 0 || position >= items.size()) {
      return null;
    }
    return items.get(position);
  }

  @Override public int getItemCount() {
    return items.size();
  }
}
