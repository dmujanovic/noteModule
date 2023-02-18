package dmujanovic.listdisplay_module

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import dmujanovic.core.NoteModel

class NoteAdapter(private val noteList: List<NoteModel>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_layout, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentItem = noteList[position]
        holder.noteTitle.text = currentItem.Title
        holder.noteDescription.text = currentItem.Description

        val isVisible: Boolean = currentItem.visibility
        holder.constraintLayout.visibility = if (isVisible) View.VISIBLE else View.GONE

        holder.noteTitle.setOnClickListener {
            currentItem.visibility = !currentItem.visibility
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTitle: TextView = itemView.findViewById(R.id.tvNoteTitle)
        val noteDescription: TextView = itemView.findViewById(R.id.tvNoteDescription)
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.expandedLayout)
    }
}