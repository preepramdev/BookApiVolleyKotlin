package com.pram.bookapivolley.api.controller

import android.content.Context
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.pram.bookapivolley.api.callback.VolleyResponseCallback
import com.pram.bookapivolley.api.manager.HttpManager
import com.pram.bookapivolley.api.service.BookApiService
import com.pram.bookapivolley.api.service.BookApiUrl
import com.pram.bookapivolley.manager.Contextor.Companion.instance
import com.pram.bookapivolley.model.Book

class BookApiController {
    var mContext: Context?
    var mRequestQueue: RequestQueue

    init {
        mContext = instance!!.context
        mRequestQueue = HttpManager.getInstance(mContext!!)!!.requestQueue
    }

    fun getBooks(callback: VolleyResponseCallback<*>) {
        val name = Throwable().stackTrace[0].methodName
        val method = Request.Method.GET
        val contentType = BookApiService.CONTENT_TYPE_JSON
        val url = BookApiUrl.getBooks
        val body = ""
        val thread: Thread = object : Thread() {
            override fun run() {
                val request: JsonArrayRequest = object : JsonArrayRequest(method, url, null,
                        Response.Listener { response -> callback.onResponse(response) },
                        Response.ErrorListener { error -> callback.onErrorResponse(error) }) {
                    override fun getBodyContentType(): String {
                        return contentType
                    }

                    @Throws(AuthFailureError::class)
                    override fun getHeaders(): Map<String, String> {
                        return super.getHeaders()
                    }

                    override fun getBody(): ByteArray {
                        return body.toByteArray()
                    }
                }
                BookApiService.connectionLogger(name, method, contentType, url, body)
                mRequestQueue.add(request)
            }
        }
        thread.start()
    }

    fun getBook(bookId: Int, callback: VolleyResponseCallback<*>) {
        val name = Throwable().stackTrace[0].methodName
        val method = Request.Method.GET
        val contentType = BookApiService.CONTENT_TYPE_JSON
        val url = BookApiUrl.getBook + bookId
        val body = ""
        val thread: Thread = object : Thread() {
            override fun run() {
                val request: JsonObjectRequest = object : JsonObjectRequest(method, url, null,
                        Response.Listener { response -> callback.onResponse(response) },
                        Response.ErrorListener { error -> callback.onErrorResponse(error) }) {
                    override fun getBodyContentType(): String {
                        return contentType
                    }

                    @Throws(AuthFailureError::class)
                    override fun getHeaders(): Map<String, String> {
                        return super.getHeaders()
                    }

                    override fun getBody(): ByteArray {
                        return body.toByteArray()
                    }
                }
                BookApiService.connectionLogger(name, method, contentType, url, body)
                mRequestQueue.add(request)
            }
        }
        thread.start()
    }

    fun createBook(book: Book, callback: VolleyResponseCallback<*>) {
        val name = Throwable().stackTrace[0].methodName
        val method = Request.Method.POST
        val contentType = BookApiService.CONTENT_TYPE_JSON
        val url = BookApiUrl.createBook
        val body = "\n" +
                "{\n" +
                "    \"title\": \"" + book.title + "\",\n" +
                "    \"author\": \"" + book.author + "\",\n" +
                "    \"pages\": " + book.pages + "\n" +
                "}"
        val thread: Thread = object : Thread() {
            override fun run() {
                val request: JsonObjectRequest = object : JsonObjectRequest(method, url, null,
                        Response.Listener { response -> callback.onResponse(response) },
                        Response.ErrorListener { error -> callback.onErrorResponse(error) }) {
                    override fun getBodyContentType(): String {
                        return contentType
                    }

                    @Throws(AuthFailureError::class)
                    override fun getHeaders(): Map<String, String> {
                        return super.getHeaders()
                    }

                    override fun getBody(): ByteArray {
                        return body.toByteArray()
                    }
                }
                BookApiService.connectionLogger(name, method, contentType, url, body)
                mRequestQueue.add(request)
            }
        }
        thread.start()
    }

    fun updatePutBook(book: Book, callback: VolleyResponseCallback<*>) {
        val name = Throwable().stackTrace[0].methodName
        val method = Request.Method.PUT
        val contentType = BookApiService.CONTENT_TYPE_JSON
        val url = BookApiUrl.putBook + book.id
        val body = "\n" +
                "{\n" +
                "    \"title\": \"" + book.title + "\",\n" +
                "    \"author\": \"" + book.author + "\",\n" +
                "    \"pages\": " + book.pages + "\n" +
                "}"
        val thread: Thread = object : Thread() {
            override fun run() {
                val request: JsonObjectRequest = object : JsonObjectRequest(method, url, null,
                        Response.Listener { response -> callback.onResponse(response) },
                        Response.ErrorListener { error -> callback.onErrorResponse(error) }) {
                    override fun getBodyContentType(): String {
                        return contentType
                    }

                    @Throws(AuthFailureError::class)
                    override fun getHeaders(): Map<String, String> {
                        return super.getHeaders()
                    }

                    override fun getBody(): ByteArray {
                        return body.toByteArray()
                    }
                }
                BookApiService.connectionLogger(name, method, contentType, url, body)
                mRequestQueue.add(request)
            }
        }
        thread.start()
    }

    fun updatePatchBook(book: Book, callback: VolleyResponseCallback<*>) {
        val name = Throwable().stackTrace[0].methodName
        val method = Request.Method.PATCH
        val contentType = BookApiService.CONTENT_TYPE_JSON
        val url = BookApiUrl.patchBook + book.id
        val body = "\n" +
                "{\n" +
                "    \"title\": \"" + book.title + "\",\n" +
                "    \"author\": \"" + book.author + "\",\n" +
                "    \"pages\": " + book.pages + "\n" +
                "}"
        val thread: Thread = object : Thread() {
            override fun run() {
                val request: JsonObjectRequest = object : JsonObjectRequest(method, url, null,
                        Response.Listener { response -> callback.onResponse(response) },
                        Response.ErrorListener { error -> callback.onErrorResponse(error) }) {
                    override fun getBodyContentType(): String {
                        return contentType
                    }

                    @Throws(AuthFailureError::class)
                    override fun getHeaders(): Map<String, String> {
                        return super.getHeaders()
                    }

                    override fun getBody(): ByteArray {
                        return body.toByteArray()
                    }
                }
                BookApiService.connectionLogger(name, method, contentType, url, body)
                mRequestQueue.add(request)
            }
        }
        thread.start()
    }

    fun removeBook(bookId: Int, callback: VolleyResponseCallback<*>) {
        val name = Throwable().stackTrace[0].methodName
        val method = Request.Method.DELETE
        val contentType = BookApiService.CONTENT_TYPE_JSON
        val url = BookApiUrl.getBook + bookId
        val body = ""
        val thread: Thread = object : Thread() {
            override fun run() {
                val request: JsonObjectRequest = object : JsonObjectRequest(method, url, null,
                        Response.Listener { response -> callback.onResponse(response) },
                        Response.ErrorListener { error -> callback.onErrorResponse(error) }) {
                    override fun getBodyContentType(): String {
                        return contentType
                    }

                    @Throws(AuthFailureError::class)
                    override fun getHeaders(): Map<String, String> {
                        return super.getHeaders()
                    }

                    override fun getBody(): ByteArray {
                        return body.toByteArray()
                    }
                }
                BookApiService.connectionLogger(name, method, contentType, url, body)
                mRequestQueue.add(request)
            }
        }
        thread.start()
    }

    companion object {
        private const val TAG = "BookApiController"
    }
}