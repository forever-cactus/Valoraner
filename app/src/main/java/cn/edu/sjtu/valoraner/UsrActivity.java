package cn.edu.sjtu.valoraner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * Created by shqgo on 2016/4/17.
 */
public class UsrActivity extends Activity {
    private ListView list = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usr);
        list = (ListView) findViewById(R.id.MyListView);

        //组织数据源
        List<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("itemTitle", "用户名");
        map.put("itemText", "unkown");
        mylist.add(map);


        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("itemTitle", "年龄");
        map1.put("itemText", "unkown");
        mylist.add(map1);

        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("itemTitle", "生日");
        map2.put("itemText", "unkown");
        mylist.add(map2);

        HashMap<String, String> map3 = new HashMap<String, String>();
        map3.put("itemTitle", "手机");
        map3.put("itemText", "unkown");
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
