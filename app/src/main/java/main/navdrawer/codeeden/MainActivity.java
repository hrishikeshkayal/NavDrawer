package main.navdrawer.codeeden;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import main.navdrawer.codeeden.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gonext(View v){
        Intent in = new Intent(this,MenuActivity.class);
        startActivity(in);
    }
}
