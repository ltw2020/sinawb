package Util;

public interface   HttpCallbackListener {
    //访问完成
    void onResponse(String response);
    //访问出错
    void onError(Exception e);
}
