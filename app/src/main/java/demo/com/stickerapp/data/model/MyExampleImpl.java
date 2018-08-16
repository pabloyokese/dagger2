package demo.com.stickerapp.data.model;

import java.util.Date;

public class MyExampleImpl implements MyExample {
    private long mDate;

    MyExampleImpl() {
        mDate = new Date().getTime();
    }

    public long getDate() {
        return mDate;
    }
}
