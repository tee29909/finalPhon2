package buu.informatics.s59160102.luckyperson


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import buu.informatics.s59160102.luckyperson.databinding.FragmentEditBinding
import buu.informatics.s59160102.luckyperson.databinding.FragmentRandomBinding

/**
 * A simple [Fragment] subclass.
 */
class edit : Fragment() {
    private lateinit var viewModel: ViewModelEdit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentEditBinding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_edit, container, false)
        viewModel = ViewModelProviders.of(this).get(ViewModelEdit ::class.java)


        setHasOptionsMenu(true)
        return binding.root
    }


}
