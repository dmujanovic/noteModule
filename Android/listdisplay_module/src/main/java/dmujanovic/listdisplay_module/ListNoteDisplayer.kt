package dmujanovic.listdisplay_module

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dmujanovic.core.NoteDisplayer
import dmujanovic.core.NoteModel

class ListNoteDisplayer: NoteDisplayer() {

    override fun getName() = "List"
    val fragment = ListNoteFragment()

    override fun getFragment(): Fragment {
        return fragment
    }

    override fun setNotes(notes: List<NoteModel>) {
        val recyclerView = fragment.view?.findViewById<RecyclerView>(R.id.listeventRecyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(fragment.requireContext())
        recyclerView?.adapter = NoteAdapter(notes)
    }


}