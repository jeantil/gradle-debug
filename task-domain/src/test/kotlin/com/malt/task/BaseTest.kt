package com.malt.task

import com.malt.task.test.DummyBase
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BaseTest{
    @Test
    internal fun `should compile`() {
        val base = DummyBase()
        base.hasBase()
    }
}