package com.gmail.jiangyang5157.memo.app

import androidx.lifecycle.ViewModelProvider
import com.gmail.jiangyang5157.android.router.core.MultiRouter
import com.gmail.jiangyang5157.android.router.fragment.FragmentRouter
import com.gmail.jiangyang5157.core.util.ViewModelFactory
import com.gmail.jiangyang5157.kotlin_kit.model.Key
import com.gmail.jiangyang5157.memo.category.CategoryActivity
import com.gmail.jiangyang5157.memo.app.router.DefaultFragmentTransition
import com.gmail.jiangyang5157.memo.app.router.UriRoute
import com.gmail.jiangyang5157.memo.category.CategoryFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module(includes = [MainAppInjection::class])
class MainAppModule {

    @Provides
    @Singleton
    fun provideRouter(): MultiRouter<String, UriRoute> = MultiRouter {
        when (it) {
            CategoryActivity::class.java.name -> {
                FragmentRouter {
                    transition {
                        register(DefaultFragmentTransition())
                    }
                    fragment {
                        map(Key("app://memo/category")) { CategoryFragment::class }
                    }
                }
            }
            else -> {
                throw IllegalArgumentException("Factory of router $it is not implemented.")
            }
        }
    }
}

@Module()
abstract class MainAppInjection {

    @ContributesAndroidInjector(modules = [])
    abstract fun contributeMainActivity(): CategoryActivity

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
