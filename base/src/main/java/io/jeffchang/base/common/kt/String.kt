package io.jeffchang.base.common.kt

val String.appendNewLineIfNeeded: String
    get() = if (endsWith("\n")) {
        this
    } else {
        this + "\n"
    }