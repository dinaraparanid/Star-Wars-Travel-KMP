package com.paranid5.star_wars_travel.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

actual val DataDispatcher: CoroutineDispatcher = Dispatchers.IO
