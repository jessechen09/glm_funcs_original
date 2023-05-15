
package com.example.glm_funcs_original;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;

import java.net.URL;

public class Function21384 extends RequestManager {
    public Function21384(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode treeNode, @NonNull Context context) {
        super(glide, lifecycle, treeNode, context);
    }

    @Override
    public RequestBuilder<Drawable> load(URL url) {
        return (Function21386) super.load(url); // JC changed GlideRequest to Function21386
    }
}