package com.ma.lesson21.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import com.ma.lesson21.Constants
import com.ma.lesson21.R
import org.w3c.dom.Text
// Done 6
class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
        // Done 8
        const val TAG = Constants.TAG + "_f2"
    }

    private lateinit var dataViewModel: DataViewModel
    private lateinit var message: TextView //Done 18
    private lateinit var messageSecond: TextView // Done 29

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView $savedInstanceState")
        return inflater.inflate(R.layout.second_fragment/* Done 6*/, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated $savedInstanceState")
        dataViewModel = ViewModelProvider(requireActivity() /* Done 35 */).get(DataViewModel::class.java)
        Log.d(TAG, "ViewModel: $dataViewModel") // Done 33
        // Done 31
        dataViewModel.getText().observe(this, {
            messageSecond.text = it // Done 31
        })

        // Done 30
//        dataViewModel.getText().observe(this, object: Observer<String> {
//            override fun onChanged(t: String?) {
//                TODO("Not yet implemented")
//            }
//        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated $savedInstanceState")
        message = view.findViewById(R.id.message) // Done 18
        messageSecond = view.findViewById(R.id.message_second) // Done 29
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

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

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
    }

    // Done 19
    fun setMessage(text: String) {
        Log.d(TAG, "setMessage $text")
        message.text = text
    }

}