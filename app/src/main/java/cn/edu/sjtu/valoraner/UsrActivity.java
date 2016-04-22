package cn.edu.sjtu.valoraner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

/**
 * Created by shqgo on 2016/4/17.
 */
public class UsrActivity extends Activity {
    private ListView list = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usr);
        list = (ListView) findViewById(R.id.MyListView);
        TextView usr1=(TextView)findViewById(R.id.usr1);
        usr1.setText(Usrs.name);

        //组织数据源
        List<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("itemTitle","code:");
        map1.put("itemText", Usrs.code);
        mylist.add(map1);

        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("itemTitle", "birth:");
        map2.put("itemText", Usrs.year + "年" + Usrs.month + "月" + Usrs.day + "日");
        mylist.add(map2);

        HashMap<String, String> map3 = new HashMap<String, String>();
        map3.put("itemTitle", "phone");
        map3.put("itemText", Usrs.phone);
        mylist.add(map3);


        //配置适配器
        SimpleAdapter adapter = new SimpleAdapter(this,
                mylist,//数据源
                R.layout.my_listitem,//显示布局
                new String[]{"itemTitle", "itemText"}, //数据源的属性字段
                new int[]{R.id.itemTitle, R.id.itemText}); //布局里的控件id
        //添加并且显示
        list.setAdapter(adapter);
    }
}
