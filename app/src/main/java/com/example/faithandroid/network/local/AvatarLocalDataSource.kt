package com.example.faithandroid.network.local

import com.example.faithandroid.models.Avatar

class AvatarLocalDataSource(private val avatarDao: AvatarDao) {

    fun getAvatar() = avatarDao.getAvatar()

    fun saveAvatar(avatar: Avatar) = avatarDao.insertAll(avatar)
}
