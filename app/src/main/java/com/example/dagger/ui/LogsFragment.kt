package com.example.dagger.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger.LogApplication
import com.example.dagger.R
import com.example.dagger.data.LocalDataSource
import com.example.dagger.data.room.AppDataBase
import com.example.dagger.data.room.RoomLocalDataSource
import com.example.dagger.di.LOG_ROOM
import kotlinx.android.synthetic.main.fragment_logs.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

/**
 * A simple [Fragment] subclass to show interaction logs
 */
class LogsFragment : Fragment() {

    @Inject
    @Named(LOG_ROOM)
    lateinit var dataSource: LocalDataSource

    private val logsAdapter = LogsAdapter(mutableListOf())

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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as LogApplication).appComponent.inject(this)
    }

    private fun getLogs() {
        viewLifecycleOwner.lifecycleScope.launch {
            logsAdapter.updateData(dataSource.getAll())
        }
    }
}