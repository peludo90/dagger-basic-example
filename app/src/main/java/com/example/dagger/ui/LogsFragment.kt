package com.example.dagger.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_logs.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A simple [Fragment] subclass to show interaction logs
 */
class LogsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)
            .get(LogsViewModel::class.java)
    }

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

    private fun getLogs() {
        viewLifecycleOwner.lifecycleScope.launch {
            logsAdapter.updateData(viewModel.dataSource.getAll())
        }
    }
}