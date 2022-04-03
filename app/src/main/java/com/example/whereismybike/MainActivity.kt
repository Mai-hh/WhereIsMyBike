package com.example.whereismybike

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.example.whereismybike.databinding.ActivityMainBinding
import com.example.whereismybike.ui.BikeListFragment

private const val TAG = "MainActivity2"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        val fromWidget = intent?.extras?.getString("Clicked")
        val fragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as BikeListFragment
        fragment.arguments = Bundle().apply {
            putString("Bike", fromWidget)
        }

        setContentView(binding.root)

    }



}