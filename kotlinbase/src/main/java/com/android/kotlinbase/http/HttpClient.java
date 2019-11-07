package com.android.kotlinbase.http;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/11/07 15:18
 */
public class HttpClient extends OkHttpClient {

    private HttpClient() {
    }

    public static final HttpClient INSTANCE = new HttpClient();

    private static final Gson gson = new Gson();

    @NonNull
    private static <T> T convert(String json, Type type) {
        return gson.fromJson(json, type);
    }

    @SuppressWarnings("unchecked")
    public <T> void get(String path, final Type type, final EntityCallback<T> entityCallback) {
        final Request request = new Request.Builder()
                .url("https://api.hencoder.com/" + path)
                .build();
        final Call call = INSTANCE.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                entityCallback.onFailure("网络异常");
            }

            @Override
            public void onResponse(Call call, Response response) {
                final int code = response.code();
                if (code >= 200 && code < 300) {
                    final ResponseBody body = response.body();
                    String json = null;
                    try {
                        json = body.string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    entityCallback.onSuccess((T) convert(json, type));
                } else if (code >= 400 && code < 500) {
                    entityCallback.onFailure("客户端错误");
                } else if (code > 500 && code < 600) {
                    entityCallback.onFailure("服务器错误");
                } else {
                    entityCallback.onFailure("未知错误");
                }
            }
        });
    }
}
