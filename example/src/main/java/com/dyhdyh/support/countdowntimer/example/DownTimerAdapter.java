package com.dyhdyh.support.countdowntimer.example;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dyhdyh.support.countdowntimer.CountDownTimerSupport;
import com.dyhdyh.support.countdowntimer.OnCountDownTimerListener;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * author  dengyuhan
 * created 2017/5/25 21:21
 */
public class DownTimerAdapter extends RecyclerView.Adapter<DownTimerAdapter.Holder> {
    private List<DownTimerEntity> data;
    private SimpleDateFormat format = new SimpleDateFormat("mm:ss");

    public DownTimerAdapter(List<DownTimerEntity> data) {
        this.data = data;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timer, parent, false));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        final DownTimerEntity item = data.get(position);
        if (item.isFinish()){
            holder.tv_timer.setText("已停止");
        }else{
            holder.tv_timer.setText(format.format(item.getMillisUntilFinished()));
        }
        holder.timer.setCountDownInterval(item.getCountDownInterval());
        holder.timer.setMillisInFuture(item.getMillisInFuture());
        holder.timer.setOnCountDownTimerListener(new OnCountDownTimerListener() {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("-----------",""+millisUntilFinished);
                item.setMillisUntilFinished(millisUntilFinished);
                holder.tv_timer.setText(format.format(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                item.setFinish(true);
            }
        });
        holder.timer.start();
    }


    static class Holder extends RecyclerView.ViewHolder {
        TextView tv_timer;
        SeekBar sb_progress;
        CountDownTimerSupport timer;

        public Holder(View itemView) {
            super(itemView);
            timer = new CountDownTimerSupport();
            tv_timer = (TextView) itemView.findViewById(R.id.tv_timer);
            sb_progress = (SeekBar) itemView.findViewById(R.id.sb_progress);
        }
    }
}
