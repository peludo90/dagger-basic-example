package com.example.dagger.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.dagger.LogApplication
import com.example.dagger.R
import com.example.dagger.data.LocalDataSource
import com.example.dagger.data.Log
import com.example.dagger.data.room.AppDataBase
import com.example.dagger.data.room.RoomLocalDataSource
import kotlinx.android.synthetic.main.fragment_interaction.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A simple [Fragment] subclass to log interactions
 */
class InteractionFragment : Fragment() {

    @Inject
    lateinit var dataSource: LocalDataSource

    private val clickListener = View.OnClickListener { view ->
        saveLog(getString(R.string.interaction_placeholder, (view as Button).text.toString()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_interaction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnOne.setOnClickListener(clickListener)
        btnTwo.setOnClickListener(clickListener)
        btnThree.setOnClickListener(clickListener)
        btnMessage.setOnClickListener {
            findNavController().navigate(R.id.toMessage)
        }
        btnAll.setOnClickListener {
            findNavController().navigate(R.id.toLogs)
        }
        btnDelete.setOnClickListener {
            clearLogs()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as LogApplication).appComponent.inject(this)
    }

    private fun saveLog(message: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            dataSource.save(Log(message))
        }
    }

    private fun clearLogs() {
        viewLifecycleOwner.lifecycleScope.launch {
            dataSource.clear()
        }
    }
}