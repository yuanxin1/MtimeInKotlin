package com.lovejiaming.timemovieinkotlin.networkbusiness

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by xiaoxin on 2017/8/24.
 *
 */
@Suppress("SENSELESS_COMPARISON")
class NetWorkRealCall_Time private constructor() {
    //retrofit实例
    private var mRetrofit: Retrofit

    //主构造初始化块
    init {
        val okhttpClient = OkHttpClient.Builder().build()
        mRetrofit = Retrofit.Builder().
                baseUrl(BASE_URL).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).
                client(okhttpClient).
                build()
    }

    //
    fun getHotMovieService() = mRetrofit.create(IHotMovieService::class.java)!!

    //
    fun getMovieDetailService() = mRetrofit.create(IMovieDetailService::class.java)!!

    //
    fun getPersonDetailService() = mRetrofit.create(IMoviePersonDetailService::class.java)!!

    //
    fun getFindFunnyService() = mRetrofit.create(IFindFunnyService::class.java)!!

    //single instance
    companion object {
        //
        var BASE_URL = "https://api-m.mtime.cn/"
        //
        val objectInstance: NetWorkRealCall_Time by lazy {
            NetWorkRealCall_Time()
        }

        fun newInstance(): NetWorkRealCall_Time {
            return objectInstance
        }
    }

}