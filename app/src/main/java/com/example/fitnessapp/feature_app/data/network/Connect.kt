package com.example.fitnessapp.feature_app.data.network

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object Connect {
    val supabase = createSupabaseClient(
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imx6a3h5cmxwenNjbm1qanZpY3ZyIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDA0Nzc0MTcsImV4cCI6MjA1NjA1MzQxN30.gM22tE-Z2XOURM-wzfcjC74duFgcscEq0kO3jpH_hIc",
        supabaseUrl = "https://lzkxyrlpzscnmjjvicvr.supabase.co"
    ){
        install(Postgrest)
        install(Auth)
    }
}