package com.example.faithandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.faithandroid.databinding.MenuHomeschermBinding

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
        val binding = DataBindingUtil.inflate<MenuHomeschermBinding>(inflater, R.layout.menu_homescherm, container, false);

        binding.imgPrikbord.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_bulletinBoardFragment)
        }
        binding.imgBillboard.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_billboardFragment)
        }
        binding.imgCinema.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_cinemaFragment)
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
}