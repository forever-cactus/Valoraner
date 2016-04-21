package cn.edu.sjtu.valoraner;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Calendar;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;


/**
 * Created by shqgo on 2016/4/17.
 */
public class RegisterActivity extends Activity{
    private Button m_btn;
    private Spinner spYear;
    private Spinner spMonth;
    private Spinner spDay;
    private Spinner spi3;
    private ArrayList<String> dataYear = new ArrayList<String>();
    private ArrayList<String> dataMonth = new ArrayList<String>();
    private ArrayList<String> dataDay = new ArrayList<String>();
    private ArrayAdapter<String> adapterSpYear;
    private ArrayAdapter<String> adapterSpMonth;
    private ArrayAdapter<String> adapterSpDay;
    private Usrs usrs =new Usrs();
    private String name;
    private String code;
    private String phone;
    private String year;
    private String month;
    private String day;
    private String nation;
    MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        dbHelper = new MyDatabaseHelper(this, "myUsr.db", 2);
        m_btn = (Button)findViewById(R.id.bn8);
        m_btn.setOnClickListener(main);
        spYear = (Spinner) findViewById(R.id.sp_year);
        spMonth = (Spinner) findViewById(R.id.sp_month);
        spDay = (Spinner) findViewById(R.id.sp_day);
        spi3 =(Spinner)findViewById(R.id.spi3);

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
                day = dataDay.get(arg2).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        year = spYear.getSelectedItem().toString();
        month = spMonth.getSelectedItem().toString();
        nation=spi3.getSelectedItem().toString();
        //get values;
        /*spYear.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                year = dataYear.get(arg2).toString();
                arg0.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        spMonth.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                month = dataMonth.get(arg2).toString();
                arg0.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        spDay.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                year = dataDay.get(arg2).toString();
                arg0.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        spi3.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                nation = RegisterActivity.this.getResources().getStringArray(R.array.books)[arg2];
                arg0.setVisibility(View.VISIBLE);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });*/
    }

    private Button.OnClickListener main = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            EditText t1=(EditText)findViewById(R.id.name);
            EditText t2=(EditText)findViewById(R.id.code);
            EditText t3=(EditText)findViewById(R.id.phone);
            name=t1.getText().toString();
            code=t2.getText().toString();
            phone=t3.getText().toString();
            SQLiteDatabase db=dbHelper.getWritableDatabase();
            ContentValues values= new ContentValues();
            values.put("name",name);
            values.put("code",code);
            values.put("phone",phone);
            values.put("year",year);
            values.put("month",month);
            values.put("day",day);
            values.put("nation",nation);
            db.insert("usrs",null,values);
            values.clear();
            Toast.makeText(RegisterActivity.this, "注册成功！"
                    , Toast.LENGTH_LONG).show();
            Intent intent = new Intent();
            intent.setClass(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            //db.execSQL("insert into usrs values(?,?,?,?,?,?,?)",new String[]{name,code,phone,spYear.toString(),spMonth.toString(),spDay.toString(),spi3.toString()});
        }
    };

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        // 退出程序时关闭MyDatabaseHelper里的SQLiteDatabase
        if (dbHelper != null)
        {
            dbHelper.close();
        }
    }




    /*public void setall() {
        usrs.setName(name);
        usrs.setB_y(spYear.toString());
        usrs.setB_d(spDay.toString());
        usrs.setB_m(spMonth.toString());
        usrs.setCode(code);
        usrs.setNation(spi3.toString());
        usrs.setPhone(phone);
    }*/
}

