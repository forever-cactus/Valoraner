package cn.edu.sjtu.valoraner;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button m_btn1;
    private Button m_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        m_btn1=(Button)findViewById(R.id.bn6);
        m_btn2=(Button)findViewById(R.id.bn7);
        m_btn1.setOnClickListener(login);
        m_btn2.setOnClickListener(register);
    }

    private Button.OnClickListener login = new OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    };

    private Button.OnClickListener register = new OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,RegisterActivity.class);
            startActivity(intent);
        }
    };


}
