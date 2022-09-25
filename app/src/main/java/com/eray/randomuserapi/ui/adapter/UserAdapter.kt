package com.eray.randomuserapi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eray.randomuserapi.R
import com.eray.randomuserapi.model.Results
import com.eray.randomuserapi.model.UserResponse
import com.squareup.picasso.Picasso

class UserAdapter(var mContext: Context,var userList: List<Results>):RecyclerView.Adapter<UserAdapter.cardViewHolder>() {


    inner class cardViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        var imageViewUserPic:ImageView
        var textViewUserName:TextView
        var textViewUserEmail:TextView
        var textViewUserTel:TextView
        var textViewUserState:TextView

        init {
            imageViewUserPic=itemView.findViewById(R.id.imageViewUserPic)
            textViewUserName=itemView.findViewById(R.id.textViewUserName)
            textViewUserEmail=itemView.findViewById(R.id.textViewUserEmail)
            textViewUserTel=itemView.findViewById(R.id.textViewUserTel)
            textViewUserState=itemView.findViewById(R.id.textViewUserState)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardViewHolder {
        var view=LayoutInflater.from(mContext).inflate(R.layout.item_user,parent,false)

        return cardViewHolder(view)
    }

    override fun onBindViewHolder(holder: cardViewHolder, position: Int) {
        var users=userList[position]

        holder.textViewUserName.text="${users.name.title}.${users.name.first}  ${users.name.last}"
        holder.textViewUserEmail.text=users.eMail

        Picasso
            .get()
            .load(users.picture.large)
            .into(holder.imageViewUserPic)

        holder.textViewUserState.text="${users.location.state} / ${users.location.country}"

        holder.textViewUserTel.text=users.phone




    }

    override fun getItemCount(): Int =userList.size
}