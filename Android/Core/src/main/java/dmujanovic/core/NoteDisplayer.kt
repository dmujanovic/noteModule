package dmujanovic.core

import androidx.fragment.app.Fragment

abstract class NoteDisplayer {
    protected abstract fun getName() : String
    abstract fun getFragment() : Fragment
    abstract fun setNotes(notes: List<NoteModel>)
    override fun toString(): String {
        return getName()
    }
}