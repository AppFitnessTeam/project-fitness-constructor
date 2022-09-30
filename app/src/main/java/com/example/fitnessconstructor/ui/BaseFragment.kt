package com.example.fitnessconstructor.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding, VM : BaseViewModel>(
    private val inflate: (inflater: LayoutInflater, parent: ViewGroup?, attachToRoot: Boolean) -> T
) : Fragment() {

    abstract val viewModel: VM

    private var _binding: T? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun observeNavigation() {
        viewModel.navigation.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandle()?.let { handleNavigation(it) }
        }
    }

    private fun handleNavigation(navigationCommand: NavigationCommand) {
        when (navigationCommand) {
            is NavigationCommand.Back -> findNavController().navigateUp()
            is NavigationCommand.ToDirection -> findNavController().navigate(navigationCommand.directions)
        }
    }

    fun navigateBack(){
        viewModel.navigateBack()
    }

    fun toastBlock() {
        Toast.makeText(requireContext(), "Not yet implemented", Toast.LENGTH_SHORT).show()
    }
}