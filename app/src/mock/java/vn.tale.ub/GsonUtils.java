package vn.tale.ub;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import vn.tale.ub.model.GsonAdaptersUser;
import vn.tale.ub.model.User;

/**
 * Author giangnguyen. Created on 3/29/16.
 */
public class GsonUtils {

  public static final Gson GSON;
  static {
    final GsonBuilder gsonBuilder =
        new GsonBuilder().registerTypeAdapterFactory(new GsonAdaptersUser());
    GSON = gsonBuilder.create();
  }

  public static <T> T readJsonStream(InputStream in, Type typeOfT) throws IOException {
    final Reader reader = new InputStreamReader(in);
    final T fromJson = GSON.fromJson(reader, typeOfT);
    in.close();
    return fromJson;
  }
}
