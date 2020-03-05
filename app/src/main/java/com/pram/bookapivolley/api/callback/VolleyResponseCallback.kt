package com.pram.bookapivolley.api.callback

import com.android.volley.VolleyError

interface VolleyResponseCallback<T> {
    fun onResponse(response: Any)
    fun onErrorResponse(error: VolleyError?)
}