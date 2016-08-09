package main.navdrawer.codeeden.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import main.navdrawer.codeeden.R;
import main.navdrawer.codeeden.types.MenuItem;

/**
 * Created by Hrishikesh on 5/29/2016.
 */
public class MenuAdapter extends BaseAdapter {
    private Activity activity;
    private Context context;
    private List<MenuItem> itemList = new ArrayList<MenuItem>();

    public MenuAdapter(Activity activity, Context context, List<MenuItem> itemList) {
        this.activity = activity;
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public MenuItem getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = ((Activity) activity).getLayoutInflater();

        if(getItem(position).isGroupcaption()){
            row = inflater.inflate(R.layout.nav_menu_group_title_layout, parent, false);
            row.setEnabled(false);
        }else{
            row = inflater.inflate(R.layout.nav_menu_layout, parent, false);
            ((ImageView)row.findViewById(R.id.itemMainIcon)).setImageResource(getItem(position).getItemMainIcon());
            if(getItem(position).isShowUpdates()){
                ((TextView)row.findViewById(R.id.itemFeed)).setText(getItem(position).getItemUpdates());
                ((TextView)row.findViewById(R.id.itemFeed)).setVisibility(View.VISIBLE);
            }

        }


        ((TextView)row.findViewById(R.id.itemTitle)).setText(getItem(position).getItemName());


        return row;
    }
}
