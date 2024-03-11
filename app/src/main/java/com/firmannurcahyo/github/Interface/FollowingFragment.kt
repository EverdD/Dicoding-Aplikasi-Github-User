package com.firmannurcahyo.github.Interface

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.firmannurcahyo.github.R
import com.firmannurcahyo.github.UserAdapter
import com.firmannurcahyo.github.databinding.FragmentFollowBinding

//Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy

class FollowingFragment : Fragment(R.layout.fragment_follow) {

    private var _binding: FragmentFollowBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ViewModelFollowing
    private lateinit var adapter: UserAdapter
    private lateinit var username: String

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        username = args?.getString(UserDetailActivity.EXTRA_USERNAME).toString()
        _binding = FragmentFollowBinding.bind(view)

        adapter = UserAdapter()
        adapter.notifyDataSetChanged()

        binding.apply {
            rvUser.setHasFixedSize(true)
            rvUser.layoutManager = LinearLayoutManager(activity)
            rvUser.adapter = adapter
        }

        viewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()
        )[ViewModelFollowing::class.java]
        viewModel.setListFollowing(username)

        viewModel.listFollowing.observe(viewLifecycleOwner) { following ->
            following?.let {
                val followingArrayList = ArrayList(it)
                adapter.setList(followingArrayList)
                showLoading(false)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    //Firman Nurcahyo - 50421524 - Universitas Gunadarma - Dicoding Indonesia - Bangkit Academy

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}