
package com.example.faithandroid.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.faithandroid.R
import com.example.faithandroid.databinding.BillboardBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject
import java.util.*

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
        val binding = DataBindingUtil.inflate<BillboardBinding>(
            inflater,
            R.layout.billboard,
            container,
            false
        )

        binding.lifecycleOwner = viewLifecycleOwner

        // viewModel = ViewModelProvider(this).get(BillboardViewModel::class.java)
        binding.viewmodelBillboard = viewModel

        binding.billboardGridView.adapter = BillboardGridAdapter()

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

        /*viewModel.properties.observe(this.viewLifecycleOwner, Observer
        {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        //showProgress(false)
                        adapter.submitList(resource.data)
                    }
                    Status.LOADING -> {
                        //showProgress(true)
                    }
                    Status.ERROR -> {
                        //showProgress(false)
                    }
                }
            }
        })*/

        /*viewModel.properties.observe(this.viewLifecycleOwner, Observer
        {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        //showProgress(false)
                        adapter.submitList(resource.data)
                    }
                    Status.LOADING -> {
                        //showProgress(true)
                    }
                    Status.ERROR -> {
                        //showProgress(false)
                    }
                }
            }
        })*/

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        // viewModel.getPosts()
    }
}
