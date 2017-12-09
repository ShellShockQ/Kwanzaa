package com.digitalflow.Kwanzaa.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.digitalflow.Kwanzaa.DataAccess;
import com.digitalflow.Kwanzaa.NavigationDrawerItem;
import com.digitalflow.Kwanzaa360.R;

import java.util.List;

/**
 * Created by Detrick on 12/9/2017.
 */

public class NavigationDrawerAdaptor extends RecyclerView.Adapter<NavigationDrawerAdaptor.MyViewHolder> {
    private List<NavigationDrawerItem> menuItems = DataAccess.getMenuItems();
    private LayoutInflater mInflater;
    private Context mContext;

    public NavigationDrawerAdaptor(Context context, List<NavigationDrawerItem> data) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.menuItems = data;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.nav_drawer_list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        NavigationDrawerItem currentItem = menuItems.get(position);
        holder.imgIcon.setImageResource(currentItem.imgId);
        holder.title.setText(currentItem.title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, holder.title.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return menuItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imgIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.menuItemTitle);
            imgIcon = itemView.findViewById(R.id.imgIcon);

        }
    }
}
