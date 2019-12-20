package com.percival.avitomap.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.percival.avitomap.R
import com.percival.avitomap.ui.viewmodels.SharedViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SharedViewModel

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        navController = Navigation.findNavController(this, R.id.navHostMain)
        setupNavBottomMenu()
        viewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)
    }


    private fun setupNavBottomMenu(){
        navigation?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
    }

}
