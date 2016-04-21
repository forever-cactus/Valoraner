package cn.edu.sjtu.valoraner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shqgo on 2016/4/17.
 */
public class MatchActivity extends Activity{

    private ListView list = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match);
        list = (ListView) findViewById(R.id.MyListView2);

        //组织数据源
        List<HashMap<String, Object>> mylist = new ArrayList<HashMap<String,Object>>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("image", R.drawable.edg);
        map.put("title", "0    :   0");
        map.put("image2", R.drawable.lgd);
        map.put("name1", "EDG");
        map.put("name2","LGD");
        mylist.add(map);

        map = new HashMap<String, Object>();
        map.put("image", R.drawable.ig);
        map.put("title", "0   :   0");
        map.put("image2",R.drawable.omg);
        map.put("name1", "IG");
        map.put("name2","OMG");
        mylist.add(map);

        map = new HashMap<String, Object>();
        map.put("image", R.drawable.we);
        map.put("title", "0   :   0");
        map.put("image2",R.drawable.epa);
        map.put("name1", "WE");
        map.put("name2","EPA");
        mylist.add(map);

        map = new HashMap<String, Object>();
        map.put("image", R.drawable.hyg);
        map.put("title", "0   :   0");
        map.put("image2",R.drawable.snake);
        map.put("name1", "HYG");
        map.put("name2","SNAKE");
        mylist.add(map);

        map = new HashMap<String, Object>();
        map.put("image", R.drawable.m3);
        map.put("title", "0   :   0");
        map.put("image2",R.drawable.rng);
        map.put("name1", "M3");
        map.put("name2","RNG");
        mylist.add(map);

        map = new HashMap<String, Object>();
        map.put("image", R.drawable.qg);
        map.put("title", "0   :   0");
        map.put("image2",R.drawable.vg);
        map.put("name1", "QG");
        map.put("name2","VG");
        mylist.add(map);

        //配置适配器
        SimpleAdapter adapter = new SimpleAdapter(this,
                mylist,//数据源
                R.layout.my_listitem2,//显示布局
                new String[]{"image", "title","image2","name1","name2"}, //数据源的属性字段
                new int[]{R.id.image,R.id.title,R.id.image2,R.id.name1,R.id.name2}); //布局里的控件id
        //添加并且显示
        list.setAdapter(adapter);
    }
}
