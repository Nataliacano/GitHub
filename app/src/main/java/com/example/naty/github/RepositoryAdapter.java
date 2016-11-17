package com.example.naty.github;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Naty on 17/11/2016.
 */
public class RepositoryAdapter extends BaseAdapter {
    private Context context;
    private List<Repository> repositories;

    public RepositoryAdapter(Context context, List<Repository> repositories){
        this.context = context;
        this.repositories = repositories;

    }
    @Override
    public int getCount() {

        return repositories.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
