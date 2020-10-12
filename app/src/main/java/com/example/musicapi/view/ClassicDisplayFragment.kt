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
import kotlinx.android.synthetic.main.fragment_classic.view.*

class ClassicDisplayFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_classic, container, false)

        arguments?.getParcelableArrayList<Track>(KEY_FRAGMENT_DISPLAY)
            ?.let {
                inflateRecyclerView(it, view)
            }

        return view
    }

    private fun inflateRecyclerView(it: ArrayList<Track>, view: View?) {
        val linearLayoutManager =
            LinearLayoutManager(activity)

        view?.rv_classic?.layoutManager = linearLayoutManager
        view?.rv_classic?.adapter = MusicAdapter(it)
    }

    companion object {
        val KEY_FRAGMENT_DISPLAY = "KEY_FRAGMENT_DISPLAY"

        fun createFragmentDisplay(dataSet: List<MusicResponse>)
                : ClassicDisplayFragment {

            val fragmentDisplay = ClassicDisplayFragment()
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