package com.av.fetchrewardssample.data

import com.av.fetchrewardssample.domain.Item

data class ItemDto(
    val id: Int = -1,
    val listId: Int? = -1,
    val name: String? = null
)

fun ItemDto.toItem() = Item(
    id = id,
    listId = listId,
    name = name
)