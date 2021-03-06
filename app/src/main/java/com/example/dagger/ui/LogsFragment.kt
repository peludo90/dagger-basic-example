package com.example.dagger.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger.R
import com.example.dagger.data.room.AppDataBase
import com.example.dagger.data.room.RoomLocalDataSource
import kotlinx.android.synthetic.main.fragment_logs.*
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass to show interaction logs
 */
class LogsFragment : Fragment() {

    val logsAdapter = LogsAdapter(mutableListOf())
    val dataSource by lazy { RoomLocalDataSource(AppDataBase.getInstance(requireContext())) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_logs, container, false)
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