package com.mario.archcomponent

import android.arch.lifecycle.ViewModelProviders
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {
    @Test
    fun testChangeScore() {
        val vm = getViewModel()
        vm.updateTeamA()
        assertEquals(1, vm.scoreTeamA.value)
        assertEquals(1, vm.scoreTeamB.value)
    }

    @Test
    fun testReset(){
        val vm = getViewModel()
        vm.reset()
        assertEquals(0, vm.scoreTeamA.value)
    }

    private fun getViewModel(): ScoreViewModel{
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        return ViewModelProviders.of(activity).get(ScoreViewModel::class.java)
    }
}
