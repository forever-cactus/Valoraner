package cn.edu.sjtu.valoraner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

/**
 * Created by shqgo on 2016/4/17.
 */
public class DataActivity extends Activity{
    private Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);
        btn=(Button)findViewById(R.id.btn1);
    }

    String data="volalan";
}
