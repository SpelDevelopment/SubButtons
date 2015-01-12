package com.example.spel.subbuttons;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = (LinearLayout) findViewById(R.id.container);
        Button plus = (Button) findViewById(R.id.plus);
        plus.setOnClickListener(listener);
        Button minus = (Button) findViewById(R.id.minus);
        minus.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if(id == R.id.plus){
                final CustomButton button = new CustomButton(MainActivity.this);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int childCount = container.getChildCount();
                        for(int i = 0; i < childCount; i++){
                            ((CustomButton)container.getChildAt(i)).deactivate();
                            ((CustomButton)container.getChildAt(i)).showSubButton(false);
                        }
                        ((CustomButton)v.getParent()).activate();
                        ((CustomButton)v.getParent()).setSubListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "SubButton", Toast.LENGTH_LONG).show();
                            }
                        });
                        ((CustomButton)v.getParent()).showSubButton(true);

                    }
                });
                container.addView(button);
                Toast.makeText(MainActivity.this, "PLUS", Toast.LENGTH_LONG).show();
            }
            if(id == R.id.minus){
                int childCount = container.getChildCount();
                if(childCount > 0){
                    container.removeView(container.getChildAt(childCount - 1));
                }
            }
        }
    };

}


