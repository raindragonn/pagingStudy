package com.raindragonn.pagingstudy.di

import com.raindragonn.pagingstudy.ui.main.MainViewModel
import com.raindragonn.pagingstudy.data.remote.RemoteDataSource
import com.raindragonn.pagingstudy.data.remote.RemoteDataSourceImpl
import com.raindragonn.pagingstudy.data.remote.api.ItunesApi
import com.raindragonn.pagingstudy.data.repository.TrackRepository
import com.raindragonn.pagingstudy.data.repository.TrackRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Koin 을 통한 의존성 주입을 위한 모듈 정의
 *
 */

val appModule = module {

    // ViewModel
    viewModel<MainViewModel> { MainViewModel(get<TrackRepository>()) }

    // Repository
    single<TrackRepository> { TrackRepositoryImpl(get<RemoteDataSource>()) }
    // DataSource
    single<RemoteDataSource> { RemoteDataSourceImpl(get<ItunesApi>()) }
}