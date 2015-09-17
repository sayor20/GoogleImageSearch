package com.sayor.org.googleimagesearcher.adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sayor.org.googleimagesearcher.R;
import com.sayor.org.googleimagesearcher.models.ImageResult;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Sayor on 9/12/15.
 */
public class ImageResultsAdapter extends ArrayAdapter<ImageResult> {

    public ImageResultsAdapter(Context context, List<ImageResult> images) {
        super(context, R.layout.item_layout_results, images);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageResult ImageInfo = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout_results, parent, false);
        ImageView ivThumbURL = (ImageView) convertView.findViewById(R.id.ivThumbURL);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);

        tvTitle.setText(Html.fromHtml(ImageInfo.title));
        Picasso.with(getContext()).load(ImageInfo.thumbURL).into(ivThumbURL);

        return convertView;
    }
}
