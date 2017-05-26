package com.dyhdyh.support.countdowntimer.example;

/**
 * author  dengyuhan
 * created 2017/5/25 21:22
 */
public class DownTimerEntity {
    private long countDownInterval;
    private long millisUntilFinished;
    private long millisInFuture;
    private boolean finish;

    public DownTimerEntity() {
    }

    public DownTimerEntity(long millisInFuture,long countDownInterval) {
        this.countDownInterval = countDownInterval;
        this.millisInFuture = millisInFuture;
    }

    public long getCountDownInterval() {
        return countDownInterval;
    }

    public void setCountDownInterval(long countDownInterval) {
        this.countDownInterval = countDownInterval;
    }

    public long getMillisInFuture() {
        return millisInFuture;
    }

    public void setMillisInFuture(long millisInFuture) {
        this.millisInFuture = millisInFuture;
    }

    public long getMillisUntilFinished() {
        return millisUntilFinished;
    }

    public void setMillisUntilFinished(long millisUntilFinished) {
        this.millisUntilFinished = millisUntilFinished;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
