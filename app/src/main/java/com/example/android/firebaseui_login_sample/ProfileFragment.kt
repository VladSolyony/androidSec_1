package com.example.android.firebaseui_login_sample

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.bumptech.glide.Glide
import com.example.android.firebaseui_login_sample.databinding.FragmentMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var nameText: TextView
    private lateinit var image: ImageView
    private lateinit var emailText: TextView
    private lateinit var authText: TextView
    private lateinit var binding: FragmentMainBinding


//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
//    ): View? {
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
//
//        binding.goBackButton.text = getString(R.string.go_back_button)
//
//        return binding.root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameText = view.findViewById(R.id.textName)
        image = view.findViewById(R.id.imageView)
        emailText = view.findViewById(R.id.textEmail)
        authText = view.findViewById(R.id.textAuth)

        val user = Firebase.auth.currentUser!!

        user.let {
            if (user.photoUrl != null)
                Glide.with(this).load(user.photoUrl).into(image)
            nameText.text = user.displayName
            emailText.text = user.email
            for (profile in it.providerData) {
                authText.text = profile.providerId
            }
        }
    }
}