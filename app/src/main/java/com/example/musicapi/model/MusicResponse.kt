package com.example.musicapi.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MusicResponse (
    val results: List<Track>
): Parcelable

@Parcelize
data class Track (
    val artistName: String,
    val trackName: String,
    val artworkUrl60: String,
    val trackPrice: Double
): Parcelable