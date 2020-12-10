package com.example.faithandroid.data.local

import com.example.faithandroid.models.Post
import com.example.faithandroid.models.PostType


class PostLocalDataSource(val postDao: PostDao) {

     fun getPostsOfBulletinboard() = postDao.getPostsOfBulletinBoard()

     fun getPostsOfBackpack() = postDao.getPostsOfBackpack()

     fun getPostsOfTreasureChest() = postDao.getPostsOfTreasureChest()

     fun getFilteredFromBulletinboard(postType: Int) = postDao.getFilteredFromBulletinboard(postType)

     fun getFilteredFromBackPack(postType: Int) = postDao.getFilteredFromBackPack(postType)

     fun getFilteredFromTreasureChest(postType: Int) = postDao.getFilteredFromTreasureChest(postType)

     fun savePosts(list: List<Post>)  = postDao.insertAll(list)

}