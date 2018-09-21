package ru.redsys.mvvmtut.ui.quotes

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import ru.redsys.mvvmtut.data.QuoteRepository

class QuotesVmFactory(private val quoteRepository: QuoteRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}