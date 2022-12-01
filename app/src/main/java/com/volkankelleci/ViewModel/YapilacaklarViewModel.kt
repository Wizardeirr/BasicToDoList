package com.volkankelleci.ViewModel

import androidx.lifecycle.ViewModel
import com.volkankelleci.basictodolist.data.YapilacaklarDao

class YapilacaklarViewModel  constructor(
    private val yapilacaklarDao:YapilacaklarDao

):ViewModel() {
}