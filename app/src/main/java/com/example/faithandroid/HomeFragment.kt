package com.example.faithandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.faithandroid.databinding.AppHomeschermBinding

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<AppHomeschermBinding>(inflater, R.layout.app_homescherm, container, false);

        binding.imgBulletinboard.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_bulletinBoardFragment)
        }
        binding.imgBillboard.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_billboardFragment)
        }

        binding.imgMusicRoom.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_musicRoomFragment)
        }
        binding.imgRugzak.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_backpackFragment)
        }
        binding.imgSchatkist.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_treasureChestFragment)
        }
        binding.imgWinkelcentrum.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_shoppingCenterFragment)
        }
        binding.imgWolkenkrabber.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_skyscraperFragment)
        }



        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            requireView().findNavController()
        )
                || super.onOptionsItemSelected(item)
    }
}