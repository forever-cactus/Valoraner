package cn.edu.sjtu.valoraner;

import android.app.Activity;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;


/**
 * Created by shqgo on 2016/4/17.
 */
public class RegisterActivity extends Activity{
    private Button m_btn;
    private Spinner spYear;
    private Spinner spMonth;
    private Spinner spDay;
    private ArrayList<String> dataYear = new ArrayList<String>();
    private ArrayList<String> dataMonth = new ArrayList<String>();
    private ArrayList<String> dataDay = new ArrayList<String>();
    private ArrayAdapter<String> adapterSpYear;
    private ArrayAdapter<String> adapterSpMonth;
    private ArrayAdapter<String> adapterSpDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        m_btn = (Button)findViewById(R.id.bn8);
        m_btn.setOnClickListener(main);
        spYear = (Spinner) findViewById(R.id.sp_year);
        spMonth = (Spinner) findViewById(R.id.sp_month);
        spDay = (Spinner) findViewById(R.id.sp_day);

        // 年份设定为当年的前50年
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < 50; i++) {
            dataYear.add("" + (cal.get(Calendar.YEAR) - 49 + i));
        }
        adapterSpYear = new ArrayAdapter<String>(this, R.layout.item, dataYear);
        adapterSpYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spYear.setAdapter(adapterSpYear);
        spYear.setSelection(49);// 默认选中今年

        // 12个月
        for (int i = 1; i <= 12; i++) {
            dataMonth.add("" + (i < 10 ? "0" + i : i));
        }
        adapterSpMonth = new ArrayAdapter<String>(this, R.layout.item, dataMonth);
        adapterSpMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMonth.setAdapter(adapterSpMonth);

        adapterSpDay = new ArrayAdapter<String>(this, R.layout.item, dataDay);
        adapterSpDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDay.setAdapter(adapterSpDay);

        spMonth.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                dataDay.clear();
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, Integer.valueOf(spYear.getSelectedItem().toString()));
                cal.set(Calendar.MONTH, arg2);
                int dayofm = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                for (int i = 1; i <= dayofm; i++) {
                    dataDay.add("" + (i < 10 ? "0" + i : i));
                }
                adapterSpDay.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
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

