package com.mario.archcomponent

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: ScoreViewModel by lazy {
        ViewModelProviders.of(this).get(ScoreViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonTeamA.setOnClickListener { viewModel.updateTeamA() }
        buttonTeamB.setOnClickListener { viewModel.updateTeamB() }
        buttonResent.setOnClickListener { viewModel.reset() }

        viewModel.scoreTeamA.observe(this, Observer { value ->
            textTeamA.text = value.toString()
        })

        viewModel.scoreTeamB.observe(this, Observer { value ->
            textTeamB.text = value.toString()
        })
    }
}
