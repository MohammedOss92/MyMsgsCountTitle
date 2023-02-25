package com.messages.abdallah.mymessages.models

import androidx.room.Embedded

data class FavoriteModelWithTitle(
    @Embedded
    var favoriteModel: FavoriteModel? = null,
    val typeTitle: String = ""
)
