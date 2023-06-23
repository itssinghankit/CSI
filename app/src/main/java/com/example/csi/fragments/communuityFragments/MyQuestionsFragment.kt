package com.example.csi.fragments.communuityFragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csi.Adapters.CommunityMyQuestionsAdapter
import com.example.csi.Adapters.onMyQuesItemClicked
import com.example.csi.CommunityQeusAddActivity
import com.example.csi.Interfaces.RetrofitInterface
import com.example.csi.R
import com.example.csi.databinding.FragmentMyQuestionsBinding
import com.example.csi.modelclasses.CommunityMyQuesDataClassItem
import com.example.csi.modelclasses.CommunityQuesCreateUpdateReqDataClass
import com.example.csi.service.RetrofitServiceBuilder
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MyQuestionsFragment : Fragment(), onMyQuesItemClicked{
    private lateinit var binding: FragmentMyQuestionsBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var quesList: MutableList<CommunityMyQuesDataClassItem>
    private lateinit var editDialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyQuestionsBinding.inflate(layoutInflater)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        binding.add.setOnClickListener {
            startActivity(Intent(requireContext(),CommunityQeusAddActivity::class.java))
        }

        fetchQuestions()

        //edit dialog popup
        editDialog = Dialog(requireContext())

        return binding.root

    }


    private fun fetchQuestions() {
        sharedPreferences = requireContext().getSharedPreferences("Login", Context.MODE_PRIVATE)

        val call = RetrofitServiceBuilder.buildService(RetrofitInterface::class.java)
            .communityMyQuestions(sharedPreferences.getString("Authorization", "")!!)

        call.enqueue(object : Callback<List<CommunityMyQuesDataClassItem>?> {
            override fun onResponse(
                call: Call<List<CommunityMyQuesDataClassItem>?>,
                response: Response<List<CommunityMyQuesDataClassItem>?>
            ) {

                if (response.isSuccessful) {
                    quesList = (response.body() as MutableList<CommunityMyQuesDataClassItem>?)!!
                    binding.recyclerView.adapter =
                        CommunityMyQuestionsAdapter(quesList!!, context!!, this@MyQuestionsFragment)
                }

                Log.d("meow", response.body().toString())
            }

            override fun onFailure(call: Call<List<CommunityMyQuesDataClassItem>?>, t: Throwable) {
                Toast.makeText(context, "Check Your Network", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun deleteQuesReq(position: Int) {
        val call = RetrofitServiceBuilder.buildService(RetrofitInterface::class.java)
            .communityMyQuestionDelete(
                quesList[position].id.toString(),
                sharedPreferences.getString("Authorization", "")!!
            )
        call.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                if (response.isSuccessful) {
                    Toast.makeText(context, "Deleted Sucessfully", Toast.LENGTH_SHORT).show()
                    quesList.removeAt(position)
                    binding.recyclerView.adapter!!.notifyItemRemoved(position)
                }
            }

            override fun onFailure(call: Call<Void?>, t: Throwable) {
                Toast.makeText(context, "Check your Connection", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showConfirmationDialog(position: Int) {

        val dialogBuilder = AlertDialog.Builder(context, R.style.CustomAlertDialogStyle)
        dialogBuilder.setMessage("Are you sure you want to delete?")

        dialogBuilder.setPositiveButton("Yes") { dialog, which ->
            //TODO:progressbar logic
           deleteQuesReq(position)
        }
        dialogBuilder.setNegativeButton("No") { dialog, which ->
            dialog.dismiss()
        }

        val dialog = dialogBuilder.create()
        dialog.show()

        val buttonYes = dialog.getButton(DialogInterface.BUTTON_POSITIVE)
        val buttonNo = dialog.getButton(DialogInterface.BUTTON_NEGATIVE)

        buttonYes?.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue))
        buttonNo?.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue))

    }

    override fun onEditClicked(position: Int) {

        editDialog.setContentView(R.layout.community_myquestions_editquestion_dialog)
        editDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        var domain = "FRONTEND"

        val arrayList = arrayListOf("FRONTEND", "BACKEND", "APP", "MACHINE LEARNING")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList)
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        editDialog.findViewById<Spinner>(R.id.domain).adapter = adapter

        val call = RetrofitServiceBuilder.buildService(RetrofitInterface::class.java).communityQuesUpdate(sharedPreferences.getString("Authorization", "")!!, quesList[position].id.toString(),
            CommunityQuesCreateUpdateReqDataClass()
        )
    }

    override fun onDeleteClicked(position: Int) {
        showConfirmationDialog(position)
    }

}