package com.pram.bookapivolley.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.volley.VolleyError
import com.pram.bookapivolley.R
import com.pram.bookapivolley.activity.UpdateActivity
import com.pram.bookapivolley.api.callback.VolleyResponseCallback
import com.pram.bookapivolley.apiController
import com.pram.bookapivolley.dialog.OneButtonDialogFragment
import com.pram.bookapivolley.dialog.TwoButtonDialogFragment
import com.pram.bookapivolley.manager.Contextor
import com.pram.bookapivolley.model.Book
import kotlinx.android.synthetic.main.fragment_detail.view.*
import org.json.JSONObject

/**
 * Created by nuuneoi on 11/16/2014.
 */
class DetailFragment : Fragment(), OneButtonDialogFragment.OnDialogListener, TwoButtonDialogFragment.OnDialogListener {
    private var mContext: Context? = null
    private var mRootView: View? = null
    private var mBook: Book? = null
    private var mBookId: Int? = null

    override fun onOneButtonClick() {
        requireActivity().finish()
    }

    override fun onTwoButtonPositiveClick() {
        removeBook()
    }

    override fun onTwoButtonNegativeClick() {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init(savedInstanceState)
        savedInstanceState?.let { onRestoreInstanceState(it) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)
        initInstances(rootView, savedInstanceState)
        return rootView
    }

    private fun init(savedInstanceState: Bundle?) {
        mContext = Contextor.instance!!.context
    }

    private fun initInstances(rootView: View, savedInstanceState: Bundle?) {
        mRootView = rootView

        if (arguments != null) {
            mBookId = arguments!!.getInt("bookId")
        }

        mRootView!!.btnUpdate!!.apply {mRootView!!.btnUpdate!!
            mRootView!!.btnUpdate!!.setOnClickListener{
                val intent = Intent(mContext, UpdateActivity::class.java)
                intent.putExtra("book", mBook)
                startActivity(intent)
            }
        }

        mRootView!!.btnRemove!!.apply { mRootView!!.btnRemove!!
            mRootView!!.btnRemove!!.setOnClickListener{
                callTwoButtonDialog("Remove?", "Ok", "Cancel")
            }
        }

        //        fetchApi();
    }

    private fun fetchApi() {
        apiController.getBook(mBookId!!, object : VolleyResponseCallback<Any> {
            override fun onResponse(response: Any) {
                val jsonObjectResponse = response as JSONObject
                val id = jsonObjectResponse.optInt("id")
                val title = jsonObjectResponse.optString("title")
                val author = jsonObjectResponse.optString("author")
                val pages = jsonObjectResponse.optString("pages")

                mBook = Book(id, title, author, pages)

                if (mBook != null) {
                    mRootView!!.tvBookId!!.text = mBook!!.id.toString()
                    mRootView!!.tvBookTitle!!.text = mBook!!.title
                    mRootView!!.tvBookAuthor!!.text = mBook!!.author
                    mRootView!!.tvBookPages!!.text = mBook!!.pages
                }
            }

            override fun onErrorResponse(error: VolleyError?) {}
        })
    }

    private fun removeBook() {
        apiController.removeBook(mBookId!!, object : VolleyResponseCallback<Any> {
            override fun onResponse(response: Any) {
                Log.e(TAG, "onResponse: $response")
                callOneButtonDialog("Removed", "Ok")
            }

            override fun onErrorResponse(error: VolleyError?) {
                Log.e(TAG, "onErrorResponse: $error")
            }
        })
    }

    private fun callOneButtonDialog(message: String, submit: String) {
        val fragment = OneButtonDialogFragment.Builder()
                .setMessage(message)
                .setSubmit(submit)
                .build()
        fragment.show(childFragmentManager, "OneButtonDialogFragment")
    }

    private fun callTwoButtonDialog(message: String, positive: String, negative: String) {
        val fragment = TwoButtonDialogFragment.Builder()
                .setMessage(message)
                .setPositive(positive)
                .setNegative(negative)
                .build()
        fragment.show(childFragmentManager, "TwoButtonDialogFragment")
    }

    override fun onResume() {
        super.onResume()
        fetchApi()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Save Instance State here
    }

    private fun onRestoreInstanceState(savedInstanceState: Bundle) { // Restore Instance State here
    }

    companion object {
        private const val TAG = "DetailFragment"
        fun newInstance(bookId: Int): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putInt("bookId", bookId)
            fragment.arguments = args
            return fragment
        }
    }
}