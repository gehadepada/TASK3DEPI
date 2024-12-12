package com.example.my3


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.my3.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!


    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieAdapter = MovieAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = movieAdapter
        binding.recyclerView.itemAnimator = DefaultItemAnimator()


        val initialMovies = listOf(
            Movie("Movie 1", R.drawable.reshot_icon_image_correction_c6de7nyuhx),
            Movie("Movie 2", R.drawable.reshot_icon_fame_q9b8hzmcaj),
            Movie("Movie 3", R.drawable.reshot_icon_actress_syf3zqb6hd),
            Movie("Movie 4", R.drawable.reshot_icon_movie_h9d56ejbpf),
            Movie("Movie 5", R.drawable.reshot_icon_movie_poster_v3d8r5jahc),
            Movie("Movie 6", R.drawable.reshot_icon_snacks_ryf974wmd6),
            Movie("Movie 7", R.drawable.reshot_icon_superhero_z5evsxn9gd),
            Movie("Movie 8", R.drawable.signin),
            Movie("Movie 9", R.drawable.reshot_icon_fame_q9b8hzmcaj),
            Movie("Movie 10", R.drawable.reshot_icon_actress_syf3zqb6hd)
        )
        movieAdapter.updateMovies(initialMovies)
    }


    fun addMoreMovies(newMovies: List<Movie>) {
        movieAdapter.addMoreMovies(newMovies)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
