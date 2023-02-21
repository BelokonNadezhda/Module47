package com.example.myapplication19.di

import com.example.myapplication19.di.modules.DatabaseModule
import com.example.myapplication19.di.modules.DomainModule
import com.example.myapplication19.di.modules.RemoteModule
import com.example.myapplication19.viewmodel.HomeFragmentViewModel
import com.example.myapplication19.viewmodel.SettingsFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    //метод для того, чтобы появилась возможность внедрять зависимости в SettingsFragmentViewModel
    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)
}