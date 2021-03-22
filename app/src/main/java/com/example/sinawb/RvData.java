package com.example.sinawb;

public class RvData {
    private String data;
    private String num;
    private int imageId;

    public RvData(String data,String num,int imageId){
        this.data=data;
        this.num=num;
        this.imageId=imageId;
    }

    public String getData(){
        return data;
    }

    public String getNum(){
        return num;
    }

    public int getImageId(){return imageId;}
}
