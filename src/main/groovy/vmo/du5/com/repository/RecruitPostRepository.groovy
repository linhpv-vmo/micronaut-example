package vmo.du5.com.repository


import vmo.du5.com.entity.RecruitBasicRequirement
import vmo.du5.com.entity.RecruitPostRequirement

interface RecruitPostRepository {

    List<RecruitPostRequirement> findAll()

    Optional<RecruitPostRequirement> findById(RecruitBasicRequirement id)
}