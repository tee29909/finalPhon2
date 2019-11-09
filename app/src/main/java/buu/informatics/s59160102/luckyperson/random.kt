package buu.informatics.s59160102.luckyperson


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * A simple [Fragment] subclass.
 */
class random : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val args = randomArgs.fromBundle(arguments!!)
        Toast.makeText(context, "numRandom : ${args.numRandom}", Toast.LENGTH_LONG).show()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random, container, false)
    }


}
