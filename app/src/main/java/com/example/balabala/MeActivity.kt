package com.example.balabala

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.balabala.ui.theme.BalaBalaTheme

class MeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(GlobalVariables.page_num!=1) GlobalVariables.page_num = 1
        setContentView(R.layout.activity_me)
        findViewById<ImageView>(R.id.homeIcon).setImageResource(R.drawable.home)
        findViewById<ImageView>(R.id.meIcon).setImageResource(R.drawable.bilibili_line_pink)

        val homeButton:ImageView = findViewById(R.id.homeIcon)
        homeButton.setOnClickListener{
            finishAfterTransition()
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
        }
    }
}
