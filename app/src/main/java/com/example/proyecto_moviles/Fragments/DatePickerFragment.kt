package com.example.proyecto_moviles.Fragments

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.example.proyecto_moviles.R
import java.util.*

class DatePickerFragment(private val acontext: Context): DialogFragment() {

    private var listener : DatePickerDialog.OnDateSetListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_date_pick, container, false)
        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(acontext, listener, year, month, day)
    }

    companion object{
        fun newInstance(listener: DatePickerDialog.OnDateSetListener, context: Context): DatePickerFragment {
            val fragment = DatePickerFragment(context)
            fragment.listener = listener
            return fragment
        }
    }
}