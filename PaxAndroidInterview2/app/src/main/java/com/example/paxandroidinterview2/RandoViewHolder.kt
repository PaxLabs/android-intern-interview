package com.example.paxandroidinterview2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.paxandroidinterview2.RandoGenerator.RandoContent.PodChange
import com.example.paxandroidinterview2.RandoGenerator.RandoContent.Puff

sealed class RandoViewHolder(private val view: View) : ViewHolder(view) {
    data class PuffViewHolder(val v: View) : RandoViewHolder(v) {
        fun bind(info: Puff) {

        }
    }

    data class StrainViewHolder(val v: View) : RandoViewHolder(v) {
        fun bind(info: PodChange) {
        }
    }

    data class ConnectionViewHolder(val v: View) : RandoViewHolder(v) {}
}