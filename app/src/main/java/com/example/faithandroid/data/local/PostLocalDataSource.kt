package com.example.faithandroid.data.local

import com.example.faithandroid.models.Post


class PostLocalDataSource(val postDao: PostDao) {

     fun getPostsOfPlaceByAdolescentEmail(placeType: Int) = postDao.getPostsOfPlaceByAdolescentEmail(placeType)

     fun savePosts(list: List<Post>)  = postDao.insertAll(list)

}