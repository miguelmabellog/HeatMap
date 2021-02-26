package com.example.heatmap.map

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.heatmap.R
import com.example.heatmap.databinding.FragmentMapBinding


class MapFragment : Fragment() {

    private lateinit var viewModel: MapViewModel
    private lateinit var oneOne: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMapBinding>(
            inflater, R.layout.fragment_map, container, false)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = MapViewModelFactory(application)
        binding.lifecycleOwner=this
        viewModel = ViewModelProvider(this,viewModelFactory).get(MapViewModel::class.java)

        binding.viewModel=viewModel


        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.home_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> {

                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }


}