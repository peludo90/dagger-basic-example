package com.example.dagger.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger.R
import com.example.dagger.data.room.AppDataBase
import com.example.dagger.data.room.RoomLocalDataSource
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class LogsFragment : Fragment() {

    val logsAdapter = LogsAdapter(mutableListOf())
    val dataSource by lazy {  RoomLocalDataSource(AppDataBase.getInstance(requireContext())) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logsRv.layoutManager = LinearLayoutManager(requireContext())
        logsRv.adapter = logsAdapter

        getLogs()
    }

    fun getLogs() {
        viewLifecycleOwner.lifecycleScope.launch {
            logsAdapter.updateData(dataSource.getAll())
        }
    }
}