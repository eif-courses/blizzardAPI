package com.teamtreehouse.review;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Marius on 2/6/2017.
 */
public interface ReviewRepository extends
        PagingAndSortingRepository<Review, Long> {
}
