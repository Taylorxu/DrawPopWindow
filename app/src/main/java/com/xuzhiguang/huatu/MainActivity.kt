package com.xuzhiguang.huatu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.ViewGroup
import android.widget.PopupWindow
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var pop = PopWindowCanvas(800f, 800f, 30f,100f,100f, baseContext)

        bt_click.setOnClickListener {
         var popw=PopupWindow(800,800)
            popw.contentView=pop
            popw.showAsDropDown(root_layout,100,900)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)

    }

}
