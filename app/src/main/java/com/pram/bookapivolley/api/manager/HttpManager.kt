package com.pram.bookapivolley.api.manager

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class HttpManager private constructor(context: Context) {
    val requestQueue: RequestQueue

    init {
        requestQueue = Volley.newRequestQueue(context.applicationContext)
    }

    companion object {
        private var mInstance: HttpManager? = null
        @Synchronized
        fun getInstance(context: Context): HttpManager? {
            if (mInstance == null) {
                mInstance = HttpManager(context)
            }
            return mInstance
        }
    }
}