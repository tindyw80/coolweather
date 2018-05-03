package com.coolweather.android.util;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;
//import com.coolweather.android.gson.Weather;
import com.google.gson.Gson;

/**
 * Created by wjting on 2018/5/3.
 */

public class Utillity {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response)
    {
            if(!TextUtils.isEmpty(response)){
                try{
                    JSONArray allProvinces = new JSONArray(response);
                    for(int i=0;i<allProvinces.length();i++){
                        JSONObject provinceObject = allProvinces.getJSONObject(i);
                        Province province=new Province();
                        province.setProvinceName(provinceObject.getString("name"));
                        province.setProvinceCode(provinceObject.getInt("id"));
                        province.save();
                    }
                    return true;
                }catch (JSONException e) {
                    e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
}
