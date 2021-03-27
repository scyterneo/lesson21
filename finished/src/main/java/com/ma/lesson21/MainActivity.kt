package com.ma.lesson21

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ma.lesson21.ui.main.SecondFragment

class MainActivity : AppCompatActivity(), DataListener /* Done 13 */  {
    private lateinit var secondFragment: SecondFragment // Done 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate $savedInstanceState") // Done 1
        setContentView(R.layout.main_activity)
        // Done 20
        val savedSecondFragment = supportFragmentManager.findFragmentByTag(SecondFragment.TAG)
        secondFragment = (savedSecondFragment ?: SecondFragment.newInstance()) as SecondFragment
        // end 20
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                // .replace(R.id.container, SecondFragment.newInstance()) // Done 9
                .replace(R.id.container, secondFragment, SecondFragment.TAG) // Done 21
                .commit()
        }
    }

    // Done 1
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
    // end done 1

    // Done 13
    override fun onTextChanged(text: String) {
        // Log.d(TAG, "onTextChanged $text") // Done 16
        // Done 22
        Log.d(TAG, "onTextChanged $text -> $secondFragment")
        if (secondFragment.isResumed) {
            secondFragment.setMessage(text)
        } else {
            Log.d(TAG, "not resumed")
        }
    }

    // Done 8
    companion object {
        const val TAG = Constants.TAG + "_ma"
    }

}