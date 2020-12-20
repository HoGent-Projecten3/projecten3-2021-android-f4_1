package com.example.faithandroid.data.local

import com.example.faithandroid.models.Post
import com.example.faithandroid.network.local.PostDao

class PostLocalDataSource(val postDao: PostDao) {

    fun getPostsOfBulletinboard() = postDao.getPostsOfBulletinBoard()

    fun getPostsOfBackpack() = postDao.getPostsOfBackpack()

    fun getPostsOfTreasureChest() = postDao.getPostsOfTreasureChest()

    fun deletePostFromBulletinBoard(postId: Int) = postDao.deletePostFromBulletinBoard(postId)

    fun deletePostFromTreasureChest(postId: Int) = postDao.deletePostFromTreasureChest(postId)

    fun deletePostFromBackpack(id: Int) = postDao.deletePostFromBackpack(id)

    fun addExistingPostToBulletinBoard(postId: Int) = postDao.addExistingPostToBulletingBoard(postId)

    fun addExistingPostToTreasureChest(postId: Int) = postDao.addExistingPostToTreasureChest(postId)

    fun savePosts(list: List<Post>) = postDao.insertAll(list)
}
