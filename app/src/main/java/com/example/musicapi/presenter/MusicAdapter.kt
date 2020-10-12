package com.example.musicapi.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapi.model.Track
import com.squareup.picasso.Picasso
import com.example.musicapi.R
import kotlinx.android.synthetic.main.item_layout.view.*

class MusicAdapter(val dataset: List<Track>)
    : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    class MusicViewHolder(val songView: View)
        : RecyclerView.ViewHolder(songView){

        fun onBind(dataItem: Track){
            songView.tv_trackname.text = dataItem.trackName
            songView.tv_artist.text = dataItem.artistName
            songView.tv_trackprice.text = (dataItem.trackPrice as String) + " USD"
            Picasso.get().load(dataItem.artworkUrl60)
                .into(songView.iv_artwork)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_layout,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.onBind(dataset[position])
    }

    override fun getItemCount() = dataset.size
}