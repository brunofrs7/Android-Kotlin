package com.example.a16_room

import androidx.recyclerview.widget.RecyclerView
import com.example.a16_room.databinding.RowUserBinding

class UserViewHolder(private val bind: RowUserBinding, private val listener: OnUserListener) :
    RecyclerView.ViewHolder(bind.root) {

    fun bind(user: UserModel) {
        bind.textUsername.text = user.username

        bind.textUsername.setOnClickListener {
            listener.OnClick(user.id)
        }
    }
}

