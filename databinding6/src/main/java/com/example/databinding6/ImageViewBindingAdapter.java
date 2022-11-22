package com.example.databinding6;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

/**
 * @author AlexisYin
 */
public class ImageViewBindingAdapter {


    @BindingAdapter(value = {"image", "placeholder"}, requireAll = false)
    public static void setImage(ImageView imageView, String url, int resId) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.get().load(url).into(imageView);
        } else {
            imageView.setImageResource(resId);
        }
    }
}
