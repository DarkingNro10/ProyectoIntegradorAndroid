    package com.example.sistemaventas

    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory

    object RetrofitInstance {
        private const val BASE_URL = "http://10.80.98.37:8080/"

        val api: ProductoApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProductoApiService::class.java)
        }
    }
