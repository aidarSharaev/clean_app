package ru.aidar.menu_impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import ru.aidar.app_common.base.BaseFragment
import ru.aidar.app_common.di.FeatureUtils
import ru.aidar.menu_impl.databinding.FragmentMenuBinding
import ru.aidar.menu_impl.di.MenuFeatureApi
import ru.aidar.menu_impl.di.MenuFeatureComponent

class MenuFragment : BaseFragment<MenuViewModel>() {

    private lateinit var binding: FragmentMenuBinding

    override fun initViews() {
        TODO("Not yet implemented")
    }

    override fun inject() {
        FeatureUtils.getFeature<MenuFeatureComponent>(this, MenuFeatureApi::class.java)
            .menuComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMenuBinding.inflate(inflater)
        val view = binding.root
        binding.menuComposeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Column {
                    ElevatedButton(onClick = { }) {
                        Text("Dogs")
                    }

                    ElevatedButton(onClick = { }, modifier = Modifier.padding(top = 50.dp)) {
                        Text("Cats")
                    }

                    Button(
                        onClick = { viewModel.log() },
                        modifier = Modifier.padding(top = 150.dp),
                    ) {
                        Text(text = "Log")
                    }
                }
            }
        }
        return view
    }
}
