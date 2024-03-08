package eom.improve.kafkaboot.common

data class PaginatedResponse<T>(
    val response : List<T>,
    val currentPage : Long,
    val totalPages : Long
)
