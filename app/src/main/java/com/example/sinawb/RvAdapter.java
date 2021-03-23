package com.example.sinawb;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder> {
    private List<RvData> mList=new ArrayList<>();




    class RvViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public TextView textView2;
        public ImageView imageView;

        public RvViewHolder(View itemView){
            super(itemView);
            textView=itemView.findViewById(R.id.tv_rv);
            textView2=itemView.findViewById(R.id.tv_num);
            imageView=itemView.findViewById(R.id.iv);
        }
    }
    @NonNull
    @Override
    public RvAdapter.RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RvViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.RvViewHolder holder, int position) {
        RvData rvData=mList.get(position);
        holder.textView.setText(rvData.getData());
        holder.textView2.setText(rvData.getNum());
        switch (mList.get(position).getImageId()){
            case 0:holder.imageView.setImageResource(R.drawable.one);
                   break;
            case 1:holder.imageView.setImageResource(R.drawable.two);
                break;
            case 2:holder.imageView.setImageResource(R.drawable.three);
                break;
            case 3:holder.imageView.setImageResource(R.drawable.four);
                break;
            case 4:holder.imageView.setImageResource(R.drawable.five);
                break;
            case 5:holder.imageView.setImageResource(R.drawable.six);
                break;
            case 6:holder.imageView.setImageResource(R.drawable.seven);
                break;
            case 7:holder.imageView.setImageResource(R.drawable.eight);
                break;
            case 8:holder.imageView.setImageResource(R.drawable.nine);
                break;
            case 9: case 10: case 11: case 12: case 13: case 14: case 15:
            case 16: case 17: case 18: case 19: case 20: case 21: case 22:
            case 23: case 24: case 25: case 26: case 27: case 28: case 29:
            case 30: case 31: case 32: case 33: case 34: case 35: case 36:
            case 37: case 38: case 39: case 40: case 41: case 42: case 43:
            case 44: case 45: case 46: case 47: case 48:
                case 49: holder.imageView.setImageResource(R.drawable.hot);
                         break;
        }
        Log.i("tag",mList.get(2).getData());
    }

    public void setData(List<RvData> list){
        this.mList=list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
