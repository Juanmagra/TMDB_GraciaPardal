package com.example.themoviedb_graciapardal.ui.Populares

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.themoviedb_graciapardal.R
import com.example.themoviedb_graciapardal.poko.People
import com.example.themoviedb_graciapardal.ui.popularDetail.PopularDetailActivity
import java.util.*

class MyPopularRecyclerViewAdapter(
    private var values: List<People>
) : RecyclerView.Adapter<MyPopularRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_people, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rootView: View = view.findViewById(R.id.people_item)
        var textViewName: TextView = view.findViewById(R.id.textView_name)
        var textViewGender: TextView = view.findViewById(R.id.textView_gender)
        var textViewKnowFor: TextView = view.findViewById(R.id.textView_knowFor)
        var imageViewPhoto: ImageView = view.findViewById(R.id.imageView_avatar)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentItem = values[position]
        holder.textViewName.text = currentItem.name
        holder.textViewGender.text = if(currentItem.gender.toInt()==1) "Mujer" else "Hombre"
        //Intento de no traer nulos de la lista de knowfor
        /*var knowFor :String = ""
        var contador : Int = 0
        while (contador !=1){
            currentItem.known_for.forEach {
                if (!it.name.isNullOrBlank()){
                    knowFor.plus(it.original_name+"\n")
                    contador+=1
                }
            }*/
        holder.textViewKnowFor.text =   currentItem.known_for[0].original_name.plus("\n")
            .plus( currentItem.known_for[1].original_name.plus("\n"))
            .plus( currentItem.known_for[2].original_name.plus("\n"))
        holder
            .imageViewPhoto.load("https://image.tmdb.org/t/p/original${currentItem.profile_path}")

    }

    fun setData(newPokemons: List<People>) {
        this.values = newPokemons
        // Refresca la IU para que se muestren los nuevos
        // Pokemon en la lista
        notifyDataSetChanged()
    }
}