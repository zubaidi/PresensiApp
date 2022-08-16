package com.codepelita.presensiapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PresensiAdapter(private val list: ArrayList<ResultPresensi>):RecyclerView.Adapter<PresensiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_list, parent, false
        )
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(get: ResultPresensi){
            val nis = itemView.findViewById<TextView>(R.id.txtNIS)
            nis.text = get?.nis.toString()
            val nama = itemView.findViewById<TextView>(R.id.txtNama)
            nama.text = get?.nama_siswa
            val kelas = itemView.findViewById<TextView>(R.id.txtKelas)
            kelas.text = get?.kelas
        }
    }
}