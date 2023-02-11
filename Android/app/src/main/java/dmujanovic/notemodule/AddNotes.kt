package dmujanovic.notemodule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_add_notes.*


class AddNotes : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_notes, container, false)
        val repository = DataRepository()
        val btnAddNotes: Button = view.findViewById(R.id.btnAddNotes)
        btnAddNotes.setOnClickListener {
            if(etNoteTitle.text.toString()=="" || etNoteDescription.text.toString()=="")
            {
                Toast.makeText(activity,"Input cannot be empty",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(activity,"Added to database",Toast.LENGTH_SHORT).show()
                repository.saveToDatabase(
                    etNoteTitle.text.toString(),
                    etNoteDescription.text.toString()
                )
                etNoteTitle.setText("")
                etNoteDescription.setText("")
            }
        }
        return view
    }

}