package com.kotlin.practice.coroutine.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.practice.coroutine.model.User

/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/01/12 22:18
 */
class CoroutinePracticeViewModel : ViewModel() {

    val userLiveData: MutableLiveData<User> by lazy { MutableLiveData() }

}