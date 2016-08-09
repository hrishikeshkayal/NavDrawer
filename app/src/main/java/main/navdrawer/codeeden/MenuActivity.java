package main.navdrawer.codeeden;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import main.navdrawer.codeeden.R;
import main.navdrawer.codeeden.layouts.NavMenu;
import main.navdrawer.codeeden.layouts.Toolbar;
import main.navdrawer.codeeden.types.MenuItem;

public class MenuActivity extends AppCompatActivity {

    private List<MenuItem> menuList = new ArrayList<MenuItem>();
    private NavMenu nav;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.initView(this);

        nav = (NavMenu) findViewById(R.id.navMenuView);
        nav.initView(this);
        nav.setNav_logo(R.drawable.logotoolbar);
        nav.setNav_title("Rajnishsasmal");
        nav.setNav_sub_title("Event Ends: 14:30PM");
        nav.setNavBackground("#1C86EE");

        menuList.add(new MenuItem("Event", R.drawable.ic_menu_camera, "", false,false));
        menuList.add(new MenuItem("Scan Ticket", R.drawable.ic_menu_gallery, "", false,false));
        menuList.add(new MenuItem("Check In Status", R.drawable.ic_menu_send, "", false,false));
        menuList.add(new MenuItem("Booking Report",R.drawable.ic_menu_slideshow,"",false,false));
        menuList.add(new MenuItem("Settings",0,"",false,true));
        menuList.add(new MenuItem("Logout",R.drawable.ic_menu_manage,"",false,false));

        nav.setMenuItemList(menuList);
        nav.getMenuItemList().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fragmentLoader(position);
            }
        });



        toolbar.setBackground(R.drawable.side_nav_bar);
        toolbar.setDrawable_left_icon(R.drawable.icon_menu);
        toolbar.getDrawable_left_icon().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nav.show();
            }
        });
    }

    public void fragmentLoader(int val){
        Toast.makeText(getApplicationContext(),menuList.get(val).getItemName(),Toast.LENGTH_SHORT).show();
        nav.hide();
    }
}
