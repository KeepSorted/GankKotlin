package com.xiasuhuei321.gank_kotlin.datasource.remote

import com.xiasuhuei321.gank_kotlin.datasource.net.ApiStore
import com.xiasuhuei321.gank_kotlin.datasource.bean.GankData
import com.xiasuhuei321.gank_kotlin.datasource.bean.JsonResult
import com.xiasuhuei321.gank_kotlin.datasource.bean.TechBean
import com.xiasuhuei321.gank_kotlin.datasource.net.ReHelper
import com.xiasuhuei321.gank_kotlin.extension.io_main
import io.reactivex.Observable


/**
 * Created by xiasuhuei321 on 2017/8/11.
 * author:luo
 * e-mail:xiasuhuei321@163.com
 */
class RemoteDataImpl private constructor(): RemoteDataSource {

    private var apiStore: ApiStore? = null

    init {
        if (apiStore==null) apiStore =  ReHelper.getInstance().create(ApiStore::class.java)
    }

    companion object {
        val INSTANCE:RemoteDataImpl by lazy { this.INSTANCE }
    }

    override fun getRemoteData(type: String, count: Int, pageIndex: Int): Observable<JsonResult<List<GankData>>> {
        return apiStore!!.getCategoricalData(type,count.toString(),pageIndex.toString())
    }



}