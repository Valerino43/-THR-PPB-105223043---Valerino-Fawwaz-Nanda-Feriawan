package com.valerinofawwaz.ministudycase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.valerinofawwaz.ministudycase.databinding.FragmentAnnouncementDetailBinding

class AnnouncementDetailFragment : Fragment() {
    private var _binding: FragmentAnnouncementDetailBinding? = null
    private val binding get() = _binding!!

    private val args: AnnouncementDetailFragmentArgs by navArgs()
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAnnouncementDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Back button logic
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        
        val id = args.announcementId
        viewModel.announcements.observe(viewLifecycleOwner) { announcements ->
            val detail = announcements.find { it.id == id }
            detail?.let {
                binding.tvDetailTitle.text = it.title
                binding.tvDetailCategory.text = it.category
                binding.tvDetailDate.text = it.date
                binding.tvDetailContent.text = it.content
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}