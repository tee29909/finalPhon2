package buu.informatics.s59160102.luckyperson


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160102.luckyperson.database.editDatabase
import buu.informatics.s59160102.luckyperson.databinding.FragmentEditBinding

/**
 * A simple [Fragment] subclass.
 */
class edit : Fragment() {


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
//        ListPerson.name.observe(this, Observer { newSum ->
//                        binding.textView2.text = newSum.toString()
//        })

        val adapter = randomAdapter(ListBankListener { bankId ->
            //            Toast.makeText(context, "${bankId}", Toast.LENGTH_SHORT).show()
            ListPerson.onListClicked(bankId)
        })

        ListPerson.lists.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })




//        val adapter = ListBankAdapter(ListBankListener { bankId ->
//            //            Toast.makeText(context, "${bankId}", Toast.LENGTH_SHORT).show()
//            viewModel.onBankClicked(bankId)
//        })


//        val adapter = editAdapter(ListBankListener { bankId ->
//            //            Toast.makeText(context, "${bankId}", Toast.LENGTH_SHORT).show()
//            //viewModel.onBankClicked(bankId)
//
//        })







        binding.Add.setOnClickListener { view -> view.findNavController().navigate(editDirections.actionEdit2ToAdd2()) }

        binding.LIstPersonAll.adapter = adapter


        ListPerson.lists.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
        binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root
    }


}
