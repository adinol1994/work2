package com.example.workpracticetwo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workpracticetwo.databinding.NoteListItemBinding

abstract class NoteListAdapt : RecyclerView.Adapter<NoteListAdapt.ViewHolder>() {

    var items: List<Note> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var itemClick: (Note) -> Unit = {}
    fun itemClick(listener: (Note) -> Unit) {
        itemClick = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_list_item, parent, false)
            return ViewHolder(view)
    }
       fun onBindingViewHolder(holder: ViewHolder, position: Int){
           holder.binding.note = items[position]
           holder.itemView.setOnClickListener {
               itemClick(items[position])
           }
        }
        override fun getItemCount(): Int {
        return items.size
        }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
    var binding = NoteListItemBinding.bind(view)

    }


}
