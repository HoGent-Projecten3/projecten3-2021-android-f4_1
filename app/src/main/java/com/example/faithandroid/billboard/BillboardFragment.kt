
package com.example.faithandroid.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.faithandroid.BillboardGoalCustomClick
import com.example.faithandroid.R
import com.example.faithandroid.databinding.BillboardBinding
import com.example.faithandroid.skyscraper.SkyscraperViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject
import java.util.*

/**
 * This is a fragment for the billboard
 *
 * @property viewModel This is the viewModel for the billboard
 */

class BillboardFragment : Fragment() {

    private lateinit var adapter: BillboardGridAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: BillboardViewModel by inject()
        val skyViewModel: SkyscraperViewModel by inject()
        val binding = DataBindingUtil.inflate<BillboardBinding>(
            inflater,
            R.layout.billboard,
            container,
            false
        )

        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewmodelBillboard = viewModel
        binding.billboardGridView.adapter = BillboardGridAdapter(
            object : BillboardGoalCustomClick {

override fun onClick(goalId: Int) {
skyViewModel.shareGoal(goalId)
}
}
        )

        viewModel.status.observe(
            this.viewLifecycleOwner,
            Observer {
                val contextView = this.view
                        if (contextView != null) {
                            Snackbar.make(contextView, "Kon niet verbinding maken met de server", Snackbar.LENGTH_SHORT).setAction(
                                R.string.tryAgain
                            ) {
                        viewModel.getPosts()
                    }.show()
                        }
            }
        )

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        // viewModel.getPosts()
    }
}
