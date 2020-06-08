package id.putraprima.onboarding.ui.front

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import id.putraprima.onboarding.R
import id.putraprima.onboarding.databinding.FragmentFrontBinding

/**
 * A simple [Fragment] subclass.
 */
class FrontFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentFrontBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_front, container, false)
        binding.btnGetStarted.setOnClickListener { view: View ->
            view.findNavController().navigate(FrontFragmentDirections.actionFrontFragmentToOnboardingFragment())
        }
        return binding.root
    }

}
