package com.saraalves.marketsearch.data.mapper

interface Mapper<S, T> {
    fun map(source: S): T
}