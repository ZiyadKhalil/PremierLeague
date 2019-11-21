package com.example.premierleague.data.local
import androidx.paging.DataSource
import com.example.premierleague.data.model.Player
import com.example.premierleague.data.model.Team
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Ziyad on Nov, 2019
 */
class AppDatabaseHandler: DatabaseHandler, KoinComponent {


    private val appDatabase: AppDatabase by inject()

    override fun saveTeams(vararg teams: Team): Completable {
        return appDatabase.teamDao().insertTeams(*teams)
    }

    override fun updateTeam(team: Team): Completable {
        return appDatabase.teamDao().updateTeams(team)
    }

    override fun getTeams(): DataSource.Factory<Int,Team> {
        return appDatabase.teamDao().getTeams()
    }

    override fun getLikedTeams(): DataSource.Factory<Int,Team> {
        return appDatabase.teamDao().getLikedTeams()
    }

    override fun likeTeam(team: Team): Completable {
        return appDatabase.teamDao().likeTeam(team.id)
    }

    override fun unlikeTeam(team: Team): Completable {
        return appDatabase.teamDao().unlikeTeam(team.id)
    }

    override fun getPlayers(teamId: Int): Single<List<Player>> {
        return appDatabase.playersDao().getPlayers(teamId)
    }

    override fun savePlayers(players: List<Player>): Completable {
        return  appDatabase.playersDao().savePlayers(players)
    }

    override fun getTeam(teamId: Int): Single<Team> {
        return appDatabase.teamDao().getTeam(teamId)
    }
}