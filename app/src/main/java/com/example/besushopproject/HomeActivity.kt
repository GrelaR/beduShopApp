package com.example.besushopproject


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //Navigation between fragments with the BottomNavigationMenu
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_host_fragment)
        bottomNavigationView.setupWithNavController(
           Navigation.findNavController(
                this,
                R.id.nav_host_container
            )
        )
            }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    //Function to execute the corresponding code depending on the item menu that was clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Analysing if the itemId that was clicked matches any of these cases
        when(item.itemId) {
            R.id.searchItem -> {
                //Throwing Toast
                Toast.makeText(this,"La búsqueda esta deshabilitada",Toast.LENGTH_SHORT).show()
            }
            R.id.redirectItem -> {
                //Intent to open a browser with the URL provided in a new Activity.
                val uri = Uri.parse("https://www.bedu.org")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}






