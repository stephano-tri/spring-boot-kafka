package eom.improve.kafkaboot.common

// change SearchCriteria to data class
data class SearchCriteria(
    var name: String? = null,
    var from: Int? = null,
    var to: Int? = null
)
