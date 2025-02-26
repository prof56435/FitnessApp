package com.example.fitnessapp.feature_app.data.repositoryImpl

import com.example.fitnessapp.feature_app.data.network.Connect.supabase
import com.example.fitnessapp.feature_app.domain.model.Profile
import com.example.fitnessapp.feature_app.domain.repository.ProfileRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns

class ProfileRepositoryImpl: ProfileRepository {
    override suspend fun getName(): String {
        val fio = supabase.postgrest["profile"].select(
            columns = Columns.list(
                "fio"
            )
        ){
            filter {
                and {
                    eq("user_id", getUserId())
                }
            }
        }.decodeSingle<Profile>()
        return fio.fio
    }

    override suspend fun getProfile(): Profile {
       return supabase.postgrest["profile"].select(
            columns = Columns.list(
                "fio",
                "target",
                "height",
                "weight",
                "years"
            )
        ){
            filter {
                and {
                    eq("user_id", getUserId())
                }
            }
        }.decodeSingle<Profile>()
    }

    override suspend fun addFioNumber(fio: String, number: String) {
        val profile = Profile(fio = fio, number = number, user_id = getUserId())
        supabase.postgrest["profile"].insert(profile)
    }

    override suspend fun addProfile(target: String, height: Int, weight: Int, years: Int) {
        val profile = Profile(target = target, height = height, weight = weight, years = years)
        supabase.postgrest["profile"].update(profile){
            filter {
                and {
                    eq("user_id", getUserId())
                }
            }
        }
    }

    private suspend fun getUserId(): String{
        supabase.auth.awaitInitialization()
        return supabase.auth.currentUserOrNull()?.id?:""
    }
}