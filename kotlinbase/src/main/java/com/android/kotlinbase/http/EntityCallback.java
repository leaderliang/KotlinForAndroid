package com.android.kotlinbase.http;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/11/07 15:17
 */
public interface EntityCallback<T> {
    void onSuccess(@NonNull T entity);

    void onFailure(@Nullable String message);
}
