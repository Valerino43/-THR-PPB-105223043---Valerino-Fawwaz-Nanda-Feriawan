package com.valerinofawwaz.ministudycase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.valerinofawwaz.ministudycase.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Logika Back Button di Beranda
        binding.btnBack.setOnClickListener {
            // Karena ini start destination, navigateUp biasanya akan keluar aplikasi
            // atau Anda bisa menyesuaikan tujuannya
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        
        val adapter = AnnouncementAdapter { announcement ->
            val action = HomeFragmentDirections.actionHomeFragmentToAnnouncementDetailFragment(announcement.id)
            findNavController().navigate(action)
        }
        
        binding.rvAnnouncements.adapter = adapter
        
        viewModel.announcements.observe(viewLifecycleOwner) { data ->
            adapter.submitList(data)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}