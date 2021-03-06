package com.example.premierleague.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

/**
 * Created by Ziyad on Nov, 2019
 */

@Entity
data class Team  (
    @SerializedName("id")
    @PrimaryKey
    val id: Int,

    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String,

    @SerializedName("website")
    @ColumnInfo(name = "website")
    val website: String,

    @SerializedName("clubColors")
    @ColumnInfo(name = "clubColors")
    val clubColors: String,

    @SerializedName("venue")
    @ColumnInfo(name = "venue")
    val venue: String,

    @SerializedName("lastUpdated")
    @ColumnInfo(name = "lastUpdated")
    val lastUpdated: String,

    @SerializedName("crestUrl")
    @ColumnInfo(name = "crestUrl")
    val crestUrl: String?,

    @SerializedName("phone")
    @ColumnInfo(name = "phone")
    val phone: String?,

    @SerializedName("founded")
    @ColumnInfo(name = "founded")
    val founded: String?,

    @SerializedName("email")
    @ColumnInfo(name = "email")
    val email: String?,

    @SerializedName("address")
    @ColumnInfo(name = "address")
    val address: String?,

    @ColumnInfo(name = "isUpdated")
    var isUpdated: Boolean,

    @ColumnInfo(name  = "pendingPlayers")
    var pendingPlayers: Boolean,

    @ColumnInfo(name = "favourite")
    var liked: Boolean
    ) {
    @Ignore
    var players: List<Player> = listOf()
}