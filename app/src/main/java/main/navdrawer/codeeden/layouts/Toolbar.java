package main.navdrawer.codeeden.layouts;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import main.navdrawer.codeeden.R;

/**
 * Created by Hrishikesh on 5/28/2016.
 */
public class Toolbar extends LinearLayout{

    private Context context;
    private LinearLayout layout;
    private Activity activity;
    private ImageButton drawable_left_icon,drawable_right_icon;
    private RelativeLayout toolbarInnerCustom;
    private TextView toolbarTitle;
    private ImageView toolbarLogo;


    public Toolbar(Context context) {
        super(context);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.toolbar_layout, this);
        layout = (LinearLayout) this.findViewById(R.id.layoutContainer);
        drawable_left_icon = (ImageButton) this.findViewById(R.id.drawable_left_icon);
        drawable_right_icon = (ImageButton) this.findViewById(R.id.drawable_right_icon);
        toolbarLogo = (ImageView) this.findViewById(R.id.toolbarLogo);
        toolbarTitle = (TextView) this.findViewById(R.id.toolbarTitle);
        toolbarInnerCustom = (RelativeLayout) this.findViewById(R.id.toolbarInnerCustom);
    }

    public Toolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.toolbar_layout, this);
        this.context = context;
        layout = (LinearLayout) this.findViewById(R.id.layoutContainer);
        drawable_left_icon = (ImageButton) this.findViewById(R.id.drawable_left_icon);
        drawable_right_icon = (ImageButton) this.findViewById(R.id.drawable_right_icon);
        toolbarLogo = (ImageView) this.findViewById(R.id.toolbarLogo);
        toolbarTitle = (TextView) this.findViewById(R.id.toolbarTitle);
        toolbarInnerCustom = (RelativeLayout) this.findViewById(R.id.toolbarInnerCustom);
    }

    public Toolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.toolbar_layout, this);
        this.context = context;
        layout = (LinearLayout) this.findViewById(R.id.layoutContainer);
        drawable_left_icon = (ImageButton) this.findViewById(R.id.drawable_left_icon);
        drawable_right_icon = (ImageButton) this.findViewById(R.id.drawable_right_icon);
        toolbarLogo = (ImageView) this.findViewById(R.id.toolbarLogo);
        toolbarTitle = (TextView) this.findViewById(R.id.toolbarTitle);
        toolbarInnerCustom = (RelativeLayout) this.findViewById(R.id.toolbarInnerCustom);
    }

    public void initView(final Activity activity){
        this.activity = activity;
        toolbarTitle.setVisibility(View.VISIBLE);
        String label = "";
        String parent = "";
        try {
            if(activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).labelRes>0)
            label = getResources().getString(activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).labelRes);

            parent = activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).parentActivityName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
            if(!label.equalsIgnoreCase("")) {
                toolbarTitle.setText(label);
            }
            if(parent == null){
                drawable_left_icon.setImageResource(R.drawable.blank);
                drawable_right_icon.setImageResource(R.drawable.blank);

            }else{

                System.out.println("NavBar :::: parent"+parent);
                drawable_left_icon.setImageResource(R.drawable.icon_back);
                drawable_left_icon.setVisibility(View.VISIBLE);
                drawable_right_icon.setImageResource(R.drawable.blank);

                drawable_left_icon.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        activity.onBackPressed();
                    }
                });
            }


    }

    public void setBackground(int drawable){
        if(activity != null)
         this.layout.setBackground(activity.getResources().getDrawable(drawable));
    }


    public void setBackground(String color){
        this.layout.setBackgroundColor(Color.parseColor("#cccccc"));
    }

    public ImageButton getDrawable_left_icon() {
        return drawable_left_icon;
    }

    public void setDrawable_left_icon(@DrawableRes int drawable_left_icon) {
        this.drawable_left_icon.setImageResource(drawable_left_icon);

    }

    public ImageButton getDrawable_right_icon() {
        return drawable_right_icon;
    }

    public void setDrawable_right_icon(@DrawableRes int drawable_right_icon) {
        this.drawable_right_icon.setImageResource(drawable_right_icon);
    }

    public RelativeLayout getToolbarInnerCustom() {
        return toolbarInnerCustom;
    }

    public void setToolbarInnerCustom(View toolbarInnerCustom) {
        this.toolbarTitle.setVisibility(View.GONE);
        this.toolbarLogo.setVisibility(View.GONE);
        this.toolbarInnerCustom.setVisibility(View.VISIBLE);
        this.toolbarInnerCustom.addView(toolbarInnerCustom);
    }

    public String getToolbarTitle() {
        return toolbarTitle.getText().toString();
    }

    public void setToolbarTitle(String toolbarTitle) {
        this.toolbarTitle.setVisibility(View.VISIBLE);
        this.toolbarLogo.setVisibility(View.GONE);
        this.toolbarInnerCustom.setVisibility(View.GONE);
        this.toolbarTitle.setText(toolbarTitle);
    }

    /*
    public ImageView getToolbarLogo() {
        return toolbarLogo.getR;
    }*/

    public void setToolbarLogo(@DrawableRes int toolbarLogo) {
        this.toolbarTitle.setVisibility(View.GONE);
        this.toolbarLogo.setVisibility(View.VISIBLE);
        this.toolbarInnerCustom.setVisibility(View.GONE);
        this.toolbarLogo.setImageResource(toolbarLogo);
    }
}
