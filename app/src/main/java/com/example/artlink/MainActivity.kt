package com.example.artlink

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.artlink.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.event -> {
                    replaceFragment(EventsFragment())
                    true
                }
                R.id.collaboration -> {
                    replaceFragment(CollabsFragment())
                    true
                }
                R.id.forum -> {
                    replaceFragment(ForumFragment())
                    true
                }
                else -> false
            }

        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.notification -> {
                startActivity(Intent(this, NotificationActivity::class.java))
            }
            R.id.help -> {
                startActivity(Intent(this, SettingActivity::class.java))
            }

        }
        return super.onOptionsItemSelected(item)
    }
    private fun replaceFragment(fragment: Fragment) {
        fragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}