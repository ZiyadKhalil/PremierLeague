package com.example.premierleague.data.local
import com.example.premierleague.data.model.Player
import com.example.premierleague.data.model.Team
import io.reactivex.Completable
import io.reactivex.Observable
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Ziyad on Nov, 2019
 */
class AppDatabaseHandler: DatabaseHandler, KoinComponent {


    val appDatabase: AppDatabase by inject()

    override fun saveTeams(vararg teams: Team): Completable {
        return appDatabase.teamDao().insertTeams(*teams)
    }

    override fun updateTeams(vararg teams: Team): Completable {
        return appDatabase.teamDao().updateTeams(*teams)
    }

    override fun getTeams(): Observable<List<Team>> {
        return appDatabase.teamDao().getTeams()
    }

    override fun getPlayers(teamId: Int): Observable<List<Player>> {
        return appDatabase.playersDao().getPlayers(teamId)
    }

    override fun savePlayers(players: List<Player>): Completable {
        return  appDatabase.playersDao().savePlayers(players)
    }

}