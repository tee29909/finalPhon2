package buu.informatics.s59160102.luckyperson

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59160102.luckyperson.database.ListName
import buu.informatics.s59160102.luckyperson.databinding.TextItemViewBinding

class BankDiffCallback : DiffUtil.ItemCallback<ListName>() {
    override fun areItemsTheSame(oldItem: ListName, newItem: ListName): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ListName, newItem: ListName): Boolean {
        return oldItem == newItem
    }
}
class editAdapter(val clickListener: ListBankListener) :  ListAdapter<ListName, randomAdapter.ViewHolder>(BankDiffCallback()) {

    class ViewHolder(val binding: TextItemViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(
            item: ListName,
            clickListener: ListBankListener
        ) {
            binding.clickListener = clickListener
            binding.listname = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TextItemViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.text.text = "id : "+item.id.toString() +" "+item.name.toString()+" "+item.sername.toString()
        holder.bind(item!!, clickListener)

    }

//    fun ViewHolder.bind(
//        item: Pokemon,
//        clickListener: InventoryListener
//    ) {
//
////        val res = itemView.context.resources
////        binding.name.text = convertNameDurationToFormatted(item.name, res)
////        binding.typePower.text = convertTypePowerDurationToFormatted(item.type, item.power, res)
//        binding.clickListener = clickListener
//        binding.pokemon = item
//        binding.executePendingBindings()
//    }
//
}
class ListBankListener(val clickListener: (bankId: Long) -> Unit) {
    fun onClick(bank: ListName) = clickListener(bank.id)
}