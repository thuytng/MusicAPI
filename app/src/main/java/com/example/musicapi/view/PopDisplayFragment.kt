package com.example.musicapi.view

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicapi.R
import com.example.musicapi.model.MusicResponse
import com.example.musicapi.model.Track
import com.example.musicapi.presenter.MusicAdapter
import kotlinx.android.synthetic.main.fragment_pop.view.*

class PopDisplayFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_pop, container, false)

        arguments?.getParcelableArrayList<Track>(KEY_FRAGMENT_DISPLAY)
            ?.let {
                inflateRecyclerView(it, view)
            }

        return view
    }

    private fun inflateRecyclerView(it: ArrayList<Track>, view: View?) {
        val linearLayoutManager =
            LinearLayoutManager(activity)

        view?.rv_pop?.layoutManager = linearLayoutManager
        view?.rv_pop?.adapter = MusicAdapter(it)
    }

    companion object {
        val KEY_FRAGMENT_DISPLAY = "KEY_FRAGMENT_DISPLAY"

        fun createFragmentDisplay(dataSet: List<MusicResponse>)
                : PopDisplayFragment {

            val fragmentDisplay = PopDisplayFragment()
            val bundle = Bundle()

            val parcelableDatSet = MusicResponse(
                dataSet
                        as ArrayList<Track>
            )

            bundle.putParcelableArrayList(
                KEY_FRAGMENT_DISPLAY,
                dataSet as java.util.ArrayList<out Parcelable>
            )

            fragmentDisplay.arguments = bundle
            return fragmentDisplay
        }
    }

}