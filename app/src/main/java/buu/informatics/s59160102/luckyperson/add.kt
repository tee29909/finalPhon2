package buu.informatics.s59160102.luckyperson


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160102.luckyperson.database.editDatabase
import buu.informatics.s59160102.luckyperson.databinding.FragmentAddBinding

/**
 * A simple [Fragment] subclass.
 */
const val KEY_NAME = "Name_key"
const val KEY_SERNAME = "Sername_key"

class add : Fragment() {
    private var name : String = ""
    private var sername : String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentAddBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = editDatabase.getInstance(application).editDao
        val viewModelFactory = ViewModelAddFactory(dataSource, application)

        val AddPerson =
            ViewModelProviders.of(
                this, viewModelFactory).get(ViewModelAdd::class.java)


        if (savedInstanceState != null) {

            name = savedInstanceState.getString(KEY_NAME, "")
            sername = savedInstanceState.getString(KEY_SERNAME, "")

            //showCurrentState()
            AddPerson.onSetValue(name,sername)

        }
        //AddBankViewModel.onCreateFinish()
        binding.Add.setOnClickListener { view : View ->
            Log.i("AddFragment", "ได้มะ")

            AddPerson.onSave(binding.inputName.text.toString(),binding.InputSername.text.toString())
            view.findNavController().navigate(addDirections.actionAdd2ToEdit2())
        }
        setHasOptionsMenu(true)
        return binding.root
    }





}
