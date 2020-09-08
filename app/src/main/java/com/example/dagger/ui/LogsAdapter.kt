package com.example.dagger.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger.R
import com.example.dagger.data.Log
import com.example.dagger.data.room.LOCALDATETIME_FORMAT
import kotlinx.android.synthetic.main.item_log.view.*
import java.time.format.DateTimeFormatter

class LogsAdapter(val itemsList: MutableList<Log>) : RecyclerView.Adapter<LogHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogHolder {
        return LogHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_log, parent, false)
        )
    }

    override fun getItemCount() = itemsList.size

    override fun onBindViewHolder(holder: LogHolder, position: Int) {
        holder.setData(itemsList[position])
    }

    fun updateData(newItems: List<Log>) {
        itemsList.clear()
        itemsList.addAll(newItems)
        notifyDataSetChanged()
    }
}

class LogHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val parseFormat = DateTimeFormatter.ofPattern(LOCALDATETIME_FORMAT)

    fun setData(log: Log) {
        view.logMessageTxt.text = log.message
        view.logDateTxt.text = log.date.format(parseFormat).toString()
    }

}