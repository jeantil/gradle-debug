package com.malt.some

class UtilityTest{
    fun `should have s`(){
        val utility = Utility("foo")
        assert(utility.s=="foo")
    }
}