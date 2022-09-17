package com.example.mybut.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.mybut.R;
import com.example.mybut.model.Photo;

import java.util.List;

public class PhotoAdapter  extends PagerAdapter {
    private Context mcontext;
    private List<Photo> mlistPhoto;

    public PhotoAdapter(Context mcontext, List<Photo> mlistPhoto) {
        this.mcontext = mcontext;
        this.mlistPhoto = mlistPhoto;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.item_home,container, false);
        ImageView imageView= view.findViewById(R.id.imghome);

        Photo photo = mlistPhoto.get(position);
        if (photo != null){
            Glide.with(mcontext).load(photo.getResoureId()).into(imageView);
        }
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if (mlistPhoto !=null){
            return mlistPhoto.size();
        }

        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
