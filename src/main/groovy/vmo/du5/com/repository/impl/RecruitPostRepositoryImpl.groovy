package vmo.du5.com.repository.impl

import io.micronaut.transaction.annotation.ReadOnly
import jakarta.inject.Singleton

import vmo.du5.com.entity.RecruitBasicRequirement
import vmo.du5.com.entity.RecruitPostRequirement
import vmo.du5.com.repository.RecruitPostRepository
import javax.persistence.EntityManager
import javax.persistence.TypedQuery

@Singleton
class RecruitPostRepositoryImpl implements RecruitPostRepository {

    private final EntityManager entityManager

    RecruitPostRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager
    }

    /**
     * find all recruit post
     * @return List of {@link RecruitPostRequirement} response data
     */
    @Override
    @ReadOnly
    List<RecruitPostRequirement> findAll() {
        String qlString = "SELECT r FROM RecruitPostRequirement as r LEFT JOIN FETCH r.postContents p"
        TypedQuery<RecruitPostRequirement> query = entityManager.createQuery(qlString, RecruitPostRequirement.class)
        return query.getResultList()
    }

    /**
     * Find recruit post by id
     * @param id {@link RecruitBasicRequirement}
     * @return Optional of {@link RecruitPostRequirement} data
     */
    @Override
    @ReadOnly
    Optional<RecruitPostRequirement> findById(RecruitBasicRequirement id) {
        return Optional.ofNullable(entityManager.find(RecruitPostRequirement.class, id));
    }
}
