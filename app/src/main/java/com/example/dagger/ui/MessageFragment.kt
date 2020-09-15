package com.example.dagger.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.dagger.R
import com.example.dagger.data.Log
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_message.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class MessageFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)
            .get(MessageViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        messageCurrentTime.text =
            getString(R.string.messageCurrentTime, viewModel.timeSession.timeSinceCreation())

        messageSave.setOnClickListener {

            val message = if (messageEdt.text.toString()
                    .isNotBlank()
            ) messageEdt.text.toString() else getString(R.string.empty)
            saveLog(
                getString(
                    R.string.messageBuild,
                    message,
                    viewModel.timeSession.timeSinceCreation()
                )
            )
            messageEdt.setText("")
            Toast.makeText(requireContext(), R.string.messageSaved, Toast.LENGTH_SHORT).show()
        }
        viewModel.timeSession.liveDataSecondSinceCreation()
            .observe(viewLifecycleOwner, Observer { seconds ->
                messageCurrentTime.text =
                    getString(R.string.messageCurrentTime, seconds)
            })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //AndroidInjection.inject(this)
    }

    private fun saveLog(message: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.dataSource.save(Log(message))
        }
    }
}