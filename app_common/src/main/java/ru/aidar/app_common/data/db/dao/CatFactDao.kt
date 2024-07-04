package ru.aidar.app_common.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.aidar.app_common.data.db.model.CatFactLocal

@Dao
abstract class CatFactDao {
    @Query("SELECT * FROM CatFactTable")
    abstract fun getCatFacts(): Flow<List<CatFactLocal>>

    @Query("SELECT * FROM CatFactTable WHERE id = :id")
    abstract fun getCatFact(id: Long): Flow<CatFactLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(catFacts: List<CatFactLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(catFact: CatFactLocal)
}
