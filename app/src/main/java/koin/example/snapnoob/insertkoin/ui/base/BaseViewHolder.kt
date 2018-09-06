package koin.example.snapnoob.insertkoin.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    abstract fun clear()

    abstract fun onBind(postition: Int)
}