package buu.informatics.s59160102.luckyperson


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160102.luckyperson.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
            R.layout.fragment_home,container,false)
        binding.buttonRandom.setOnClickListener { view -> view.findNavController().navigate(R.id.action_home2_to_random2) }
        binding.Edit.setOnClickListener { view -> view.findNavController().navigate(R.id.action_home_to_edit2) }

        setHasOptionsMenu(true)
        return binding.root

    }


}
