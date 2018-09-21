package ru.redsys.mvvmtut.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

class FakeQuoteDao {

    private val quoteList = mutableListOf<Quote>()

    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>
}