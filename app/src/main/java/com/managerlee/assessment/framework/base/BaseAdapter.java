package com.managerlee.assessment.framework.base;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anins on 2018/3/27.
 */

public abstract class BaseAdapter<H extends RecyclerView.ViewHolder, T> extends RecyclerView.Adapter<H> {

    public List<T> data;

    public BaseAdapter() {
        this.data = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public T getItem(int index) {
        return this.data.get(index);
    }

    public void addItem(T item) {
        if (data == null) {
            data = new ArrayList<>();
        }
        data.add(item);
        notifyDataSetChanged();
    }

    public void clearData() {
        if (data != null && data.size() > 0) {
            data.clear();
            notifyDataSetChanged();
        }
    }
}
