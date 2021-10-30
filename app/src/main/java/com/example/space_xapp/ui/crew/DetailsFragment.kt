package com.example.space_xapp.ui.crew

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.space_xapp.R
import com.example.space_xapp.databinding.FragmentCrewDetailsBinding

class DetailsFragment : Fragment(R.layout.fragment_crew_details) {

    private var _binding:FragmentCrewDetailsBinding?=null
    private val binding:FragmentCrewDetailsBinding get() = _binding!!

    private val args by navArgs<DetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding= FragmentCrewDetailsBinding.bind(view)

        binding.apply {

            val crew=args.crew

            name.text = crew.name
            status.text = crew.status
            agency.text = crew.agency

            wikipediaLink.setOnClickListener {
                val uri = Uri.parse(crew.wikipedia)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                root.context.startActivity(intent)
            }

            Glide
                .with(image)
                .load(crew.image)
                .placeholder(R.drawable.ic_person_icon)
                .listener(object :
                    RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility= View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        name.visibility=View.VISIBLE
                        status.visibility=View.VISIBLE
                        agency.visibility=View.VISIBLE
                        wikipediaLink.visibility=View.VISIBLE

                        return false
                    }
                })
                .into(image)


        }
    }

}