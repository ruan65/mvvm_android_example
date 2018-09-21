package ru.redsys.mvvmtut.ui.quotes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quotes.*
import ru.redsys.mvvmtut.R
import ru.redsys.mvvmtut.data.Quote
import ru.redsys.mvvmtut.utils.Injector
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        initializeUi()
    }

    private fun initializeUi() {

        val factory = Injector.provideQuotesVmFactory()

        val viewModel = ViewModelProviders.of(this, factory)
                .get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->

            val sb = StringBuilder()

            quotes?.forEach {
                sb.append("$it\n\n")
            }

            textView_quotes.text = sb.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_author.setText("")
            editText_quote.setText("")
        }
    }
}
