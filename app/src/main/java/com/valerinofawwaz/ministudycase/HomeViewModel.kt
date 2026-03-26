package com.valerinofawwaz.ministudycase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _announcements = MutableLiveData<List<Announcement>>()
    val announcements: LiveData<List<Announcement>> = _announcements

    init {
        loadAnnouncements()
    }

    private fun loadAnnouncements() {
        val data = listOf(
            Announcement(1, "Kuliah Umum Industri", "10 Maret 2026", "Akademik", "Detail kuliah umum bersama pakar industri migas."),
            Announcement(2, "Beasiswa Universitas Pertamina", "12 Maret 2026", "Beasiswa", "Pendaftaran beasiswa internal periode Genap."),
            Announcement(3, "Lomba Karya Tulis Ilmiah", "15 Maret 2026", "Kompetisi", "Kesempatan memenangkan total hadiah jutaan rupiah."),
            Announcement(4, "Libur Hari Raya Idul Fitri", "20 Maret 2026", "Umum", "Informasi jadwal libur dan operasional kampus."),
            Announcement(5, "Workshop UI/UX Design", "25 Maret 2026", "Workshop", "Belajar desain aplikasi mobile bersama profesional.")
        )
        _announcements.value = data
    }
}