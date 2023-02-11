package dmujanovic.notemodule

import com.google.firebase.firestore.FirebaseFirestore

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

}