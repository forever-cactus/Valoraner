package cn.edu.sjtu.valoraner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/**
 * Created by shqgo on 2016/4/17.
 */


public class HeroActivity extends Activity {
    ImageButton imagebutton1,imagebutton2,imageButton3,imageButton4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero);
        imagebutton1 = (ImageButton) this.findViewById(R.id.ImageView1);
        imagebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HeroActivity.this, HeroIntroduce1.class);
                startActivity(intent);

            }
        });
        imagebutton2 = (ImageButton) this.findViewById(R.id.ImageView2);
        imagebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HeroActivity.this, HeroIntroduce2.class);
                startActivity(intent);

            }
        });
        imageButton3 = (ImageButton) this.findViewById(R.id.ImageView3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HeroActivity.this, HeroIntroduce3.class);
                startActivity(intent);

            }
        });
        imageButton4 = (ImageButton) this.findViewById(R.id.ImageView4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HeroActivity.this, HeroIntroduce4.class);
                startActivity(intent);

            }
        });
    }
}

