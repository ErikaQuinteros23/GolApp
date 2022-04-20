package com.erikaquinteros.a03_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Data
    private var scoreTeamA = 0
    private var scoreTeamB = 0

    // Views
    private lateinit var teamAScoreTextView: TextView
    private lateinit var teamBScoreTextView: TextView
    private lateinit var teamAAddButton: Button
    private lateinit var teamBAddButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "OnCreate")
        bind()
        setUpScores(savedInstanceState)
        addListeners()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SCORE_TEAM_A, scoreTeamA)
        outState.putInt(KEY_SCORE_TEAM_B, scoreTeamB)
        Log.d(TAG, "OnSavedInstanceState")
    }

    private fun addListeners() {
        teamAAddButton.setOnClickListener {
            scoreTeamA ++
            updateVisualScores(teamAScoreTextView, scoreTeamA)
        }

        teamBAddButton.setOnClickListener {
            scoreTeamB ++
            updateVisualScores(teamBScoreTextView, scoreTeamB)
        }
    }

    private fun updateVisualScores(view: TextView, score: Int) {
        view.text = score.toString()
    }

    private fun setUpScores(savedInstanceState: Bundle?) {
        savedInstanceState?.let { bundle ->
            scoreTeamA = bundle.getInt(KEY_SCORE_TEAM_A, 0)
            scoreTeamB = bundle.getInt(KEY_SCORE_TEAM_B, 0)
        }
        updateVisualScores(teamAScoreTextView, scoreTeamA)
        updateVisualScores(teamBScoreTextView, scoreTeamB)
    }

    private fun bind() {
        // TEAM A
        teamAScoreTextView = findViewById(R.id.score_team_a_text_view)
        teamAAddButton = findViewById(R.id.action_add_one_team_a)

        // TEAM B
        teamBScoreTextView = findViewById(R.id.score_team_b_text_view)
        teamBAddButton = findViewById(R.id.action_add_one_team_b)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    companion object {
        val TAG = MainActivity::class.simpleName
        private const val KEY_SCORE_TEAM_A = "ScoreTeamA"
        private const val KEY_SCORE_TEAM_B = "ScoreTeamB"
    }
}