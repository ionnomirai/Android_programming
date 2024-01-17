package com.example.options_menu_n00

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import com.example.options_menu_n00.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Connection the toolbar(tb1)
        setSupportActionBar(binding.tb1)
    }

    /* Creating menu items based on what we connected to the ToolBar.
    * If this is not done, an empty ToolBar will be displayed*/
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.iBlue -> refreshScreen(R.string.blue_color_item, R.color.blue)
            R.id.iRed -> Toast.makeText(this, "Red", Toast.LENGTH_LONG).show()
            R.id.iGreen -> Toast.makeText(this, "Green", Toast.LENGTH_LONG).show()
            R.id.iYellow -> Toast.makeText(this, "Yellow", Toast.LENGTH_LONG).show()
            R.id.iPink -> Toast.makeText(this, "Pink", Toast.LENGTH_LONG).show()
            R.id.iWhite -> Toast.makeText(this, "iWhite", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun refreshScreen(@StringRes colorName: Int, @ColorRes colorId: Int){
        val cName = getString(colorName)
        binding.apply {
            root.setBackgroundColor(getColor(colorId))
            tvGenInfo.setText(getString(R.string.label_cur_color, cName))
        }
    }
}