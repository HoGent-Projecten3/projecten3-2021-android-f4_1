
package com.example.faithandroid.network.local
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.faithandroid.PlaceType
import com.example.faithandroid.models.Post

@Dao
interface PostDao {

    @androidx.room.Query("select * from posts where bulletinBoard == 1")
    fun getPostsOfBulletinBoard(): LiveData<List<Post>>

    @Query("select * from posts where treasureChest == 1")
    fun getPostsOfTreasureChest(): LiveData<List<Post>>

    @Query("select * from posts")
    fun getPostsOfBackpack(): LiveData<List<Post>>

    @Query("select * from posts where postType ==:postType and bulletinBoard == 1")
    fun getFilteredFromBulletinboard(postType: Int) : LiveData<List<Post>>

    @Query("select * from posts where postType ==:postType and treasureChest == 1")
    fun getFilteredFromTreasureChest(postType: Int) : LiveData<List<Post>>

    @Query("select * from posts where postType ==:postType and backpack == 1")
    fun getFilteredFromBackPack(postType: Int) : LiveData<List<Post>>

    @Query("update posts set bulletinBoard = 0 where id ==:postId")
    fun deletePostFromBulletinBoard(postId: Int)

    @Query("update posts set treasureChest = 0 where id ==:postId")
    fun deletePostFromTreasureChest(postId: Int)

    @Query("delete from posts where id==:id")
    fun deletePostFromBackpack(id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Post>)
}
