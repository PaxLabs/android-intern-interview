package com.example.paxandroidinterview2

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.paxandroidinterview2.RandoGenerator.RandoContent
import com.example.paxandroidinterview2.RandoViewHolder.PuffViewHolder

class RandoAdapter(val context: Context) : Adapter<RandoViewHolder>() {
    private var content: List<RandoContent> = emptyList()

    fun setContent(content: List<RandoContent>) {
        this.content = content
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandoViewHolder {
        return PuffViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_puff, parent, false))
    }

    override fun getItemCount(): Int = content.size

    override fun getItemViewType(position: Int): Int = content.getOrNull(position).hashCode()

    override fun onBindViewHolder(holder: RandoViewHolder, position: Int) {
        holder.
    }
}