package buu.informatics.s59160102.luckyperson


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160102.luckyperson.databinding.FragmentRandomBinding


/**
 * A simple [Fragment] subclass.
 */
class random : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding: FragmentRandomBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_random, container, false)



        val args = randomArgs.fromBundle(arguments!!)
        Toast.makeText(context, "numRandom : ${args.numRandom}", Toast.LENGTH_LONG).show()
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return binding.root
    }
    private fun getShareIntent() : Intent {
        val args = randomArgs.fromBundle(arguments!!)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, "win win")
        return shareIntent
    }
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }


}
