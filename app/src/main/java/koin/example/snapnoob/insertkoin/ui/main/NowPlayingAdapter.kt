package koin.example.snapnoob.insertkoin.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import koin.example.snapnoob.insertkoin.R
import koin.example.snapnoob.insertkoin.data.network.MovieData
import koin.example.snapnoob.insertkoin.ui.base.BaseAppAdapter
import koin.example.snapnoob.insertkoin.ui.base.BaseViewHolder
import koin.example.snapnoob.insertkoin.util.ext.loadImageMovie
import kotlinx.android.synthetic.main.list_movie_layout.view.*

class NowPlayingAdapter constructor(private var dataItemList: MutableList<MovieData>) : BaseAppAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
            NowPlayingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_movie_layout, parent, false))

    override fun getItemCount(): Int = dataItemList.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.clear()
        holder.onBind(position)
    }

    fun addItem(movieData: List<MovieData>){
        movieData.let {
            dataItemList.addAll(it)
            notifyDataSetChanged()
        }
    }

    inner class NowPlayingViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun clear() {
            itemView.imgMovie.setImageDrawable(null)
            itemView.tvTitle.text = ""
            itemView.ratingBar.rating = 0F
        }

        override fun onBind(postition: Int) {
            inflateData(dataItemList[postition])
        }

        private fun inflateData(movie: MovieData) {
            movie.poster_path.let { itemView.imgMovie.loadImageMovie(it) }
            movie.title.let { itemView.tvTitle.text = it }
            movie.vote_average.let { itemView.ratingBar.rating = it.toFloat() / 2 }
        }
    }
}