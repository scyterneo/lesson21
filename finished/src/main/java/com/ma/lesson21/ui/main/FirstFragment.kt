package com.ma.lesson21.ui.main

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ma.lesson21.Constants
import com.ma.lesson21.DataListener
import com.ma.lesson21.R

class FirstFragment /* Done 3 */: Fragment() {

    companion object {
        // Done 8
        private const val TAG = Constants.TAG + "_f1"
    }

    private lateinit var dataViewModel: DataViewModel
    private lateinit var input: EditText // Done 12
    private lateinit var inputSecond: EditText // Done 12
    private var listener: DataListener? = null // Done 14

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView $savedInstanceState") // Done 2
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated $savedInstanceState") // Done 2
        input = view.findViewById(R.id.input) // Done 12
        inputSecond = view.findViewById(R.id.input_second) // Done 12
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated $savedInstanceState") // Done 2
        dataViewModel = ViewModelProvider(requireActivity() /* Done 35 */).get(DataViewModel::class.java)
        Log.d(TAG, "ViewModel: $dataViewModel") // Done 33
        // Done 15
        input.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d(TAG, "onTextChanged $s -> $listener")
                listener?.onTextChanged(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        // end 15

        // Done 27
        inputSecond.doOnTextChanged { text, _, _, _ ->
            dataViewModel.setText(text.toString())
        }
    }

    // Done 2
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
        // Done 14
        if (context is DataListener) {
            listener = context
        }
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
    // end 2

}
