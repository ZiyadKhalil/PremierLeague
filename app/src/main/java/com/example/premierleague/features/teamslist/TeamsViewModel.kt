package com.example.premierleague.features.teamslist

import androidx.paging.PagedList
import com.example.premierleague.base.BaseViewModel
import com.example.premierleague.data.Repo
import com.example.premierleague.data.model.Team
import io.reactivex.*
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by Ziyad on Nov, 2019
 */
class TeamsViewModel(private val repo: Repo): BaseViewModel() {


    //If couldn't save a like on Db
    private lateinit var likeFailureEmitter: ObservableEmitter<Int>
    val likeFailureObservable: Observable<Int> = Observable.create{
        likeFailureEmitter = it
    }

    fun getPagedLikedTeams(): Observable<PagedList<Team>> = repo.getPagedLikedTeams()
    fun getPagedTeams(): Observable<PagedList<Team>> = repo.getPagedTeams()


    fun likeTeam(team: Team) = compositeDisposable.add(repo.likeTeam(team)
        .subscribeOn(Schedulers.io())
        .subscribeBy(
            onError = { likeFailureEmitter.onNext(team.id) }
        )
    )


    fun unlikeTeam(team: Team) = compositeDisposable.add(repo.unlikeTeam(team)
        .subscribeOn(Schedulers.io())
        .subscribeBy(
            onError = { likeFailureEmitter.onNext(team.id) }
        )
    )

}