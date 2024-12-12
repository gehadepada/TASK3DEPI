package com.example.my3
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.my3.databinding.ActivityMain2Binding
class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)

        val username = intent.getStringExtra("name")
        binding.welcomeText.text = "Welcome, $username!"


        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, MovieFragment())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_xml, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {

                Toast.makeText(this, "More Movies Clicked", Toast.LENGTH_SHORT).show()


                addMoreMoviesToFragment()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun addMoreMoviesToFragment() {
        val movieFragment = supportFragmentManager.findFragmentById(R.id.fragment) as? MovieFragment
        movieFragment?.let {
            val moreMovies = listOf(
                Movie("Movie 11", R.drawable.reshot_icon_fame_q9b8hzmcaj),
                Movie("Movie 12", R.drawable.reshot_icon_fame_q9b8hzmcaj),
                Movie("Movie 13", R.drawable.reshot_icon_fame_q9b8hzmcaj),
                Movie("Movie 14", R.drawable.reshot_icon_fame_q9b8hzmcaj),
                Movie("Movie 15", R.drawable.reshot_icon_fame_q9b8hzmcaj)
            )


            it.addMoreMovies(moreMovies)
        }
    }

}
