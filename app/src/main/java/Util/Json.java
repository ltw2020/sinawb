package Util;

import android.os.Message;
import android.util.Log;

import com.example.sinawb.MainActivity;
import com.example.sinawb.RvData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Json {

    public Json(String responseData) {

        try {
            JSONObject jsonObject = new JSONObject(responseData);
            JSONArray jsonArrayDatas = jsonObject.getJSONArray("data");
            ArrayList<RvData> list_rvData = new ArrayList<>();
            for (int i = 0; i < jsonArrayDatas.length(); i++) {
                JSONObject jsonObjectData = jsonArrayDatas.getJSONObject(i);
                String word = jsonObjectData.getString("hot_word");
                String num = jsonObjectData.getString(("hot_word_num"));
                Log.i("ltw", word);

                RvData rvData = new RvData(word, num,i);
                list_rvData.add(rvData);

                Message message=new Message();
                message.obj=list_rvData;
                MainActivity.mHandler.sendMessage(message);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}