package ru.redsys.mvvmtut.utils

import ru.redsys.mvvmtut.data.FakeDb
import ru.redsys.mvvmtut.data.QuoteRepository
import ru.redsys.mvvmtut.ui.quotes.QuotesVmFactory

object Injector {

    fun provideQuotesVmFactory() = QuotesVmFactory(
            QuoteRepository.getInstance(FakeDb.getInstance().dao)
    )
}