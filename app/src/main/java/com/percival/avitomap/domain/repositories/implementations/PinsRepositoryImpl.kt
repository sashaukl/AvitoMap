package com.percival.avitomap.domain.repositories.implementations

import com.percival.avitomap.domain.models.Pin

interface PinsRepositoryImpl {
    suspend fun getPinsMap(): Map<String, List<Pin>>
}