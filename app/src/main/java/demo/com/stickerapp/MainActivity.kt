package demo.com.stickerapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import demo.com.stickerapp.data.model.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var user = User()
        user.id = 10;
        println(user.id)
    }
}
