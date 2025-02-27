package com.example.fitnessapp.feature_app.data.repositoryImpl

import com.example.fitnessapp.feature_app.data.network.Connect.supabase
import com.example.fitnessapp.feature_app.domain.model.Sleep
import com.example.fitnessapp.feature_app.domain.repository.SleepRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.supabaseJson

class SleepRepositoryImpl: SleepRepository {
    override suspend fun addSleep(name: String, hours: String, repeat: String) {
        val sleep = Sleep(name = name, hours = hours, repeat = repeat, user_id = getUserId())
        supabase.postgrest["sleep"].insert(sleep)
    }

    override suspend fun getSleep(): Sleep {
        return supabase.postgrest["sleep"].select(
            columns = Columns.list(
                "name",
                "hours",
                "repeat"
            )
        ){
            filter {
                and {
                    eq("user_id", getUserId())
                }
            }
        }.decodeSingle<Sleep>()
    }

    private suspend fun getUserId(): String{
        supabase.auth.awaitInitialization()
        return supabase.auth.currentUserOrNull()?.id?:""
    }
}