package com.codepelita.presensiapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PresensiAdapter(private val list: ArrayList<DataPresensi>):RecyclerView.Adapter<PresensiAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(dataPresensi: DataPresensi){
            with(itemView){
                val nis = "NIS : ${dataPresensi.nis}"
                val nama = "Nama Siswa : ${dataPresensi.nama_siswa}"
                val kelas = "Kelas : ${dataPresensi.kelas}"
                val j_masuk = "Kelas : ${dataPresensi.jam_masuk}"
                val j_pulang = "Kelas : ${dataPresensi.jam_pulang}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_list, parent, false
        )
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return list.size
    }
}