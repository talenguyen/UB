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
    items.clear();
    items.addAll(items);
    notifyDataSetChanged();
  }

  @Override public int getItemCount() {
    return items.size();
  }
}
