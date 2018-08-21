package koin.example.snapnoob.insertkoin.util

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import koin.example.snapnoob.insertkoin.R

class ItemClickSupport private constructor(recyclerView: RecyclerView) {
    var mRecyclerView: RecyclerView? = null
    private var mOnItemClickListener: OnItemClickListener? = null
    private lateinit var mOnItemLongClickListener: OnItemLongClickListener

    init {
        mRecyclerView = recyclerView
        mRecyclerView?.setTag(R.id.item_click_support, this)
        mRecyclerView!!.addOnChildAttachStateChangeListener(mAttachListener())
    }

    private fun mOnClickListener() : View.OnClickListener = View.OnClickListener { view ->
        mOnItemClickListener?.let {
            val holder: RecyclerView.ViewHolder? = mRecyclerView?.getChildViewHolder(view)
            it.onItemClicked(mRecyclerView, holder?.adapterPosition, view)
        }
    }

    private fun mOnLongClickListener() : View.OnLongClickListener = View.OnLongClickListener { view ->
        mRecyclerView.let {
            val holder: RecyclerView.ViewHolder? = it?.getChildViewHolder(view)
            return@OnLongClickListener mOnItemLongClickListener.onItemLongClickListener(it, holder?.adapterPosition, view)
        }

    }

    private fun mAttachListener() : RecyclerView.OnChildAttachStateChangeListener = object : RecyclerView.OnChildAttachStateChangeListener {

        override fun onChildViewAttachedToWindow(view: View?) {
            if (mOnItemClickListener != null){
                view?.setOnClickListener(mOnClickListener())
            }

            view?.setOnLongClickListener(mOnLongClickListener())
        }

        override fun onChildViewDetachedFromWindow(view: View?) {
            Log.d(TAG, "Detached from Window")
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener) : ItemClickSupport {
        mOnItemClickListener = listener
        return this
    }

    fun setOnItemLongClickListener(listener: OnItemLongClickListener) : ItemClickSupport {
        mOnItemLongClickListener = listener
        return this
    }

    private fun detach(view: RecyclerView){
//        view.removeOnChildAttachStateChangeListener(mAttachListener)
        view.tag = R.id.item_click_support
    }
    interface OnItemClickListener {
        fun onItemClicked(recyclerView: RecyclerView?, position: Int?, view: View)
    }

    interface OnItemLongClickListener {
        fun onItemLongClickListener(recyclerView: RecyclerView?, position: Int?, view: View) : Boolean
    }

    companion object {
        var TAG: String = "ItemClickSupport"

        fun addTo(view: RecyclerView): ItemClickSupport {
            var support: ItemClickSupport? = view.getTag(R.id.item_click_support) as? ItemClickSupport
            if (support == null) {
                support = ItemClickSupport(view)
            }
            return support
        }

        fun removeFrom(view: RecyclerView): ItemClickSupport? {
            val support: ItemClickSupport? = view.getTag(R.id.item_click_support) as? ItemClickSupport
            support?.detach(view)
            return support
        }
    }
}