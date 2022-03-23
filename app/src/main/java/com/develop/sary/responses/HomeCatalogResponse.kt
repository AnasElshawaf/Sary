package com.develop.sary.responses

data class HomeCatalogResponse(
    var result: List<Catalog>,
    var status: String,
    val other: Other,
    val message: String,
) {

    data class Catalog(
        val id: Int,
        val metadata: Metadata,
        val title: String,
        val subtitle: String,
        val data: List<CatalogItems>,
        val data_type: String,
        val show_title: Boolean,
        val ui_type: String,
        val row_count: Int,
        val show_more_enabled: Boolean,
        val excluded_business_segments: List<String>
    )

    inner class Metadata {
        var title: String? = null
        var sub_title: String? = null
        var consumable_display: String? = null

    }

    inner class CatalogItems {
        var metadata: Metadata? = null
        var group_id: Int? = null
        var filters: List<Filters>? = null
        var name: String? = null
        var image: String? = null
        var cover: String? = null
        var header: String? = null

    }

    inner class Filters(
        val metadata: Metadata,
        val filter_id: Int,
        val name: String,
        val image: String
    )

    inner class Header(
        val image: String,
        val type: String
    )

    data class Other(

        val show_special_order_view: Boolean,
        val uncompleted_profile_settings: Uncompleted_profile_settings,
        val show_vat: Boolean,
        val header: Header,
        val business_status: Business_status
    )

    inner class Business_status(

        val id: Int,
        val title: String
    )


    inner class Uncompleted_profile_settings(

        val show_tag: Boolean,
        val message: String,
        val image: String,
        val is_completed_profile: Boolean
    )
}