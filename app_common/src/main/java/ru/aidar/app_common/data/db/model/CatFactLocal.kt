package ru.aidar.app_common.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CatFactTable")
data class CatFactLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val fact: String,
    val length: Int,
)
