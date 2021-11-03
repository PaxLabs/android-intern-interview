package com.example.paxandroidinterview2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paxandroidinterview2.databinding.ActivityScrollingBinding
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var binding: ActivityScrollingBinding? = null
    private val adapter = RandoAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val toolbar: Toolbar = binding!!.toolbar
        setSupportActionBar(toolbar)
        val toolBarLayout: CollapsingToolbarLayout = binding!!.toolbarLayout
        toolBarLayout.title = title
        binding!!.mainRv.layoutManager = LinearLayoutManager(this)
        binding!!.mainRv.adapter = adapter

        val fab: FloatingActionButton = binding!!.fab
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }

        val model = ViewModelProvider(this).get(RandoGenerator::class.java)
        model.start()
    }

    override fun onStart() {
        super.onStart()
        val model = ViewModelProvider(this).get(RandoGenerator::class.java)
        model.content.observe(this, { adapter.setContent(it)})
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}