package vn.tale.ub.api;

import java.util.List;
import retrofit2.http.GET;
import rx.Observable;
import vn.tale.ub.model.User;

/**
 * Author giangnguyen. Created on 3/30/16.
 */
public interface GithubApi {
  @GET("/users")
  Observable<List<User>> getUsers();
}
