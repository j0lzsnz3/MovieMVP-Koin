package koin.example.snapnoob.insertkoin.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.*
import android.view.View
import koin.example.snapnoob.insertkoin.R
import koin.example.snapnoob.insertkoin.data.network.MovieData
import koin.example.snapnoob.insertkoin.ui.base.view.BaseActivity
import koin.example.snapnoob.insertkoin.ui.detailMovie.view.DetailActivity
import koin.example.snapnoob.insertkoin.ui.main.NowPlayingAdapter
import koin.example.snapnoob.insertkoin.ui.main.UpcomingAdapter
import koin.example.snapnoob.insertkoin.ui.main.presenter.MainPresenterContract
import koin.example.snapnoob.insertkoin.util.ItemClickSupport
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity(), MainActivityContract {

    private val presenter: MainPresenterContract<MainActivityContract> by inject()
    private val nowPlayingAdapter: NowPlayingAdapter by inject()
    private val upcomingAdapter: UpcomingAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)

        loadData()
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDettached(tag: String) {
    }

    private fun loadData(){
        presenter.loadNowPlayingData()
        presenter.loadUpcomingData()
    }

    override fun displayNowPlayingMovie(movie: List<MovieData>?) {
        setSnapRecyclerView(rvNowPlaying)
        movie?.let { nowPlayingAdapter.addItem(it) }
        rvNowPlaying.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvNowPlaying.itemAnimator = DefaultItemAnimator()
        rvNowPlaying.adapter = nowPlayingAdapter

        progressNowPlaying.visibility = View.GONE

        ItemClickSupport.addTo(rvNowPlaying).setOnItemClickListener(object : ItemClickSupport.OnItemClickListener {
            override fun onItemClicked(recyclerView: RecyclerView?, position: Int?, view: View) {
                val intent = Intent(applicationContext, DetailActivity::class.java)
                intent.putExtra("TITLE", position?.let { movie?.get(it)?.title })
                intent.putExtra("IMG_URL", position?.let { movie?.get(it)?.poster_path })
                intent.putExtra("DESC", position?.let { movie?.get(it)?.overview })
                startActivity(intent)
            }
        })
    }

    override fun displayUpcomingMovie(movie: List<MovieData>?) {
        setSnapRecyclerView(rvUpcoming)
        movie?.let { upcomingAdapter.addItems(it) }
        rvUpcoming.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvUpcoming.itemAnimator = DefaultItemAnimator()
        rvUpcoming.adapter = upcomingAdapter

        progressUpcoming.visibility = View.GONE

        ItemClickSupport.addTo(rvUpcoming).setOnItemClickListener(object : ItemClickSupport.OnItemClickListener {
            override fun onItemClicked(recyclerView: RecyclerView?, position: Int?, view: View) {
                Snackbar.make(main_activity, "Upcoming Clicked on ${position?.let { movie?.get(it)?.title }}", Snackbar.LENGTH_SHORT).show()
            }
        })
    }
}
