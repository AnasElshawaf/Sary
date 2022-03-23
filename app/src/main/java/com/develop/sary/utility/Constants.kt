package com.develop.sary.utility


interface Constants {

    interface Url {
        companion object {

            const val banners = baseUrl + "api/v2.5.1/baskets/325514/banners/"
            const val catalog = baseUrl + "api/baskets/325514/catalog/"

        }
    }

    interface HeaderApi {
        companion object {

            const val token = "token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MjgxNTEyLCJ1c2VyX3Bob25lIjoiOTY2NTkxMTIyMzM0In0.phRQP0e5yQrCVfZiN4YlkI8NhXRyqa1fGRx5rvrEv0o"
            const val DeviceType = "android"
            const val DeviceId = "e979a401955ab2a5"
            const val AppVersion = "5.5.0.0.0"
            const val AcceptLanguage = "ar"
            const val Platform = "FLAGSHIP"
            const val Vary = "Accept"
            const val ContentType = "application/json"


        }
    }



    companion object {

        const val baseUrl = "https://staging.sary.to/"


    }
}