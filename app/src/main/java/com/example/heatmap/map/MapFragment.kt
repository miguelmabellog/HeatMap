package com.example.heatmap.map

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.example.heatmap.R
import com.example.heatmap.database.PlantaDatabase
import com.example.heatmap.databinding.FragmentMapBinding
import com.google.android.material.snackbar.Snackbar


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
        val dataSource = PlantaDatabase.getInstance(application).plantaDao

        val viewModelFactory = MapViewModelFactory(dataSource,application)
        binding.lifecycleOwner=this
        viewModel = ViewModelProvider(this,viewModelFactory).get(MapViewModel::class.java)

        val preferences = PreferenceManager.getDefaultSharedPreferences(application)
        if(preferences.getBoolean("save",false)){

            Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    "Cambia los  datos con la opcion editar de la barra superior y guardarlos",
                    Snackbar.LENGTH_INDEFINITE
            ).apply {
                setAction("cerrar", View.OnClickListener {

                })
                show()
            }



        }else{
            Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    "Llena los datos y gurdarlos con la opcion de la barra superior",
                    Snackbar.LENGTH_INDEFINITE
            ).apply {
                setAction("cerrar", View.OnClickListener {

                })
                show()
            }


        }

        viewModel.datos.observe(viewLifecycleOwner, Observer {
            it?.let {
                viewModel.show(it)
            }
        })


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
                val application = requireNotNull(this.activity).application
                val preferences = PreferenceManager.getDefaultSharedPreferences(application)

                if(preferences.getBoolean("save",false)){
                    viewModel.update()
                }else{
                    viewModel.save()
                }
                Toast.makeText(activity,"Se ha guardado correctamente",Toast.LENGTH_SHORT).show()

                true
            }
            R.id.action_edit->{
                viewModel.enableText()

                Snackbar.make(
                        requireActivity().findViewById(android.R.id.content),
                        "Ahora puedes editar los datos",
                        Snackbar.LENGTH_INDEFINITE
                ).apply {
                    setAction("cerrar", View.OnClickListener {

                    })
                    show()
                }

                true
            }


            else -> super.onOptionsItemSelected(item)
        }

    }


}