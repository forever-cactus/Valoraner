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
    ImageButton imagebutton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero);
        imagebutton = (ImageButton) this.findViewById(R.id.ImageView1);
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HeroActivity.this, HeroIntroduce1.class);
                startActivity(intent);

            }
        });
    }
}