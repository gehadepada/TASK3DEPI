package com.example.my3

import android.R.id.edit
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.my3.databinding.ActivityMainBinding
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Glide.with(this)
            .asGif()
            .load(R.drawable.signn)
            .into(binding.signinImage)


        binding.signinButton.setOnClickListener {
            val username = binding.Username.text.toString()
            val password = binding.Password.text.toString()


            if (validateInput(username, password)) {

                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                val ii = Intent(this@MainActivity,MainActivity2::class.java)
                ii.putExtra("name", username)
                startActivity(ii)
                finish()


            }
        }
    }


    private fun validateInput(username: String, password: String): Boolean {
        var valid = true
        if (username.isEmpty()) {
            binding.Username.error = "Enter Username"
            valid = false
        }


        if (password.isEmpty()) {
            binding.Password.error = "Enter Password"
            valid = false
        }

        if (password.length < 8) {
            binding.Password.error = "Password length should be greater than 8"
            valid = false
        }
        val uppercase: Pattern = Pattern.compile("[A-Z]")
        val lowercase: Pattern = Pattern.compile("[a-z]")
        val digit: Pattern = Pattern.compile("[0-9]")


        if (!lowercase.matcher(password).find()) {
            binding.Password.error = "Password must contain at least one lowercase letter"
            valid = false
        }


        if (!uppercase.matcher(password).find()) {
            binding.Password.error = "Password must contain at least one uppercase letter"
            valid = false
        }


        if (!digit.matcher(password).find()) {
            binding.Password.error = "Password must contain at least one digit"
            valid = false
        }



        return valid
    }
}
