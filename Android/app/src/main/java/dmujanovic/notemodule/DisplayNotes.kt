package dmujanovic.notemodule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import dmujanovic.core.NoteDisplayer
import dmujanovic.listdisplay_module.ListNoteDisplayer


class DisplayNotes : Fragment() {

    var noteDisplayers: List<NoteDisplayer> = listOf(
        ListNoteDisplayer()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_display_notes, container, false)

        val dr = DataRepository()

        val spinner: Spinner = view.findViewById(R.id.spinner)
        spinner.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, noteDisplayers)



        return view
    }

}