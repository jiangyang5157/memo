package com.gmail.jiangyang5157.memo.app

import com.gmail.jiangyang5157.core.App

class MainApp : App() {

    override fun inject() {
        DaggerMainAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}
