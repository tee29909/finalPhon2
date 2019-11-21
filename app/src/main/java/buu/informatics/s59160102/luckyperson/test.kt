package buu.informatics.s59160102.luckyperson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import buu.informatics.s59160102.luckyperson.databinding.ActivityTestBinding
import buu.informatics.s59160102.luckyperson.databinding.FragmentEditBinding

class test : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ActivityTestBinding = DataBindingUtil.inflate(
            inflater, R.layout.activity_test, container, false)

 binding.button.setOnClickListener {  Toast.makeText(context, "hello", Toast.LENGTH_LONG).show()
     Log.i("AddFragment", "ได้มะ") }


        binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root
    }
}
