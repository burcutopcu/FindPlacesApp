package com.burcutopcu.findplacesapp.ui.mainactivity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.burcutopcu.findplacesapp.R
import com.burcutopcu.findplacesapp.models.PlaceResponse
import com.burcutopcu.findplacesapp.ui.mainactivity.listeners.UpdateMapListener
import kotlinx.android.synthetic.main.search_item.view.*

class SearchResultsAdapter(
    private val placeList: List<PlaceResponse>,
    private val updateMapListener: UpdateMapListener
) : RecyclerView.Adapter<SearchResultsAdapter.VerticalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): VerticalViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return VerticalViewHolder(v)
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        holder.bindItems(placeList[position], updateMapListener)
    }

    class VerticalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(option: PlaceResponse, callback: UpdateMapListener) {
            itemView.searchResultText.text = option.name
            itemView.searchResultText.setOnClickListener {
                callback.onSearchItemClick(option)
            }
        }
    }
}