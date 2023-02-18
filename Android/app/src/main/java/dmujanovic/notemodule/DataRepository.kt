package dmujanovic.notemodule

import android.content.ContentValues
import android.provider.ContactsContract.CommonDataKinds.Contactables
import android.provider.ContactsContract.CommonDataKinds.Note
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import dmujanovic.core.NoteModel

class DataRepository {
    val db = FirebaseFirestore.getInstance()

    fun saveToDatabase(title: String, description: String) {
        val newNote: MutableMap<String, Any> = HashMap()
        newNote["Title"] = title
        newNote["Description"] = description
        db.collection("notes")
            .add(newNote)
            .addOnSuccessListener {

            }
            .addOnFailureListener {

            }
    }

    fun getNotesFromDatabase(callback : (noteList: List<NoteModel>) -> Unit) {

        val pomocnaLista = ArrayList<NoteModel>()
        db.collection("notes").get().addOnSuccessListener {

            if (!it.isEmpty) {
                for (data in it.documents) {
                    val note: NoteModel? = data.toObject(
                        NoteModel::class.java
                    )
                    if (note != null) {
                        pomocnaLista.add(note)
                    }
                }
                callback(pomocnaLista)
            }
        }
            .addOnFailureListener {
                Log.d(ContentValues.TAG, "Nema dokumenta u bazi")
            }
    }

}