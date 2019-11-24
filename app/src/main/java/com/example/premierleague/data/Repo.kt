package com.example.premierleague.data

import androidx.paging.PagedList
import com.example.premierleague.data.model.Player
import com.example.premierleague.data.model.Team
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Ziyad on Nov, 2019
 */
interface Repo {
    fun getPagedTeams(): Observable<PagedList<Team>>
    fun getPagedLikedTeams(): Observable<PagedList<Team>>
    fun likeTeam(team: Team): Completable
    fun unlikeTeam(team: Team): Completable
    fun getTeam(teamId: Int): Single<Team>
    fun getDatabaseEmptyObservable(): Observable<Single<List<Team>>>
}