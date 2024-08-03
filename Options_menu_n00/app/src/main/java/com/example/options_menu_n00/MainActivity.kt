package com.example.options_menu_n00

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.options_menu_n00.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // View binding for activity_main.xml
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* Refresh the screen when the Activity is displayed. */
        refreshScreen(R.string.white_color_item, R.color.white)

        //Connection the toolbar(id: tb1)
        setSupportActionBar(binding.tb1)
    }

    /* Creating menu items based on what we connected to the ToolBar.
    * If this is not done, an empty ToolBar will be displayed*/
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_colors, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.iBlue -> refreshScreen(R.string.blue_color_item, R.color.blue)
            R.id.iRed -> refreshScreen(R.string.red_color_item, R.color.red)
            R.id.iGreen -> refreshScreen(R.string.green_color_item, R.color.green)
            R.id.iYellow -> refreshScreen(R.string.yellow_color_item, R.color.yellow)
            R.id.iPink -> refreshScreen(R.string.pink_color_item, R.color.pink)
            R.id.iWhite -> refreshScreen(R.string.white_color_item, R.color.white)
        }
        return super.onOptionsItemSelected(item)
    }

    /* Update the data on the screen with the data specified in the function parameters:
        * - text in TextView.
        * - background color.*/
    private fun refreshScreen(@StringRes colorName: Int, @ColorRes colorId: Int){
        val cName = getString(colorName)
        binding.apply {
            root.setBackgroundColor(getColor(colorId))
            tvGenInfo.setText(getString(R.string.label_cur_color, cName))
        }
    }
}