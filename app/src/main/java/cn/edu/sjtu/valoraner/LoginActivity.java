package cn.edu.sjtu.valoraner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by shqgo on 2016/4/16.
 */
public class LoginActivity extends Activity{
    private Button mbtn1;
    private Button mbtn2;
    private Button mbtn3;
    private Button mbtn4;
    private Button mbtn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn1=(Button)findViewById(R.id.bn1);
        mbtn2=(Button)findViewById(R.id.bn2);
        mbtn3=(Button)findViewById(R.id.bn3);
        mbtn4=(Button)findViewById(R.id.bn4);
        mbtn5=(Button)findViewById(R.id.bn5);
        mbtn1.setOnClickListener(usr);
        mbtn2.setOnClickListener(match);
        mbtn3.setOnClickListener(data);
        mbtn4.setOnClickListener(player);
        mbtn5.setOnClickListener(hero);
    }

    private Button.OnClickListener usr = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this,UsrActivity.class);
            startActivity(intent);
        }
    };

    private Button.OnClickListener match = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this,MatchActivity.class);
            startActivity(intent);
        }
    };

    private Button.OnClickListener data = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this,DataActivity.class);
            startActivity(intent);
        }
    };

    private Button.OnClickListener player = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this,PlayerActivity.class);
            startActivity(intent);
        }
    };

    private Button.OnClickListener hero = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this,HeroActivity.class);
            startActivity(intent);
        }
    };
}
