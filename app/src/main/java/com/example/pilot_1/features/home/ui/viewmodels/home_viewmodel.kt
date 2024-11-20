package com.example.pilot_1.features.home.ui.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.pilot_1.configurations.AppStates
import com.example.pilot_1.configurations.Cubit
import com.example.pilot_1.configurations.ErrorState
import com.example.pilot_1.configurations.LoadingState
import com.example.pilot_1.configurations.SuccessState
import com.example.pilot_1.features.home.domain.models.NewsModel
import com.example.pilot_1.features.home.domain.repo.HomeRepoInterface
import kotlinx.coroutines.launch

class HomeViewModel(
    repo: HomeRepoInterface
) : Cubit<AppStates>(LoadingState()) {

    private val repo: HomeRepoInterface
    init {
        this.repo = repo
        getNews()
    }
    //=========================================
    //========================================= Variables
    //=========================================
    var newsList:List<NewsModel> = mutableListOf<NewsModel>()

    //=========================================
    //========================================= Functions
    //=========================================
    private suspend fun _getNewsDataRequest(): List<NewsModel> {
        return repo.getNewsData()
    }
    //=========================================
    //========================================= Events
    //=========================================
    fun getNews() {
        viewModelScope.launch {
            emit(LoadingState())
            try {
                newsList = _getNewsDataRequest()
                emit(SuccessState())
            } catch (e: Exception) {
                emit(ErrorState())
            }
        }
    }
}