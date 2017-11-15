package com.example.pancho.contactidean.view.browselocal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.beardedhen.androidbootstrap.BootstrapWell;
import com.example.pancho.contactidean.entities.User;
import com.squareup.picasso.Picasso;
import com.example.pancho.contactidean.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Francisco on 10/18/2017.
 */

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.ViewHolder>{
    private static final String TAG = "FirstAdapter";
    List<User> userList;
    Context context;

    public FirstAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User item = userList.get(position);

        String url_img = item.getImg_url();
        if(url_img != null)
            Picasso.with(context).load(url_img).into(holder.img);
        else
            Picasso.with(context).load(R.drawable.broken_image).into(holder.img);

        if (!item.getName().trim().equals(""))
            holder.tvName.setText(item.getName().trim());
        else
            holder.tvNameParent.setVisibility(holder.tvNameParent.getRootView().GONE);

        if (!item.getEmail().trim().equals(""))
            holder.tvEmail.setText(item.getEmail().trim());
        else
            holder.tvEmail.setVisibility(holder.tvEmail.getRootView().GONE);

        if (!item.getPhone().trim().equals(""))
            holder.tvPhone.setText(item.getPhone().trim());
        else
            holder.tvPhone.setVisibility(holder.tvPhone.getRootView().GONE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((UserListener) context).ItemClick(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Nullable
        @BindView(R.id.img)
        BootstrapCircleThumbnail img;

        @Nullable
        @BindView(R.id.tvName)
        TextView tvName;

        @Nullable
        @BindView(R.id.tvEmail)
        TextView tvEmail;

        @Nullable
        @BindView(R.id.tvPhone)
        TextView tvPhone;

        @Nullable
        @BindView(R.id.scroll)
        ScrollView scroll;

        @Nullable
        @BindView(R.id.scroll_parent)
        FrameLayout scroll_parent;

        @Nullable
        @BindView(R.id.tvNameParent)
        BootstrapWell tvNameParent;

        public ViewHolder(View ResultView) {
            super(ResultView);
            ButterKnife.bind(this, ResultView);
        }
    }

    public interface UserListener {
        void ItemClick(User item);
    }
}
