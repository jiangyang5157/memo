package com.gmail.jiangyang5157.memo.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.jiangyang5157.android.router.core.MultiRouter
import com.gmail.jiangyang5157.android.router.core.clear
import com.gmail.jiangyang5157.android.router.core.push
import com.gmail.jiangyang5157.android.router.fragment.FragmentRouter
import com.gmail.jiangyang5157.memo.R
import com.gmail.jiangyang5157.memo.app.router.RouterFragmentActivityHost
import com.gmail.jiangyang5157.memo.app.router.UriRoute
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class CategoryActivity : AppCompatActivity(), HasAndroidInjector,
    RouterFragmentActivityHost<UriRoute> {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    @Inject
    lateinit var multiRouter: MultiRouter<String, UriRoute>

    override val router: FragmentRouter<UriRoute>
        get() =  multiRouter[CategoryActivity::class.java.name] as FragmentRouter<UriRoute>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        if (null == savedInstanceState) {
            router {
                clear() push UriRoute("app://memo/category")
            }
        }
        router.setup(
            savedInstanceState,
            R.id.content_router
        )
    }

    override fun onBackPressed() {
        router.popRetainRootImmediateOrFinish()
    }
}
