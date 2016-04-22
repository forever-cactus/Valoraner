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

public class PlayerActivity extends Activity {
    ImageButton imagebutton13;
    ImageButton imagebutton18;
    ImageButton imagebutton8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
        imagebutton13 = (ImageButton) this.findViewById(R.id.ImageView13);
        imagebutton13.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PlayerActivity.this, Player1Activity.class);
                startActivity(intent);
            }
        });
        imagebutton18 = (ImageButton) this.findViewById(R.id.ImageView23);
        imagebutton18.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PlayerActivity.this, Player2Activity.class);
                startActivity(intent);
            }
        });
        imagebutton8 = (ImageButton) this.findViewById(R.id.ImageView8);
        imagebutton8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PlayerActivity.this, Player3Activity.class);
                startActivity(intent);
            }
        });
    }
}
