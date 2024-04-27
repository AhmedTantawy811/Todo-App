package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.todoapp.fragment.ModelBottomSheet
import com.example.todoapp.fragment.SettingFragment
import com.example.todoapp.fragment.TodoListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var addTaskButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {

        //buttonList and button setting
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener {
           if (it.itemId == R.id.list_icon) {
              pushFragment(TodoListFragment())

               } else if (it.itemId == R.id.setting_icon) {
                pushFragment(SettingFragment())

              }

            return@setOnItemSelectedListener true
        }


        //AddButton(bottomSheet)
        addTaskButton=findViewById(R.id.floating_action_button)
        addTaskButton.setOnClickListener {

            val modalBottomSheet = ModelBottomSheet()
            modalBottomSheet.show(supportFragmentManager, ModelBottomSheet.TAG)
        }

        }

        private fun pushFragment(fragment: Fragment) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment, fragment)
                .commit()
        }

}
