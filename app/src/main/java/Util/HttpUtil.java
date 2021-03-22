package Util;

import android.accounts.NetworkErrorException;
import android.os.Message;
import android.util.Log;

import com.example.sinawb.MainActivity;
import com.example.sinawb.RvData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HttpUtil {

    public static void sendHttpGetRequest(String address){


        //开启子线程执行网络请求
        new Thread(
                ()->{
                    HttpURLConnection connection=null;
                    try{
                        URL url=new URL(address);
                        connection=(HttpURLConnection)url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(8000);
                        connection.setReadTimeout(8000);
                        connection.setDoInput(true);
                        connection.setDoOutput(true);//提交参数
                        connection.connect();//连接
                        DataOutputStream dos=new DataOutputStream(connection.getOutputStream());
                        String param="My param";
                        dos.writeBytes(param);
                        int responseCode=connection.getResponseCode();
                        if(responseCode==200){
                            InputStream in =connection.getInputStream();//从接口处获取输入流
                            String responseData =StreamToString(in);//服务器返回数据
                            Json json=new Json(responseData);
                        }
                        else {
                            throw new NetworkErrorException("response status is"+responseCode);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if(connection!=null){
                            connection.disconnect();
                        }
                    }
                }
        ).start();
    }


    private static String StreamToString(InputStream in){
        StringBuilder sb=new StringBuilder();//构架字符串
        String oneLine;//流转换成字符串
        BufferedReader reader=new BufferedReader(new InputStreamReader(in));//读取二进制流
        try{
            while((oneLine=reader.readLine())!=null){//readLine方法将读取一行数据，并转化成String类型，当读取的数据为null，则代表当前数据已读取完毕
                sb.append(oneLine).append('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();//关闭InputStream
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}


