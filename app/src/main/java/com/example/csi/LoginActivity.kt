package com.example.csi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.csi.Interfaces.LoginInterface
import com.example.csi.databinding.ActivityLoginBinding
import com.example.csi.modelclasses.LoginDataClass
import com.example.csi.modelclasses.LoginResponseDataClass
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

binding.button.setOnClickListener {

    val retrofitBuilder=Retrofit.Builder().baseUrl("https://time-table-production.up.railway.app/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val request=retrofitBuilder.create(LoginInterface::class.java)
    val obj=LoginDataClass("divyanshu21153090@akgec.ac.in","#string123")
    val call=request.sendData(obj)
    call.enqueue(object:Callback<LoginResponseDataClass>{
        override fun onResponse(
            call: Call<LoginResponseDataClass>,
            response: Response<LoginResponseDataClass>
        ) {
            Log.d("meow",response.body().toString())
        }

        override fun onFailure(call: Call<LoginResponseDataClass>, t: Throwable) {
            Toast.makeText(this@LoginActivity, "failed", Toast.LENGTH_SHORT).show()
        }
    })

}




    }
}