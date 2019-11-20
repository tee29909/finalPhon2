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
import androidx.navigation.findNavController
import buu.informatics.s59160102.luckyperson.Database.editDatabase
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

        val application = requireNotNull(this.activity).application
        val dataSource = editDatabase.getInstance(application).editDao
        val viewModelFactory = ViewModelEditFactory(dataSource,application)


        val ListPerson =
            ViewModelProviders.of(
                this, viewModelFactory).get(ViewModelEdit::class.java)


        binding.viewModelEdit = ListPerson
        binding.setLifecycleOwner(this)

//        val adapter = ListBankAdapter(ListBankListener { bankId ->
//            //            Toast.makeText(context, "${bankId}", Toast.LENGTH_SHORT).show()
//            viewModel.onBankClicked(bankId)
//        })









        binding.Add.setOnClickListener { view -> view.findNavController().navigate(editDirections.actionEdit2ToAdd2()) }



        setHasOptionsMenu(true)
        return binding.root
    }


}
