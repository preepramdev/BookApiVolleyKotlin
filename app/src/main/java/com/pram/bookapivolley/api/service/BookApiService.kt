package com.pram.bookapivolley.api.service

import android.util.Log
import com.android.volley.Request

class BookApiService {
    //contentType
    //header
    //logger

    companion object {
        private const val TAG = "BookApiService"
        const val CONTENT_TYPE_JSON = "application/json; charset=utf-8"

        fun connectionLogger(name: String, method: Int, contentType: String, url: String, body: String) {
            var methodName = ""
            when (method) {
                Request.Method.GET -> methodName = "GET"
                Request.Method.POST -> methodName = "POST"
                Request.Method.PUT -> methodName = "PUT"
                Request.Method.PATCH -> methodName = "PATCH"
                Request.Method.DELETE -> methodName = "DELETE"
            }
            Log.e(Companion.TAG, "connectionLogger: -->")
            Log.e(Companion.TAG, "connectionLogger: name --> $name")
            Log.e(Companion.TAG, "connectionLogger: method --> $methodName")
            Log.e(Companion.TAG, "connectionLogger: contentType --> $contentType")
            Log.e(Companion.TAG, "connectionLogger: url --> $url")
            Log.e(Companion.TAG, "connectionLogger: body --> $body")
            Log.e(Companion.TAG, "connectionLogger: <--")
        }

        //withHeader
        fun connectionLogger(name: String, method: Int, header: String, contentType: String, url: String, body: String) {
            var methodName = ""
            when (method) {
                Request.Method.GET -> methodName = "GET"
                Request.Method.POST -> methodName = "POST"
                Request.Method.PUT -> methodName = "PUT"
                Request.Method.PATCH -> methodName = "PATCH"
                Request.Method.DELETE -> methodName = "DELETE"
            }
            Log.e(Companion.TAG, "connectionLogger: name => $name")
            Log.e(Companion.TAG, "connectionLogger: method => $methodName")
            Log.e(Companion.TAG, "connectionLogger: header => $header")
            Log.e(Companion.TAG, "connectionLogger: contentType => $contentType")
            Log.e(Companion.TAG, "connectionLogger: url => $url")
            Log.e(Companion.TAG, "connectionLogger: body => $body")
        }
    }
}