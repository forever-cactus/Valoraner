package cn.edu.sjtu.valoraner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by shqgo on 2016/4/17.
 */
public class RegisterActivity extends Activity{
    private Button m_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        m_btn = (Button)findViewById(R.id.bn8);
        m_btn.setOnClickListener(main);
    }

    private Button.OnClickListener main = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent();
            intent.setClass(RegisterActivity.this,MainActivity.class);
            startActivity(intent);
        }
    };

}
