package com.siddharthsinghbaghel.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.siddharthsinghbaghel.sqlite.nav_fragments.ContactsFragment
import com.siddharthsinghbaghel.sqlite.nav_fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_bottom_nav.*

class BottomNavActivity : AppCompatActivity() {


    private val homeFragment = HomeFragment()
    private val contactFragment = ContactsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        setSupportActionBar(tbBtmNav)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar!!.title = "Nav"
        tbBtmNav.setNavigationOnClickListener {
            onBackPressed()
        }



        replaceFragments(homeFragment)

        bottomNav.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.home -> {
                    replaceFragments(homeFragment)
                    Toast.makeText(this, "Home btn clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.allContacts -> {
                    replaceFragments(contactFragment)
                    Toast.makeText(this, "Contact btn clicked", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

    }


    private fun replaceFragments(fragment: Fragment){

        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}