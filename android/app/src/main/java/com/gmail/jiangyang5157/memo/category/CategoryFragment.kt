package com.gmail.jiangyang5157.memo.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.jiangyang5157.android.router.core.push
import com.gmail.jiangyang5157.android.router.core.route
import com.gmail.jiangyang5157.memo.R
import com.gmail.jiangyang5157.memo.app.router.RouterFragmentGuest
import com.gmail.jiangyang5157.memo.app.router.UriRoute
import kotlinx.android.synthetic.main.fragment_home.*

class CategoryFragment : Fragment(),
    RouterFragmentGuest<UriRoute> {

    private val route: UriRoute by route()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_info.text = "Category\n\n" +
            "# route=${route.data}\n\n"

        btn_1.setOnClickListener {
            router push UriRoute("app://memo/category")
        }
    }
}
