package koin.example.snapnoob.insertkoin.data.network

import com.google.gson.annotations.SerializedName

data class MovieResponse(
        @SerializedName("page")
        val page: Int,

        @SerializedName("total_results")
        val total_results: Int,

        @SerializedName("total_pages")
        val total_pages: Int,

        @SerializedName("results")
        val results: List<MovieData>
)

data class MovieData(
        @SerializedName("vote_count")
        val vote_count: Int,

        @SerializedName("id")
        val id: Int,

        @SerializedName("video")
        val video: Boolean,

        @SerializedName("vote_average")
        val vote_average: Double,

        @SerializedName("title")
        val title: String,

        @SerializedName("popularity")
        val popularity: Float,

        @SerializedName("poster_path")
        val poster_path: String,

        @SerializedName("original_language")
        val original_language: String,

        @SerializedName("original_title")
        val original_title: String,

        @SerializedName("genre_ids")
        val genre_ids: List<Int>,

        @SerializedName("backdrop_path")
        val backdrop_path: Any,

        @SerializedName("adult")
        val adult: Boolean,

        @SerializedName("overview")
        val overview: String,

        @SerializedName("release_date")
        val release_date: String
)