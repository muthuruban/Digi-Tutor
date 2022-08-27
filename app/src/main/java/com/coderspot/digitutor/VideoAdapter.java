package com.coderspot.digitutor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private Context context;
    private OnTrackClickListener onTrackClickListener;

    public VideoAdapter(Context context, OnTrackClickListener onTrackClickListener) {
        this.context = context;
        this.onTrackClickListener = onTrackClickListener;
    }

    public VideoAdapter(MainActivity.GetAudioAsyncTest getAudioAsyncTest, MainActivity mainActivity) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_container, parent, false);
        return new ViewHolder(view, onTrackClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Field[] fields = R.raw.class.getFields();
        for (int count = 0; count < fields.length; count++) {
            String name = fields[count].getName();
//            int resourceID = fields[count].getInt(fields[count]);
            Uri videoUri = Uri.parse("android.resource://" + this + "/" + R.raw.formula_proof);
            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            retriever.setDataSource(context.getApplicationContext(), videoUri);
            Bitmap bitmap = retriever.getFrameAtTime(100000, MediaMetadataRetriever.OPTION_PREVIOUS_SYNC);
            Drawable drawable = new BitmapDrawable(context.getResources(), bitmap);
//            Glide.with(this).load("android.resource://" + context.getPackageName() + "/raw/demo").diskCacheStrategy(NONE).into(imageView);
            holder.videoName.setText(name);
            holder.channelName.setText("Sample Channel");
            holder.no_of_views.setText("0-Views");
            holder.uploadedDate.setText("1 seconds ago");
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView videoName;
        private TextView channelName;
        private TextView no_of_views;
        private TextView duration;
        private TextView uploadedDate;
        private RelativeLayout rootLayout;
        private ImageView videoThumb;
        OnTrackClickListener onTrackClickListener;

        public ViewHolder(@NonNull View itemView, OnTrackClickListener onTrackClickListener) {
            super(itemView);
            this.onTrackClickListener = onTrackClickListener;
            rootLayout = itemView.findViewById(R.id.video_thumb_rootlayout);
            videoName = itemView.findViewById(R.id.video_details_text);
            channelName = itemView.findViewById(R.id.channel_name);
            no_of_views = itemView.findViewById(R.id.no_views);
            duration = itemView.findViewById(R.id.video_duration);
            uploadedDate = itemView.findViewById(R.id.uploaded_time);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onTrackClickListener.onTrackClick(getAdapterPosition());
        }
    }

    public interface OnTrackClickListener {
        void onTrackClick(int position);
    }
}
