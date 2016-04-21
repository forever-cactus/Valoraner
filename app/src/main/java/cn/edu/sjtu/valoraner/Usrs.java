package cn.edu.sjtu.valoraner;

import android.app.Application;

/**
 * Created by shqgo on 2016/4/17.
 */
public class Usrs extends Application{
    public String getName()
    {
        return name;
    }
    public void setName(String a)
    {
        name=a;
    }
    public String getB_y()
    {
        return b_y;
    }
    public void setB_y(String b)
    {
        b_y=b;
    }
    public String getCode()
    {
        return code;
    }
    public String getNation()
    {
        return nation;
    }
    public void setCode(String c)
    {
        code=c;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setNation(String d)
    {
        nation=d;
    }
    public void setPhone(String e)
    {
        phone=e;
    }

    private String name;
    private String b_y;
    private String b_m;
    private String b_d;
    private String code;
    private String nation;
    private String phone;

    public String getB_m() {
        return b_m;
    }

    public void setB_m(String b_m) {
        this.b_m = b_m;
    }

    public String getB_d() {
        return b_d;
    }

    public void setB_d(String b_d) {
        this.b_d = b_d;
    }
}
