package com.example.android.devbyteviewer.repository

import com.example.android.devbyteviewer.database.VideosDatabase
import com.example.android.devbyteviewer.network.DevByteNetwork
import com.example.android.devbyteviewer.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository for fetching devbyte videos from the network and storing them on disk
 */
// TODO: Implement the VideosRepository class
class VideosRepository( private val database : VideosDatabase){
    suspend fun refreshVideos(){
        withContext(Dispatchers.IO){
            val playlist = DevByteNetwork.devbytes.getPlaylist()
            database.videoDao.insertAll(playlist.asDatabaseModel())
        }
    }
}
