package com.josuerdx.mydatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insert(user: User)

    // Nueva función  eliminar
    @Query("DELETE FROM User WHERE uid = (SELECT MAX(uid) FROM User)")
    suspend fun deleteLastUser()
}