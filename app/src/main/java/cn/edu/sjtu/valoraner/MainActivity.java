package cn.edu.sjtu.valoraner;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {
    private Button m_btn1;
    private Button m_btn2;
    private String name;
    private String code;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        dbHelper = new MyDatabaseHelper(this, "myUsr.db", 2);
        /*SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(
                this.getFilesDir().toString()
                        + "/usrs", null);
        String sql="create table my_usrs (name varchar(255) primary key," + "code varchar(255)," + "phone varchar(255)," +
                "year varchar(255)," + "month varchar(255)," + "day varchar(255)," + "nation varchar(255))";
        db.execSQL(sql);*/
        m_btn1=(Button)findViewById(R.id.bn6);
        m_btn2=(Button) findViewById(R.id.bn7);
        m_btn1.setOnClickListener(login);
        m_btn2.setOnClickListener(register);
    }

    private Button.OnClickListener login = new OnClickListener() {
        @Override
        public void onClick(View arg0) {
            name=((EditText)findViewById(R.id.name_login)).getText().toString();
            code=((EditText)findViewById(R.id.code_login)).getText().toString();
            SQLiteDatabase db=dbHelper.getReadableDatabase();
            Cursor cursor=db.rawQuery("select * from usrs where name = ? and code = ?",
                    new String[] { name , code});
            if(cursor.getCount()==0)
                Toast.makeText(MainActivity.this, "用户名和密码不匹配"
                        , Toast.LENGTH_LONG).show();
            else {
                Toast.makeText(MainActivity.this, "welcome "+name
                        , Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                cursor.moveToFirst();
                Usrs.name=cursor.getString(cursor.getColumnIndex("name"));
                int nameColumnIndex1 = cursor.getColumnIndex("code");
                Usrs.code=cursor.getString(nameColumnIndex1);
                int nameColumnIndex2 = cursor.getColumnIndex("nation");
                Usrs.nation=cursor.getString(nameColumnIndex2);
                int nameColumnIndex3 = cursor.getColumnIndex("phone");
                Usrs.phone=cursor.getString(nameColumnIndex3);
                int nameColumnIndex4 = cursor.getColumnIndex("year");
                Usrs.year=cursor.getString(nameColumnIndex4);
                int nameColumnIndex5 = cursor.getColumnIndex("month");
                Usrs.month=cursor.getString(nameColumnIndex5);
                int nameColumnIndex6 = cursor.getColumnIndex("day");
                Usrs.day=cursor.getString(nameColumnIndex6);
            }
            cursor.close();
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
