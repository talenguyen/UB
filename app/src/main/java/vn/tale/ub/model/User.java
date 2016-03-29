package vn.tale.ub.model;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
@Value.Immutable
@Gson.TypeAdapters
public interface User {
  @SerializedName("login") String displayName();

  @SerializedName("avatar_url") String avatarUrl();
}
