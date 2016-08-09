package main.navdrawer.codeeden.layouts;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import main.navdrawer.codeeden.R;
import main.navdrawer.codeeden.adapter.MenuAdapter;
import main.navdrawer.codeeden.types.MenuItem;

/**
 * Created by Hrishikesh on 5/29/2016.
 */
public class NavMenu extends LinearLayout {

    private Context context;
    private Activity activity;
    private LinearLayout nav_header_layout,navMenulayout,navBaselayout;
    private ListView menuItemList;
    private ImageView nav_logo;
    private TextView nav_title,nav_sub_title;


    public NavMenu(Context context) {
        super(context);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.nav_layout, this);
        this.navMenulayout = (LinearLayout) this.findViewById(R.id.navMenulayout);
        this.navBaselayout = (LinearLayout) this.findViewById(R.id.navBaselayout);
        this.nav_header_layout = (LinearLayout) this.findViewById(R.id.nav_header_layout);
        this.menuItemList = (ListView) this.findViewById(R.id.menuItem);
        this.nav_logo = (ImageView) this.findViewById(R.id.nav_logo);
        this.nav_title = (TextView) this.findViewById(R.id.nav_title);
        this.nav_sub_title = (TextView) this.findViewById(R.id.nav_sub_title);
    }

    public NavMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.nav_layout, this);
        this.navMenulayout = (LinearLayout) this.findViewById(R.id.navMenulayout);
        this.navBaselayout = (LinearLayout) this.findViewById(R.id.navBaselayout);
        this.menuItemList = (ListView) this.findViewById(R.id.menuItem);
        this.nav_header_layout = (LinearLayout) this.findViewById(R.id.nav_header_layout);
        this.nav_logo = (ImageView) this.findViewById(R.id.nav_logo);
        this.nav_title = (TextView) this.findViewById(R.id.nav_title);
        this.nav_sub_title = (TextView) this.findViewById(R.id.nav_sub_title);
    }

    public NavMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.nav_layout, this);
        this.navMenulayout = (LinearLayout) this.findViewById(R.id.navMenulayout);
        this.navBaselayout = (LinearLayout) this.findViewById(R.id.navBaselayout);
        this.menuItemList = (ListView) this.findViewById(R.id.menuItem);
        this.nav_header_layout = (LinearLayout) this.findViewById(R.id.nav_header_layout);
        this.nav_logo = (ImageView) this.findViewById(R.id.nav_logo);
        this.nav_title = (TextView) this.findViewById(R.id.nav_title);
        this.nav_sub_title = (TextView) this.findViewById(R.id.nav_sub_title);
    }

    public void initView(Activity activity){
        this.activity = activity;
    }

    public LinearLayout getNav_header_layout() {
        return nav_header_layout;
    }

    public void setNav_header_layout(View nav_header_layout) {
        this.nav_logo.setVisibility(View.GONE);
        this.nav_title.setVisibility(View.GONE);
        this.nav_sub_title.setVisibility(View.GONE);
        this.nav_header_layout.addView(nav_header_layout);
    }

    public void setNavBackground(int drawable){
        if(activity != null)
            this.nav_header_layout.setBackground(this.activity.getResources().getDrawable(drawable));
    }

    public void setNavBackground(String color){
        this.nav_header_layout.setBackgroundColor(Color.parseColor(color));
    }


    public ListView getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        System.out.println("NavBar  ::: menuItemList===>"+menuItemList.size());
        this.menuItemList.setAdapter(new MenuAdapter(activity,context,menuItemList));
    }

    public ImageView getNav_logo() {
        return nav_logo;
    }

    public void setNav_logo(@DrawableRes int nav_logo) {
        this.nav_logo.setImageResource(nav_logo);
    }

    public TextView getNav_title() {
        return nav_title;
    }

    public void setNav_title(String nav_title) {
        this.nav_title.setText(nav_title);
    }

    public TextView getNav_sub_title() {
        return nav_sub_title;
    }

    public void setNav_sub_title(String nav_sub_title) {
        this.nav_sub_title.setText(nav_sub_title);
    }

    public void hide(){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        final int width = displaymetrics.widthPixels;
        final ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofObject(navBaselayout,
                "backgroundColor",
                new ArgbEvaluator(),
                0x90000000,
                0x00000000);
        backgroundColorAnimator.setDuration(300);
        backgroundColorAnimator.start();

        navMenulayout.animate().setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                navBaselayout.setClickable(false);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                navMenulayout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).translationXBy(-(width/10)*8).setDuration(300);
    }


    public void show(){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        final int width = displaymetrics.widthPixels;
        final ObjectAnimator backgroundColorAnimator = ObjectAnimator.ofObject(navBaselayout,
                "backgroundColor",
                new ArgbEvaluator(),
                0x00000000,
                0x90000000);
        backgroundColorAnimator.setDuration(300);
        backgroundColorAnimator.start();
        navMenulayout.setX(-((width/10)*8));
        navMenulayout.animate().setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

                navMenulayout.setVisibility(View.VISIBLE);
                navBaselayout.setClickable(true);
                navBaselayout.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hide();
                    }
                });
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).translationXBy((width/10)*8).setDuration(300);
    }
}
