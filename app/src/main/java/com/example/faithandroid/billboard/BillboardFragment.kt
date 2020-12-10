
package com.example.faithandroid.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.faithandroid.R
import com.example.faithandroid.adapters.PostAdapter
import com.example.faithandroid.databinding.BillboardBinding
import com.example.faithandroid.util.Status
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import org.koin.android.ext.android.inject



class BillboardFragment: Fragment() {

    private lateinit var adapter: BillboardGridAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel : BillboardViewModel by inject()
        val binding = DataBindingUtil.inflate<BillboardBinding>(
          inflater,
          R.layout.billboard,
          container,
          false
      );


        binding.lifecycleOwner = viewLifecycleOwner

        //viewModel = ViewModelProvider(this).get(BillboardViewModel::class.java)
        binding.viewmodelBillboard = viewModel

        binding.billboardGridView.adapter = BillboardGridAdapter()

<<<<<<< HEAD

        /*viewModel.status.observe(this.viewLifecycleOwner, Observer {

=======
        viewModel.status.observe(this.viewLifecycleOwner, Observer {
>>>>>>> 8b69d0a (repository spotify + posts niet af)
            val contextView = this.view
            if (contextView != null) {
                Snackbar.make(contextView, "Kon niet verbinding maken met de server", Snackbar.LENGTH_SHORT).setAction(
                    R.string.tryAgain
                )
                {
                    viewModel.properties
                }.show()
            }
        })

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

        //viewModel.getPosts()
    }

    fun dateParsing(date: LocalDateTime){
        SimpleDateFormat("dd/MM/yyyy").format(date)
    }
}