package com.example.basicroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.basicroom.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        mainViewModel.saveUser(User(
            "uid0001",
            "uname0001",
            1.72,
            72.2,
            "u0001@email.com",
            "passworduser0001"
        ))
         */

        mainViewModel.getUsers()
        mainViewModel.savedUsers.observe(this) { usersList ->
            if (!usersList.isNullOrEmpty()) {
                for (user in usersList) {
                    Log.d("thesearetheusers", user.user_name)
                }
            } else {
                Log.d("thesearetheusers", "null or empty")
            }
        }

    }
}