package demo.com.stickerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Date;

import javax.inject.Inject;

import demo.com.stickerapp.data.model.MyExample;

public class MainActivity extends AppCompatActivity {

    @Inject
    MyExample mMyExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView dateTextView = findViewById(R.id.textView);
        ((MyApplication) getApplication())
                .getMyComponent()
                .inject(MainActivity.this);
        dateTextView.setText((new Date(mMyExample.getDate())).toString());
    }

}