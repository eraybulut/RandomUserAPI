package com.eray.randomuserapi.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.eray.randomuserapi.R
import com.eray.randomuserapi.data.ApiClient
import com.eray.randomuserapi.model.UserResponse
import com.eray.randomuserapi.ui.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){

    private val apiClient by lazy { ApiClient.getApiClient() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title="Random User"
        setSupportActionBar(toolbar)


        getUsers()
        rv.setHasFixedSize(true)
        rv.layoutManager=LinearLayoutManager(this)

        swipe_refresh_layout.setOnRefreshListener {
            getUsers()
        }
    }

    private fun getUsers(){
        apiClient.getUsers(50).enqueue(object :Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful){
                    rv.adapter=UserAdapter(this@MainActivity,response.body()!!.userList)
                    swipe_refresh_layout.isRefreshing=false
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("ERROR",t.message.toString())
            }


        })



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.action_search->{
                val searchView=item.actionView as SearchView
            }
        }
        return super.onOptionsItemSelected(item)
    }
}