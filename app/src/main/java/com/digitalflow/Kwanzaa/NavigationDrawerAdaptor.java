package com.digitalflow.Kwanzaa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Detrick on 12/9/2017.
 */

public class NavigationDrawerAdaptor extends RecyclerView.Adapter<NavigationDrawerAdaptor.MyViewHolder> {
    private List<NavigationDrawerItem> menuItems;
    private LayoutInflater mInflater;
    private Context mContext;

    public NavigationDrawerAdaptor(Context context, List<NavigationDrawerItem> data) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.menuItems = data;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
