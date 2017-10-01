package com.mario.archcomponent

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by mario on 9/30/17.
 */
class ScoreViewModel: ViewModel() {
    var scoreTeamA = MutableLiveData<Int>().apply { value = 0 }
    var scoreTeamB = MutableLiveData<Int>().apply { value = 0 }

    fun updateTeamA(){
        update(scoreTeamA)
    }

    fun updateTeamB(){
        update(scoreTeamB)
    }

    fun reset(){
        scoreTeamA.value = 0
        scoreTeamB.value = 0
    }

    private fun update(score: MutableLiveData<Int>){
        score.value = score.value?.plus(1)
    }
}