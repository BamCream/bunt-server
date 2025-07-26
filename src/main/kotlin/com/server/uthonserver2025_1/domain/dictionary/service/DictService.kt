package com.server.uthonserver2025_1.domain.dictionary.service

import com.server.uthonserver2025_1.domain.dictionary.domain.entity.DictEntity
import com.server.uthonserver2025_1.domain.dictionary.domain.enums.DictStatus
import com.server.uthonserver2025_1.domain.dictionary.domain.repository.DictRepository
import com.server.uthonserver2025_1.domain.dictionary.dto.request.DictRequest
import com.server.uthonserver2025_1.domain.dictionary.dto.request.UnlockDictRequest
import org.springframework.stereotype.Service

@Service
class DictService(
    private val dictRepository: DictRepository
) {
    fun addDict(request: DictRequest) {
        dictRepository.save(
            DictEntity(
                productUrl = request.productUrl,
                productImage = request.productImage,
                productName = request.productName,
                serials = request.serials
            )
        )
    }

    fun unlockDict(request: UnlockDictRequest): Boolean {
        val dict: DictEntity = dictRepository.findById(request.dictId).get()
            dictRepository.save(
                DictEntity(
                    id = dict.id,
                    productUrl = dict.productUrl,
                    productImage = dict.productImage,
                    productName = dict.productName,
                    serials = dict.serials,
                    isUnlocked = DictStatus.UNLOCKED
                )
            )
            return true
    }

    fun getAllDict(): List<DictEntity> {
        return dictRepository.findAll()
    }

    fun getDict(dictId: Long) : DictEntity {
        return dictRepository.findById(dictId).get()
    }
}