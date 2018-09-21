package ru.redsys.mvvmtut.data

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao){

    fun addQuote(quote: Quote) = quoteDao.addQuote(quote)

    fun getQuotes() = quoteDao.getQuotes()

    companion object {

        @Volatile
        private var instance: QuoteRepository? = null

        fun getInstance(dao: FakeQuoteDao) = instance ?: synchronized(this) {
            instance ?: QuoteRepository(dao).also { instance = it }
        }
    }
}