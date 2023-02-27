package com.messages.abdallah.mymessages.db

import android.content.Context
import com.messages.abdallah.mymessages.db.Dao.FavoriteDao
import com.messages.abdallah.mymessages.db.Dao.MsgsDao
import com.messages.abdallah.mymessages.db.Dao.MsgsTypesDao
import com.messages.abdallah.mymessages.models.*

class LocaleSource(context: Context) {

    private var TypesDao: MsgsTypesDao?
    private var Msgs_Dao: MsgsDao?
    private var FavoriteDao: FavoriteDao?

    var ID_Type_id: Int?=null


    init {
        val dataBase = PostDatabas.getInstance(context.applicationContext)
        TypesDao = dataBase.TypesDao()
        Msgs_Dao = dataBase.Msgs_Dao()
        FavoriteDao = dataBase.FavoriteDao()

    }

    companion object {
        private var sourceConcreteClass: LocaleSource? = null
        fun getInstance(context: Context): LocaleSource {
            if (sourceConcreteClass == null)
                sourceConcreteClass = LocaleSource(context)
            return sourceConcreteClass as LocaleSource
        }
    }

    suspend fun getMsgsTypes_Dao(): List<MsgsTypesModel> {
        return TypesDao?.getMsgsTypes_Dao()!!
    }

    suspend fun getMsgsTypesWithCounts(): List<MsgsTypeWithCount>?{
        return TypesDao?.getAllMsgTypesWithCounts()
    }

    suspend fun getMsgs_Dao(id:Int): List<MsgsModel> {
        return Msgs_Dao?.getAllMsgsDao(id)!!
    }

    suspend fun getMsgsWithTitle(id: Int): List<MsgModelWithTitle>{
        return Msgs_Dao?.getAllMsgsDaoWithTitle(id)!!
    }

    suspend fun insertPosts(posts: List<MsgsTypesModel>) {
        TypesDao?.insertPosts(posts)!!
    }

    suspend fun insert_msgs(msgs: List<MsgsModel>) {
        Msgs_Dao?.insert_msgs(msgs)!!
    }

    suspend fun deletePosts() {
        TypesDao?.deleteALlPosts()
    }

    /************************/
    suspend fun add_fav(fav: List<FavoriteModel>){
        FavoriteDao?.add_fav(fav)
    }

    suspend fun getAllFav(): List<FavoriteModel>{
        return FavoriteDao?.getAllFav()!!
    }

}