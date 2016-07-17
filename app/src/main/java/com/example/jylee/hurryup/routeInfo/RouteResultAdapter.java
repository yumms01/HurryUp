package com.example.jylee.hurryup.routeInfo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jylee on 2016-07-13.
 */
public class RouteResultAdapter extends BaseAdapter implements RouteResultView.OnImageClickListener{
    List<RouteData> items = new ArrayList<RouteData>();

    public void add (RouteData d) {
        items.add(d);
        notifyDataSetChanged();
    }
    public void addAll(List<RouteData> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RouteResultView view;

        if(convertView == null) {
            view = new RouteResultView(parent.getContext());
            view.setOnImageClickListener(this);
        } else {
            view = (RouteResultView)convertView;
        }

        view.setData(items.get(position));
        return view;
    }

    public interface OnAdapterItemClickListener {
        public void onAdapterItemClickListener(RouteResultAdapter adapter, RouteResultView view, RouteData item, int position);
    }

    OnAdapterItemClickListener mAdapterListener;

    public void setOnAdapterItemClickListener(OnAdapterItemClickListener listener) {
        mAdapterListener = listener;
    }

    @Override
    public void onImageClick(RouteResultView view, RouteData data) {
        if (mAdapterListener != null) {
            int index = items.indexOf(data);
            mAdapterListener.onAdapterItemClickListener(this, view, data, index);
        }
    }
}
