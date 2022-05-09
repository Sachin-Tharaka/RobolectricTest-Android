package com.sachin.roboletrictest

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import junit.framework.Assert.assertEquals
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {
    @Test
    fun check_main_activity(){
        val activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        val textView : TextView = activity.findViewById<TextView>(R.id.text_activity)
        assertEquals("Hello text activity", textView.text)
    }


    @Test
    fun check_first_fragment_text(){
        val fragment = FirstFragment()
        val activity = Robolectric.buildActivity(
            SecondActivity::class.java
        )
            .create()
            .start()
            .resume()
            .get()

        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(fragment, null)
        fragmentTransaction.commit()

        val textView : TextView = activity.findViewById<TextView>(R.id.textview_first)
        assertEquals("hello test fragment", textView.text)
    }
}