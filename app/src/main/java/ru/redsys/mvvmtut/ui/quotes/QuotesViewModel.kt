package ru.redsys.mvvmtut.ui.quotes

import android.arch.lifecycle.ViewModel
import ru.redsys.mvvmtut.data.Quote
import ru.redsys.mvvmtut.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}