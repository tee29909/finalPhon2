package buu.informatics.s59160102.luckyperson


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160102.luckyperson.databinding.FragmentAddBinding
import buu.informatics.s59160102.luckyperson.databinding.FragmentEditBinding

/**
 * A simple [Fragment] subclass.
 */
class add : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentAddBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add, container, false)


        setHasOptionsMenu(true)
        return binding.root
    }


}
